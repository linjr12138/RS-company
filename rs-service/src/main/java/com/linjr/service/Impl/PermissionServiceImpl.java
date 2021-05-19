package com.linjr.service.Impl;

import com.linjr.contants.Constant;
import com.linjr.entity.db1.SysPermission;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db1.SysPermissionMapper;
import com.linjr.service.PermissionService;
import com.linjr.service.RedisService;
import com.linjr.service.RolePermissionService;
import com.linjr.service.UserRoleService;
import com.linjr.utils.TokenSetting;
import com.linjr.vo.req.PermissionAddReqVO;
import com.linjr.vo.req.PermissionUpdateReqVO;
import com.linjr.vo.resp.PermissionRespNodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private TokenSetting tokenSetting;

    @Override
    public List<SysPermission> selectAll() {
        List<SysPermission> sysPermissions = sysPermissionMapper.selectAll();
        if (!sysPermissions.isEmpty()) {
            for (SysPermission sysPermission :
                    sysPermissions) {
                SysPermission parent = sysPermissionMapper.selectByPrimaryKey(sysPermission.getPid());
                if (parent != null) {
                    sysPermission.setPidName(parent.getName());
                }
            }
        }
        return sysPermissions;
    }

    @Override
    public List<PermissionRespNodeVO> selectAllMenuTree() {
        List<SysPermission> list = sysPermissionMapper.selectAll();
        List<PermissionRespNodeVO> result = new ArrayList<>();
        PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
        respNodeVO.setId("0");
        respNodeVO.setTitle("默认顶级菜单");
        respNodeVO.setChildren(getTree(list, true));
        result.add(respNodeVO);
        return result;
    }

    @Override
    public SysPermission addPermission(PermissionAddReqVO vo) {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(vo, sysPermission);
        verifyForm(sysPermission);
        sysPermission.setId(UUID.randomUUID().toString());
        sysPermission.setCreateTime(new Date());
        int insert = sysPermissionMapper.insertSelective(sysPermission);
        if (insert != 1) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        return sysPermission;
    }

    @Override
    public List<PermissionRespNodeVO> permissionTreeList(String userID) {
        return getTree(getPermissions(userID), true);
    }

    @Override
    public List<PermissionRespNodeVO> selectAllTree() {
        return getTree(selectAll(), false);
    }

    @Override
    public void updatePermission(PermissionUpdateReqVO vo) {
        //校验数据
        SysPermission update = new SysPermission();
        BeanUtils.copyProperties(vo, update);
        verifyForm(update);
        SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(vo.getId());
        if (sysPermission == null) {
            log.info("传入的ID在数据库中不存在");
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        if (!sysPermission.getPid().equals(vo.getPid())) {
            //所属菜单发生变化要校验权限是否在子集
            List<SysPermission> sysPermissions = sysPermissionMapper.selectChild(vo.getId());
            if (!sysPermissions.isEmpty()) {
                throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_UPDATE);
            }
        }
        //保存权限数据
        update.setCreateTime(new Date());
        int i = sysPermissionMapper.updateByPrimaryKeySelective(update);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //判断授权标示符是否发生了变化
        if (!sysPermission.getPerms().equals(vo.getPerms())) {
            List<String> rolesByPermissionId = rolePermissionService.getRoleIdByPermissionId(vo.getId());
            if (!rolesByPermissionId.isEmpty()) {
                List<String> userIdByRoles = userRoleService.getUserIdByRoleIds(rolesByPermissionId);
                if (!userIdByRoles.isEmpty()) {
                    for (String userId : userIdByRoles) {
                        redisService.set(Constant.JWT_REFRESH_KEY + userId, userId, tokenSetting.getAccessTokenExpireTime().toMillis(), TimeUnit.MILLISECONDS);
                        //删除用户缓存的授权信息
                        redisService.delete(Constant.IDENTIFY_CACHE_KEY + userId);
                    }
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletedPermission(String permissionId) {
        //判断是否有子集关联
        List<SysPermission> sysPermissions = sysPermissionMapper.selectChild(permissionId);
        if (!sysPermissions.isEmpty()) {
            throw new BusinessException(BaseResponseCode.ROLE_PERMISSION_RELATION);
        }
        //需要删除角色和菜单关联表数据
        rolePermissionService.removeRoleByPermissionId(permissionId);
        //跟新权限数据
        SysPermission sysPermission = new SysPermission();
        sysPermission.setUpdateTime(new Date());
        sysPermission.setDeleted(0);
        sysPermission.setId(permissionId);
        int i = sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //标记和该菜单权限关联用户（需要主动刷新他肯重新签发）
        List<String> rolesByPermissionId = rolePermissionService.getRoleIdByPermissionId(permissionId);
        if (!rolesByPermissionId.isEmpty()) {
            List<String> userIdByRoles = userRoleService.getUserIdByRoleIds(rolesByPermissionId);
            if (!userIdByRoles.isEmpty()) {
                for (String userId : userIdByRoles) {
                    redisService.set(Constant.JWT_REFRESH_KEY + userId, userId, tokenSetting.getAccessTokenExpireTime().toMillis(), TimeUnit.MILLISECONDS);
                    //删除用户缓存的授权信息
                    redisService.delete(Constant.IDENTIFY_CACHE_KEY + userId);
                }
            }
        }
    }

    @Override
    public List<String> getPermissionByUserId(String userId) {
        List<SysPermission> permissions = getPermissions(userId);
        if (permissions == null || permissions.isEmpty()) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (SysPermission s : permissions) {
            if (!StringUtils.isEmpty(s.getPerms())) {
                result.add(s.getPerms());
            }
        }
        return result;
    }

    @Override
    public List<SysPermission> getPermissions(String userId) {
        List<String> roleIdByUserId = userRoleService.getRoleIdByUserId(userId);
        if (roleIdByUserId.isEmpty()) {
            return null;
        }
        List<String> permissionIdByRoleIds = rolePermissionService.getPermissionIdByRoleIds(roleIdByUserId);
        if (permissionIdByRoleIds.isEmpty()) {
            return null;
        }
        return sysPermissionMapper.selectByIds(permissionIdByRoleIds);
    }

    /**
     * 操作后的菜单类型是目录的时候 父级必须为目录
     * 操作后的菜单类型是菜单的时候，父类必须为目录类型
     * * 操作后的菜单类型是按钮的时候 父类必须为菜单类型
     */
    private void verifyForm(SysPermission sysPermission) {

        SysPermission parent = sysPermissionMapper.selectByPrimaryKey(sysPermission.getPid());
        switch (sysPermission.getType()) {
            case 1:
                if (parent != null) {
                    if (parent.getType() != 1) {
                        throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_CATALOG_ERROR);
                    }
                } else if (!sysPermission.getPid().equals("0")) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_CATALOG_ERROR);
                }
                break;
            case 2:
                if (parent == null || parent.getType() != 1) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_MENU_ERROR);
                }
                if (StringUtils.isEmpty(sysPermission.getUrl())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_NOT_NULL);
                }
                break;
            case 3:
                if (parent == null || parent.getType() != 2) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_BTN_ERROR);
                }
                if (StringUtils.isEmpty(sysPermission.getPerms())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_PERMS_NULL);
                }
                if (StringUtils.isEmpty(sysPermission.getUrl())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_NOT_NULL);
                }
                if (StringUtils.isEmpty(sysPermission.getMethod())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_METHOD_NULL);
                }
                if (StringUtils.isEmpty(sysPermission.getCode())) {
                    throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_CODE_NULL);
                }
                break;
        }
    }

    /**
     * type=true 递归遍历到菜单
     * type=false 递归遍历到按钮
     *
     * @param all
     * @param type
     * @return java.util.List<com.yingxue.lesson.vo.resp.PermissionRespNodeVO>
     * @throws
     * @Author: 小霍
     * @UpdateUser:
     * @Version: 0.0.1
     */
    private List<PermissionRespNodeVO> getTree(List<SysPermission> all, boolean type) {

        List<PermissionRespNodeVO> list = new ArrayList<>();
        if (all == null || all.isEmpty()) {
            return list;
        }
        for (SysPermission sysPermission : all) {
            if (sysPermission.getPid().equals("0")) {
                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
                BeanUtils.copyProperties(sysPermission, respNodeVO);
                respNodeVO.setTitle(sysPermission.getName());
                if (type) {
                    respNodeVO.setChildren(getChildExBtn(sysPermission.getId(), all));
                } else {
                    respNodeVO.setChildren(getChild(sysPermission.getId(), all));
                }

                list.add(respNodeVO);
            }
        }
        return list;
    }

    //递归遍历所有数据
    private List<PermissionRespNodeVO> getChild(String id, List<SysPermission> all) {

        List<PermissionRespNodeVO> list = new ArrayList<>();
        for (SysPermission s :
                all) {
            if (s.getPid().equals(id)) {
                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
                BeanUtils.copyProperties(s, respNodeVO);
                respNodeVO.setTitle(s.getName());
                respNodeVO.setChildren(getChild(s.getId(), all));
                list.add(respNodeVO);
            }
        }
        return list;
    }

    //只递归到菜单
    private List<PermissionRespNodeVO> getChildExBtn(String id, List<SysPermission> all) {
        List<PermissionRespNodeVO> list = new ArrayList<>();
        for (SysPermission s :
                all) {
            if (s.getPid().equals(id) && s.getType() != 3) {
                PermissionRespNodeVO respNodeVO = new PermissionRespNodeVO();
                BeanUtils.copyProperties(s, respNodeVO);
                respNodeVO.setTitle(s.getName());
                respNodeVO.setChildren(getChildExBtn(s.getId(), all));
                list.add(respNodeVO);
            }
        }
        return list;
    }
}

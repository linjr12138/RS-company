package com.linjr.service.Impl;

import com.github.pagehelper.PageHelper;
import com.linjr.contants.Constant;
import com.linjr.entity.db1.SysRole;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db1.SysRoleMapper;
import com.linjr.service.*;
import com.linjr.utils.PageUtil;
import com.linjr.utils.TokenSetting;
import com.linjr.vo.req.AddRoleReqVO;
import com.linjr.vo.req.RolePageReqVO;
import com.linjr.vo.req.RolePermissionOperationReqVO;
import com.linjr.vo.req.RoleUpdateReqVO;
import com.linjr.vo.resp.PageVO;
import com.linjr.vo.resp.PermissionRespNodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private TokenSetting tokenSetting;

    @Override
    public PageVO<SysRole> pageInfo(RolePageReqVO vo) {
        PageHelper.offsetPage(vo.getPageNum(), vo.getPageSize());
        List<SysRole> sysRoles = sysRoleMapper.selectAll(vo);
        return PageUtil.getPage(sysRoles);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRole addRole(AddRoleReqVO vo) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(vo, sysRole);
        sysRole.setId(UUID.randomUUID().toString());
        sysRole.setCreateTime(new Date());
        int i = sysRoleMapper.insertSelective(sysRole);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        if (vo.getPermissions() != null || !vo.getPermissions().isEmpty()) {
            RolePermissionOperationReqVO rolePermissionOperationReqVO = new RolePermissionOperationReqVO();
            rolePermissionOperationReqVO.setRoleId(sysRole.getId());
            rolePermissionOperationReqVO.setPermissionIds(vo.getPermissions());
            rolePermissionService.addRolePermission(rolePermissionOperationReqVO);
        }
        return sysRole;
    }

    @Override
    public List<SysRole> selectAll() {
        return sysRoleMapper.selectAll(new RolePageReqVO());
    }

    @Override
    public SysRole detailInfo(String id) {
        //通过ID获取角色信息
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        if (sysRole == null) {
            log.error("传入的Id：{}不合法", id);
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        //获取所有菜单权限树
        List<PermissionRespNodeVO> permissionRespNodeVOS = permissionService.selectAllTree();
        //获取该角色拥有的菜单权限
        List<String> permissionIdsByRoleId = rolePermissionService.getPermissionIdByRoleId(id);
        Set<String> checkList = new HashSet<>(permissionIdsByRoleId);
        //遍历惨淡权限树的数据
        setChecked(permissionRespNodeVOS, checkList);
        sysRole.setPermissionRespNode(permissionRespNodeVOS);
        return sysRole;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(RoleUpdateReqVO vo) {
        //保存角色基本信息
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(vo.getId());
        if (null == sysRole) {
            log.error("传入的id：{}不合法", vo.getId());
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        BeanUtils.copyProperties(vo, sysRole);
        sysRole.setUpdateTime(new Date());
        int count = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        if (count != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //修改该用户和菜单权限关联数据
        RolePermissionOperationReqVO rolePermissionOperationReqVO = new RolePermissionOperationReqVO();
        rolePermissionOperationReqVO.setRoleId(vo.getId());
        rolePermissionOperationReqVO.setPermissionIds(vo.getPermissions());
        rolePermissionService.addRolePermission(rolePermissionOperationReqVO);
        //标记关联用户
        List<String> userIdsByRoleId = userRoleService.getUserIdByRoleId(vo.getId());
        if (!userIdsByRoleId.isEmpty()) {
            for (String userId : userIdsByRoleId) {
                //标记用户在用户权限认证的时候判断这个是否主动刷过
                redisService.set(Constant.JWT_REFRESH_KEY + userId, userId, tokenSetting.getAccessTokenExpireTime().toMillis(), TimeUnit.MILLISECONDS);
                //删除用户缓存的授权信息
                redisService.delete(Constant.IDENTIFY_CACHE_KEY + userId);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletedRole(String id) {
        //删除角色信息
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setDeleted(0);
        sysRole.setUpdateTime(new Date());
        int i = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //删除角色和菜单权限关联数据
        rolePermissionService.removeByRoleId(id);
        //查村和该用户关联的用户
        List<String> userIdsByRoleId = userRoleService.getUserIdByRoleId(id);
        //删除角色和用户关联的数据
        userRoleService.removeByRoleId(id);
        if (!userIdsByRoleId.isEmpty()) {
            for (String userId : userIdsByRoleId) {
                redisService.set(Constant.JWT_REFRESH_KEY + userId, userId, tokenSetting.getAccessTokenExpireTime().toMillis(), TimeUnit.MILLISECONDS);
                //删除用户缓存的授权信息
                redisService.delete(Constant.IDENTIFY_CACHE_KEY + userId);
            }
        }
    }

    @Override
    public List<String> getNameByUserId(String userId) {
        List<String> roleIdsByUserId = userRoleService.getRoleIdByUserId(userId);
        if (roleIdsByUserId.isEmpty()) {
            return null;
        }
        return sysRoleMapper.selectNamesByIds(roleIdsByUserId);
    }

    private void setChecked(List<PermissionRespNodeVO> list, Set<String> checkList) {
        for (PermissionRespNodeVO nodeVO : list) {
            /**
             * 子集选中从它往上到根目录被选中，父级选中从它到它所有的叶子节点都会被选中
             * 这样我们就直接遍历最低层就可以了
             *
             * */
            if (checkList.contains(nodeVO.getId()) && (nodeVO.getChildren() == null || nodeVO.getChildren().isEmpty())) {
                nodeVO.setChecked(true);
            }
            setChecked((List<PermissionRespNodeVO>) nodeVO.getChildren(), checkList);
        }
    }

}

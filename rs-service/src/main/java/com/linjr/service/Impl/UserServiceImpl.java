package com.linjr.service.Impl;

import com.github.pagehelper.PageHelper;
import com.linjr.contants.Constant;
import com.linjr.entity.db1.SysDept;
import com.linjr.entity.db1.SysUser;
import com.linjr.entity.db2.BaseClientShop;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db1.SysDeptMapper;
import com.linjr.mapper.db1.SysUserMapper;
import com.linjr.mapper.db2.BaseClientShopMapper;
import com.linjr.service.*;
import com.linjr.utils.JwtTokenUtil;
import com.linjr.utils.PageUtil;
import com.linjr.utils.PasswordUtils;
import com.linjr.utils.TokenSetting;
import com.linjr.vo.req.*;
import com.linjr.vo.resp.LoginRespVO;
import com.linjr.vo.resp.PageVO;

import com.linjr.vonew.UserOwnRoleRespVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private TokenSetting tokenSetting;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private BaseClientShopService baseClientShopService;

    @Override
    public LoginRespVO login(LoginReqVO vo) {
        LoginRespVO loginRespVO = new LoginRespVO();
            if (vo.getUserType().equals("2")) {/*用户登录类型(1:店铺,2:后台账号)*/
                SysUser sysUser = sysUserMapper.selectByUsername(vo.getUsername());
                if (sysUser == null) {
                    throw new BusinessException(BaseResponseCode.ACCOUNT_ERROR);
                }
                if (sysUser.getStatus() == 2) {
                    throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK_TIP);
                }
                if (!PasswordUtils.matches(sysUser.getSalt(), vo.getPassword(), sysUser.getPassword())) {
                    throw new BusinessException(BaseResponseCode.ACCOUNT_PASSWORD_ERROR);
                }
                Map<String, Object> claims = new HashMap<>();
                claims.put(Constant.JWT_USER_NAME, sysUser.getUsername());
                claims.put(Constant.ROLES_INFOS_KEY, getRoleByUserId(sysUser.getId()));
                claims.put(Constant.PERMISSIONS_INFOS_KEY, getPermissionByUserId(sysUser.getId()));
                String accessToken = JwtTokenUtil.getAccessToken(sysUser.getId(), claims);
                log.info("accessToken{}", accessToken);

                //刷新Token
                Map<String, Object> refreshclaims = new HashMap<>();
                refreshclaims.put(Constant.JWT_REFRESH_KEY, sysUser.getUsername());
                String refreshToken = null;
                if (vo.getType().equals("1")) {
                    refreshToken = JwtTokenUtil.getRefreshToken(sysUser.getId(), refreshclaims);
                } else {
                    refreshToken = JwtTokenUtil.getRefreshAppToken(sysUser.getId(), refreshclaims);
                }
                log.info("refreshToken{}", refreshToken);
                loginRespVO.setUserId(sysUser.getId());
                loginRespVO.setAccessToken(accessToken);
                loginRespVO.setRefreshToken(refreshToken);

            }else{
                BaseClientShop baseClientShop = baseClientShopService.selectByUsername(vo.getUsername());
                if (baseClientShop == null) {
                    throw new BusinessException(BaseResponseCode.ACCOUNT_ERROR);
                }
                if (!baseClientShop.getIsenable()) {
                    throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK_TIP);
                }
                if (!PasswordUtils.matches(baseClientShop.getSalt(), vo.getPassword(), baseClientShop.getPaduserpwd())) {
                    throw new BusinessException(BaseResponseCode.ACCOUNT_PASSWORD_ERROR);
                }
                Map<String, Object> claims = new HashMap<>();
                claims.put(Constant.JWT_USER_NAME, baseClientShop.getPadusercode());
                claims.put(Constant.ROLES_INFOS_KEY, getRoleByUserId("a452d281-5173-4f87-98d6-613d9e81b1f1"));
                claims.put(Constant.PERMISSIONS_INFOS_KEY, getPermissionByUserId("a452d281-5173-4f87-98d6-613d9e81b1f1"));
                String accessToken = JwtTokenUtil.getAccessToken(baseClientShop.getShop(), claims);
                log.info("accessToken{}", accessToken);

                //刷新Token
                Map<String, Object> refreshclaims = new HashMap<>();
                refreshclaims.put(Constant.JWT_REFRESH_KEY, baseClientShop.getPadusercode());
                String refreshToken = null;
                if (vo.getType().equals("1")) {
                    refreshToken = JwtTokenUtil.getRefreshToken(baseClientShop.getShop(), refreshclaims);
                } else {
                    refreshToken = JwtTokenUtil.getRefreshAppToken(baseClientShop.getShop(), refreshclaims);
                }
                log.info("refreshToken{}", refreshToken);
                loginRespVO.setUserId(baseClientShop.getShop());
                loginRespVO.setAccessToken(accessToken);
                loginRespVO.setRefreshToken(refreshToken);
            }
        return loginRespVO;
    }

    @Override
    public PageVO<SysUser> pageInfo(UserPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<SysUser> list = sysUserMapper.selectAll(vo);
        for (SysUser sysUser : list) {
            SysDept sysDept = sysDeptMapper.selectByPrimaryKey(sysUser.getDeptId());
            if (sysDept != null) {
                sysUser.setDeptName(sysDept.getName());
            }
        }
//        PageVO<SysUser> pageInfo = new PageVO<>(sysUsers);
        return PageUtil.getPage(list);
    }

    @Override
    public void addUser(UserAddReqVO vo) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        sysUser.setId(UUID.randomUUID().toString());
        sysUser.setCreateTime(new Date());
        String salt = PasswordUtils.getSalt();
        String ecdPed = PasswordUtils.encode(vo.getPassword(), salt);
        sysUser.setPassword(ecdPed);
        sysUser.setSalt(salt);
        int i = sysUserMapper.insertSelective(sysUser);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public UserOwnRoleRespVO getUserOwnRole(String userId) {
        UserOwnRoleRespVO respVO = new UserOwnRoleRespVO();
        respVO.setOwnRoles(userRoleService.getRoleIdByUserId(userId));
        respVO.setAllRole(roleService.selectAll());
        return respVO;
    }

    @Override
    public void setUserOwnRole(UserOwnRoleReqVO vo) {
        userRoleService.addUserRoleInfo(vo);
        //标记用户要主动去刷新
        redisService.set(Constant.JWT_REFRESH_KEY + vo.getUserId(), vo.getUserId(), tokenSetting.getAccessTokenExpireTime().toMillis(), TimeUnit.MILLISECONDS);
        //删除用户缓存的授权信息
        redisService.delete(Constant.IDENTIFY_CACHE_KEY + vo.getUserId());
    }

    @Override
    public String refreshToken(String refreshToken) {
        //校验refreshToken是否有效
        //校验refreshToken是否加入黑名单
        if (!JwtTokenUtil.validateToken(refreshToken) || redisService.hasKey(Constant.JWT_REFRESH_TOKEN_BLACKLIST + refreshToken)) {
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        String userId = JwtTokenUtil.getUserId(refreshToken);
        String username = JwtTokenUtil.getUserName(refreshToken);
        Map<String, Object> cliams = new HashMap<>();
        cliams.put(Constant.JWT_USER_NAME, username);
        cliams.put(Constant.ROLES_INFOS_KEY, getRoleByUserId(userId));
        cliams.put(Constant.PERMISSIONS_INFOS_KEY, getPermissionByUserId(userId));
        String newAccessToken = JwtTokenUtil.getAccessToken(userId, cliams);
        return newAccessToken;
    }

    @Override
    public void updateUserInfo(UserUpdateReqVO vo, String operationId) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateId(operationId);
        if (StringUtils.isEmpty(vo.getPassword())) {
            sysUser.setPassword(null);
        } else {
            String salt = PasswordUtils.getSalt();
            String endPwd = PasswordUtils.encode(vo.getPassword(), salt);
            sysUser.setPassword(endPwd);
            sysUser.setSalt(salt);
        }
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        if (vo.getStatus() == 2) {
            redisService.set(Constant.ACCOUNT_LOCK_KEY + vo.getId(), vo.getId());
        } else {
            redisService.delete(Constant.ACCOUNT_LOCK_KEY + vo.getId());
        }
    }

    @Override
    public void deletedUsers(List<String> list, String operation) {
        SysUser sysUser = new SysUser();
        sysUser.setUpdateId(operation);
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.deletedUsers(sysUser, list);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        for (String userId : list) {
            redisService.set(Constant.DELETED_USER_KEY + userId, userId, tokenSetting.getRefreshTokenExpireTime().toMillis(), TimeUnit.MILLISECONDS);
            //删除用户缓存的授权信息
            redisService.delete(Constant.IDENTIFY_CACHE_KEY + userId);
        }
    }

    @Override
    public List<SysUser> selectUserInfoByDeptIds(List<String> deptIds) {
        return sysUserMapper.selectUserInfoByDeptIds(deptIds);
    }

    @Override
    public void logout(String accessToken, String refreshToken) {
        if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(refreshToken)) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        String userId = JwtTokenUtil.getUserId(accessToken);
        //把accessToken加入黑名单
        redisService.set(Constant.JWT_ACCESS_TOKEN_BLACKLIST + accessToken, userId, JwtTokenUtil.getRemainingTime(accessToken), TimeUnit.MILLISECONDS);
        //把refreshToken加入黑名单
        redisService.set(Constant.JWT_REFRESH_TOKEN_BLACKLIST + refreshToken, userId, JwtTokenUtil.getRemainingTime(refreshToken), TimeUnit.MILLISECONDS);
    }

    @Override
    public SysUser datailInfo(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void userUpdateDetailInfo(UserUpdateDetailInfoReqVO vo, String userId) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        sysUser.setUpdateTime(new Date());
        sysUser.setId(userId);
        sysUser.setUpdateId(userId);
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public void userUpdatePwd(UserUpdatePwdReqVO vo, String accessToken, String refreshToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        //校验旧密码
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        if (sysUser == null) {
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        if (!PasswordUtils.matches(sysUser.getSalt(), vo.getOldPwd(), sysUser.getPassword())) {
            throw new BusinessException(BaseResponseCode.OLD_PASSWORD_ERROR);
        }
        //保存新密码
        sysUser.setUpdateTime(new Date());
        sysUser.setUpdateId(userId);
        sysUser.setPassword(PasswordUtils.encode(vo.getNewPwd(), sysUser.getSalt()));
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        //把accessToken加入黑名单
        redisService.set(Constant.JWT_ACCESS_TOKEN_BLACKLIST + accessToken, userId, JwtTokenUtil.getRemainingTime(accessToken), TimeUnit.MILLISECONDS);
        //把refreshToken加入黑名单
        redisService.set(Constant.JWT_REFRESH_TOKEN_BLACKLIST + refreshToken, userId, JwtTokenUtil.getRemainingTime(refreshToken), TimeUnit.MILLISECONDS);
        //删除用户缓存的授权信息
        redisService.delete(Constant.IDENTIFY_CACHE_KEY + userId);
    }

    /**
     * 用过用户id查询拥有的角色信息
     */
    private List<String> getRoleByUserId(String userId) {
        return roleService.getNameByUserId(userId);
    }

    private List<String> getPermissionByUserId(String userId) {
        return permissionService.getPermissionByUserId(userId);
    }
}

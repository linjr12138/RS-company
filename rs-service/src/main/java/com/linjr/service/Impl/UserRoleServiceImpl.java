package com.linjr.service.Impl;

import com.linjr.entity.db1.SysUserRole;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db1.SysUserRoleMapper;
import com.linjr.service.UserRoleService;
import com.linjr.vo.req.UserOwnRoleReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<String> getRoleIdByUserId(String userId) {
        return sysUserRoleMapper.getRoleIdsByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserRoleInfo(UserOwnRoleReqVO vo) {
        //删除他们的关联数据
        sysUserRoleMapper.batchRemoveRoleByUserId(vo.getUserId());
        if (vo.getRoleIds() == null || vo.getRoleIds().isEmpty()) {
            return;
        }
        List<SysUserRole> list = new ArrayList<>();
        for (String roleId : vo.getRoleIds()) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setId(UUID.randomUUID().toString());
            sysUserRole.setCreateTime(new Date());
            sysUserRole.setUserId(vo.getUserId());
            sysUserRole.setRoleId(roleId);
            list.add(sysUserRole);
        }
        int i = sysUserRoleMapper.batchInsertUserRole(list);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public List<String> getUserIdByRoleIds(List<String> roles) {
        return sysUserRoleMapper.getUserIdByRoleIds(roles);
    }

    @Override
    public List<String> getUserIdByRoleId(String roleId) {
        return sysUserRoleMapper.getUserIdByRoleId(roleId);
    }

    @Override
    public int removeByRoleId(String roleId) {
        return sysUserRoleMapper.removeByRoleId(roleId);
    }
}

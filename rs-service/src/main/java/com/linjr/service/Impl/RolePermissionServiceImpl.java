package com.linjr.service.Impl;

import com.linjr.entity.db1.SysRolePermission;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db1.SysRolePermissionMapper;
import com.linjr.service.RolePermissionService;
import com.linjr.vo.req.RolePermissionOperationReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public void addRolePermission(RolePermissionOperationReqVO vo) {
        sysRolePermissionMapper.removeByRoleId(vo.getRoleId());
        if (vo.getPermissionIds() == null || vo.getPermissionIds().isEmpty()) {
            return;
        }
        List<SysRolePermission> list = new ArrayList<>();
        for (String permissionId : vo.getPermissionIds()) {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setId(UUID.randomUUID().toString());
            sysRolePermission.setCreateTime(new Date());
            sysRolePermission.setRoleId(vo.getRoleId());
            sysRolePermission.setPermissionId(permissionId);
            list.add(sysRolePermission);
        }
        int i = sysRolePermissionMapper.batchInsertRolePermission(list);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public List<String> getRoleIdByPermissionId(String permissionId) {
        return sysRolePermissionMapper.getRoleIdByPermissionId(permissionId);
    }

    @Override
    public int removeRoleByPermissionId(String permissionId) {
        return sysRolePermissionMapper.removeByPermissionId(permissionId);
    }

    @Override
    public List<String> getPermissionIdByRoleId(String roleId) {
        return sysRolePermissionMapper.getPermissionIdsByRoleId(roleId);
    }

    @Override
    public int removeByRoleId(String roleId) {
        return sysRolePermissionMapper.removeByRoleId(roleId);
    }

    @Override
    public List<String> getPermissionIdByRoleIds(List<String> roleIds) {
        return sysRolePermissionMapper.getPermissionIdByRoleIds(roleIds);
    }
}

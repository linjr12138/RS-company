package com.linjr.service;

import com.linjr.vo.req.RolePermissionOperationReqVO;

import java.util.List;

public interface RolePermissionService {

    void addRolePermission(RolePermissionOperationReqVO vo);

    List<String> getRoleIdByPermissionId(String permissionId);

    int removeRoleByPermissionId(String permissionId);

    List<String> getPermissionIdByRoleId(String roleId);

    int removeByRoleId(String roleId);

    List<String> getPermissionIdByRoleIds(List<String> roleIds);
}

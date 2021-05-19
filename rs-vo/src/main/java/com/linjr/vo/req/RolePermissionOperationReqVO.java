package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: RolePermissionOperationReqVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class RolePermissionOperationReqVO {

    @ApiModelProperty(value = "角色id")
    private String roleId;
    @ApiModelProperty(value = "菜单权限集合")
    private List<String> permissionIds;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<String> permissionIds) {
        this.permissionIds = permissionIds;
    }

    @Override
    public String toString() {
        return "RolePermissionOperationReqVO{" +
                "roleId='" + roleId + '\'' +
                ", permissionIds=" + permissionIds +
                '}';
    }
}

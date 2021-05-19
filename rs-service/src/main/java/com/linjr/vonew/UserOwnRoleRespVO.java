package com.linjr.vonew;



import com.linjr.entity.db1.SysRole;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: UserOwnRoleRespVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class UserOwnRoleRespVO {

    @ApiModelProperty(value = "拥有角色集合")
    private List<String> ownRoles;

    @ApiModelProperty(value = "所有角色列表")
    private List<SysRole> allRole;

    public List<String> getOwnRoles() {
        return ownRoles;
    }

    public void setOwnRoles(List<String> ownRoles) {
        this.ownRoles = ownRoles;
    }

    public List<SysRole> getAllRole() {
        return allRole;
    }

    public void setAllRole(List<SysRole> allRole) {
        this.allRole = allRole;
    }

    @Override
    public String toString() {
        return "UserOwnRoleRespVO{" +
                "ownRoles=" + ownRoles +
                ", allRole=" + allRole +
                '}';
    }
}

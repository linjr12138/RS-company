package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @ClassName: UserOwnRoleReqVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class UserOwnRoleReqVO {
    @ApiModelProperty(value = "用户id")
    @NotBlank(message = "用户id不能为空")
    private String userId;
    @ApiModelProperty("赋予用户的角色id集合")
    private List<String> roleIds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "UserOwnRoleReqVO{" +
                "userId='" + userId + '\'' +
                ", roleIds=" + roleIds +
                '}';
    }
}

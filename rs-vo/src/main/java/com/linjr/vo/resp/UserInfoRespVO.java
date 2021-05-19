package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: UserInfoRespVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class UserInfoRespVO {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "部门id")
    private String deptId;
    @ApiModelProperty(value = "所属部门名称")
    private String deptName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "UserInfoRespVO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}

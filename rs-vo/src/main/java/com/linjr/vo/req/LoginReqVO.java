package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: LoginReqVO
 * TODO:类文件简单描述
 */
public class LoginReqVO {

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;
    @ApiModelProperty(value = "登录类型(1:web,2:app)")
    @NotBlank(message = "登录类型不能为空")
    private String type;
    @ApiModelProperty(value = "用户登录类型(1:店铺,2:后台账号)")
    @NotBlank(message = "用户登录类型不能为空")
    private  String UserType;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    @Override
    public String toString() {
        return "LoginReqVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", UserType='" + UserType + '\'' +
                '}';
    }
}

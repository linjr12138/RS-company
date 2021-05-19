package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: LoginRespVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class LoginRespVO {
    @ApiModelProperty(value = "业务访问token")
    private String accessToken;
    @ApiModelProperty(value = "业务token刷新凭证")
    private String refreshToken;
    @ApiModelProperty(value = "用户id")
    private String userId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LoginRespVO{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

package com.linjr.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @ClassName: TokenSettiing
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")//以jwt开头的都注入
public class TokenSetting {
    private String secretKey;
    private Duration accessTokenExpireTime;
    private Duration refreshTokenExpireTime;
    private Duration refreshTokenExpireAppTime;
    private String issuer;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Duration getAccessTokenExpireTime() {
        return accessTokenExpireTime;
    }

    public void setAccessTokenExpireTime(Duration accessTokenExpireTime) {
        this.accessTokenExpireTime = accessTokenExpireTime;
    }

    public Duration getRefreshTokenExpireTime() {
        return refreshTokenExpireTime;
    }

    public void setRefreshTokenExpireTime(Duration refreshTokenExpireTime) {
        this.refreshTokenExpireTime = refreshTokenExpireTime;
    }

    public Duration getRefreshTokenExpireAppTime() {
        return refreshTokenExpireAppTime;
    }

    public void setRefreshTokenExpireAppTime(Duration refreshTokenExpireAppTime) {
        this.refreshTokenExpireAppTime = refreshTokenExpireAppTime;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public String toString() {
        return "TokenSetting{" +
                "secretKey='" + secretKey + '\'' +
                ", accessTokenExpireTime=" + accessTokenExpireTime +
                ", refreshTokenExpireTime=" + refreshTokenExpireTime +
                ", refreshTokenExpireAppTime=" + refreshTokenExpireAppTime +
                ", issuer='" + issuer + '\'' +
                '}';
    }
}

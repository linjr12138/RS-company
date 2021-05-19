package com.linjr.utils;


import org.springframework.stereotype.Component;

@Component
public class InitializerUtil {

    public InitializerUtil(TokenSetting tokenSetting) {
        JwtTokenUtil.setJwtProperties(tokenSetting);
    }
}

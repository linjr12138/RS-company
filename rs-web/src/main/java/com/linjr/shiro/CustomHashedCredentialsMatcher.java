package com.linjr.shiro;

import com.linjr.contants.Constant;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.service.RedisService;
import com.linjr.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CustomHashedCredentialsMatcher extends HashedCredentialsMatcher {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        CustomUsernamePasswordToken customUsernamePasswordToken = (CustomUsernamePasswordToken) token;
        String accessToken = (String) customUsernamePasswordToken.getCredentials();
        String userId = JwtTokenUtil.getUserId(accessToken);
        log.info("doCredentialsMatch...userID{}", userId);
        //判断用户是否被删除
        if (redisService.hasKey(Constant.DELETED_USER_KEY + userId)) {
            throw new BusinessException(BaseResponseCode.ACCOUNT_HAS_DELETED_ERROR);
        }
        //是否被锁定
        if (redisService.hasKey(Constant.ACCOUNT_LOCK_KEY + userId)) {
            throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK_TIP);
        }
        //校验Token是否过期失效
        if (!JwtTokenUtil.validateToken(accessToken)) {
            throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE);
        }
        //判断用户是否退出登陆
        if (redisService.hasKey(Constant.JWT_ACCESS_TOKEN_BLACKLIST + accessToken)) {
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        //判断用户是否被标记了
        if (redisService.hasKey(Constant.JWT_REFRESH_KEY + userId)) {
            /**
             * 判断用户是否已经刷新过
             */
            if (redisService.getExpire(Constant.JWT_REFRESH_KEY + userId, TimeUnit.MILLISECONDS) > JwtTokenUtil.getRemainingTime(accessToken)) {
                throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE);
            }
        }
        return true;
    }
}

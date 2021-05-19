package com.linjr.service.Impl;

import com.linjr.contants.Constant;
import com.linjr.service.OrderNoService;
import com.linjr.service.RedisService;
import com.linjr.utils.CodeUtil;
import com.linjr.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderNoServiceImpl implements OrderNoService {
    @Autowired
    private RedisService redisService;

    @Override
    public String CreateOrderNo(String clientcode) {
        long orderCount = redisService.incrby(Constant.ORDER_CODE_KEY, 1);
        String orderNo = OrderNoUtil.orderNo(clientcode,String.valueOf(orderCount),21,"0");
        return orderNo;
    }
}

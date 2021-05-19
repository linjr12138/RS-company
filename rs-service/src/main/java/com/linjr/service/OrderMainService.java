package com.linjr.service;

import com.linjr.entity.db2.OrderMain;

public interface OrderMainService {
    OrderMain selectByClientCode(String clientcode);

    void ImportCreateOrderMain(String cilentcode);

    OrderMain creatOrderMain(String cilentcode);
}

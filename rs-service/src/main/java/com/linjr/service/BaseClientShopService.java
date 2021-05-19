package com.linjr.service;

import com.linjr.entity.db2.BaseClientShop;

import java.util.HashMap;
import java.util.List;

public interface BaseClientShopService {
    List<BaseClientShop> selectAll();

    BaseClientShop selectByUsername(String userName);

    List<HashMap> procJpaTest(String WhereClient,String WhereProduct,String UserCode,Integer PageIndex,Integer PageSize);
}

package com.linjr.mapper.db2;

import com.linjr.entity.db2.BaseClientShop;

import java.util.List;

public interface BaseClientShopMapper {
    int deleteByPrimaryKey(String shop);

    int insert(BaseClientShop record);

    int insertSelective(BaseClientShop record);

    BaseClientShop selectByPrimaryKey(String shop);

    int updateByPrimaryKeySelective(BaseClientShop record);

    int updateByPrimaryKey(BaseClientShop record);

    List<BaseClientShop> selectAll();

    BaseClientShop selectByUsername(String padusercode);
}
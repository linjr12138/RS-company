package com.linjr.mapper.db2;

import com.linjr.entity.db2.OrderMain;

public interface OrderMainMapper {
    int deleteByPrimaryKey(String orderno);

    int insert(OrderMain record);

    int insertSelective(OrderMain record);

    OrderMain selectByPrimaryKey(String orderno);

    int updateByPrimaryKeySelective(OrderMain record);

    int updateByPrimaryKey(OrderMain record);

    OrderMain selectByClientCode(String clientcode);
}
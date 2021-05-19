package com.linjr.service.Impl;

import com.linjr.entity.db2.BaseClientShop;
import com.linjr.mapper.db2.BaseClientShopMapper;
import com.linjr.mapper.db2.SqlJpaTestMapper;
import com.linjr.service.BaseClientShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class BaseClientShopServiceImpl implements BaseClientShopService {

    @Autowired
    private BaseClientShopMapper baseClientShopMapper;

    @Autowired
    private SqlJpaTestMapper sqlJpaTestMapper;

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<BaseClientShop> selectAll() {
        return baseClientShopMapper.selectAll();
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public BaseClientShop selectByUsername(String userName) {
        return baseClientShopMapper.selectByUsername(userName);
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<HashMap> procJpaTest(String WhereClient, String WhereProduct, String UserCode, Integer PageIndex, Integer PageSize) {
        return sqlJpaTestMapper.JpaTest(WhereClient,WhereProduct,UserCode,PageIndex,PageSize);
    }

}

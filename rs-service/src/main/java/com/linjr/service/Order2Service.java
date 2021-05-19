package com.linjr.service;

import com.linjr.entity.db2.BaseProduct;
import com.linjr.vo.req.SaveOrderReqVO;
import org.springframework.web.multipart.MultipartFile;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface Order2Service {
    //二维订单导入
    void batchAddData2(String fileName, MultipartFile file) throws Exception;

    //一维订单导入
    void Unidimensional2(String fileName, MultipartFile file) throws Exception;

    //保存订单
    void saveOrderByProduct2(List<BaseProduct> baseProductList, String clientcode) throws IllegalAccessException, IntrospectionException, InvocationTargetException;
}

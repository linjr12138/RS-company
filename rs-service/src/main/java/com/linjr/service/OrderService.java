package com.linjr.service;

import com.linjr.vo.req.SaveOrderReqVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface OrderService {

    //二维订单导入
    void batchAddData(String fileName, MultipartFile file) throws Exception;

    //一维订单导入
    void Unidimensional(String fileName, MultipartFile file) throws Exception;

    void saveOrderByProduct(SaveOrderReqVO vo,String clientcode);

}

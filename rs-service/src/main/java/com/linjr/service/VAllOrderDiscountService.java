package com.linjr.service;

import com.linjr.entity.db2.VAllOrderDiscount;
import com.linjr.vo.req.OrderPageReqVO;
import com.linjr.vo.resp.OrderRespVO;
import com.linjr.vo.resp.PageVO;

import java.util.List;

public interface VAllOrderDiscountService {
    List<OrderRespVO> getAllOrder();
    PageVO<VAllOrderDiscount> pageInfo(OrderPageReqVO vo);
}

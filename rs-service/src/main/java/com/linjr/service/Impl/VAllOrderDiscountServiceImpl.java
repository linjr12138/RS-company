package com.linjr.service.Impl;

import com.github.pagehelper.PageHelper;
import com.linjr.entity.db2.VAllOrderDiscount;
import com.linjr.mapper.db2.vAllOrderDiscountMapper;
import com.linjr.service.VAllOrderDiscountService;
import com.linjr.utils.PageUtil;
import com.linjr.vo.req.OrderPageReqVO;
import com.linjr.vo.resp.OrderRespVO;
import com.linjr.vo.resp.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VAllOrderDiscountServiceImpl implements VAllOrderDiscountService {

    @Autowired
    private vAllOrderDiscountMapper vAllOrderDiscountMapper;

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<OrderRespVO> getAllOrder() {
        List<VAllOrderDiscount> vAllOrderDiscount = vAllOrderDiscountMapper.getAllOrder();
        List<OrderRespVO> list = new ArrayList<>();
        for (VAllOrderDiscount v : vAllOrderDiscount){
            OrderRespVO orderRespVO = new OrderRespVO();
            BeanUtils.copyProperties(v,orderRespVO);
            list.add(orderRespVO);
        }
        return list;
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public PageVO<VAllOrderDiscount> pageInfo(OrderPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<VAllOrderDiscount> list = vAllOrderDiscountMapper.selectAll(vo);
        return PageUtil.getPage(list);
    }
}

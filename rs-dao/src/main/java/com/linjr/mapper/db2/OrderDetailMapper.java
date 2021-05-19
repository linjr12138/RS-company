package com.linjr.mapper.db2;

import com.linjr.entity.db2.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String detailuid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String detailuid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    OrderDetail selectByOrderNoProdCodeColorCode(@Param("orderno") String orderno, @Param("prodcode") String prodcode, @Param("colorcode") String colorcode,@Param("pattern")String pattern);

    int batchInsertOrder(List<OrderDetail> orderDetailList);

    int batchUpdateOrder(List<OrderDetail> orderDetailList);

    int deleteByOrderNo(String orderno);

    int updateBySizeIsNull(OrderDetail record);
}
package com.linjr.service;

import com.linjr.entity.db2.BaseProductSize;
import com.linjr.vo.resp.XMSelectNameValueRespVO;

import java.util.List;

public interface BaseProductSizeService {
    List<BaseProductSize> selectAssociationSize();

    List<XMSelectNameValueRespVO> baseProductSizeClassSize();
}

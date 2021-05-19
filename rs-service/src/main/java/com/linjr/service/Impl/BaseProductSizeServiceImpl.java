package com.linjr.service.Impl;

import com.linjr.entity.db2.BaseProduct;
import com.linjr.entity.db2.BaseProductSize;
import com.linjr.mapper.db2.BaseProductSizeMapper;
import com.linjr.service.BaseProductSizeService;
import com.linjr.vo.resp.XMSelectNameValueRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class BaseProductSizeServiceImpl implements BaseProductSizeService {

    @Autowired
    private BaseProductSizeMapper baseProductSizeMapper;

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<BaseProductSize> selectAssociationSize() {
        return baseProductSizeMapper.selectAssociationSize();
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<XMSelectNameValueRespVO> baseProductSizeClassSize() {
        List<BaseProductSize> baseProductSizeList = baseProductSizeMapper.selectAssociationSize();
        List<XMSelectNameValueRespVO> xmSelectNameValueRespVOList = new ArrayList<>();
        for (BaseProductSize baseProductSize : baseProductSizeList){
            XMSelectNameValueRespVO xmSelectNameValueRespVO = new XMSelectNameValueRespVO();
            xmSelectNameValueRespVO.setName(baseProductSize.getSize().replaceAll(",*$",""));
            xmSelectNameValueRespVO.setValue(baseProductSize.getSizeclass());
            xmSelectNameValueRespVOList.add(xmSelectNameValueRespVO);
        }

        return xmSelectNameValueRespVOList;
    }
}

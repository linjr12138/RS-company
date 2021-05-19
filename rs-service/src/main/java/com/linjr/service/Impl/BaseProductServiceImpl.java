package com.linjr.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linjr.entity.db2.BaseProduct;
import com.linjr.entity.db2.BaseProductSize;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db2.BaseProductMapper;
import com.linjr.service.BaseProductService;
import com.linjr.service.BaseProductSizeService;
import com.linjr.utils.PageUtil;
import com.linjr.vo.req.BaseProductPageReqVO;
import com.linjr.vo.req.BaseProductUpdateReqVO;
import com.linjr.vo.resp.BaseProDuctColorRespVO;
import com.linjr.vo.resp.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class BaseProductServiceImpl implements BaseProductService {

    @Autowired
    private BaseProductMapper baseProductMapper;

    @Autowired
    private BaseProductSizeService baseProductSizeService;


    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public PageVO<BaseProduct> baseProductPageInfo(BaseProductPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<BaseProduct> productList = baseProductMapper.selectAll(vo);
        List<BaseProductSize> baseProductSizeList = baseProductSizeService.selectAssociationSize();
        for (BaseProduct b : productList){
            for (BaseProductSize BS : baseProductSizeList){
                if (b.getSizeclass().equals(BS.getSizeclass())){
                    b.setSize(BS.getSize().replaceAll(",*$",""));
                }
            }
        }
        return PageUtil.getPage(productList);
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<BaseProduct> selectAll() {
        return baseProductMapper.selectAll2();
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public BaseProduct selectBaseProductByProdCode(String prodcode, String colorcode,String pattern) {
        return baseProductMapper.selectByPrimaryKey(prodcode,colorcode,pattern);
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<BaseProDuctColorRespVO> selectOneList() {
        List<String> list = baseProductMapper.selectOneList();
        List<BaseProduct> productList = baseProductMapper.selectAll2();
        List<BaseProDuctColorRespVO> baseProDuctColorRespVOList = new ArrayList<>();
        for (String s : list){
            BaseProDuctColorRespVO baseProDuctColorRespVO = new BaseProDuctColorRespVO();
            for (BaseProduct baseProduct : productList){
                if (s.equals(baseProduct.getColorcode())){
                    baseProDuctColorRespVO.setValue(s);
                    baseProDuctColorRespVO.setName(baseProduct.getColor());
                }
            }
            baseProDuctColorRespVOList.add(baseProDuctColorRespVO);
        }
        return baseProDuctColorRespVOList;
    }

    @Transactional(transactionManager = "db2TransactionManager",rollbackFor = Exception.class)
    @Override
    public void updateBaseProduct(BaseProductUpdateReqVO vo) {
        vo.setPattern("");
        BaseProduct baseProduct = baseProductMapper.selectByPrimaryKey(vo.getProdcode(),vo.getColorcode(),vo.getPattern());
        if (baseProduct == null){
            log.error("传入的ProdCode和ColorCode：{}或{}不合法",vo.getProdcode(),vo.getColorcode());
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        BaseProduct update = new BaseProduct();
        BeanUtils.copyProperties(baseProduct,update);
        update.setCategory(vo.getCategory());
        update.setClazz(vo.getClazz());
        update.setWno(new Date());

        int i = baseProductMapper.updateByPrimaryKeySelective(update);
        if (i != 1){
            throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
        }
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<BaseProduct> selectBaseProductByClientCode(String clientcode) {
        return baseProductMapper.selectAllByClientCode(clientcode);
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<BaseProduct> selectProductByClient(String whereclient) {
        return baseProductMapper.selectProductByClient(whereclient);
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<HashMap<String,Object>> screenProductByClient(String whereclient) {
        return baseProductMapper.screenProductByClient(whereclient);
    }

}

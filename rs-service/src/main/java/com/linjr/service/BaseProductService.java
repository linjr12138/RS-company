package com.linjr.service;

import com.linjr.entity.db2.BaseProduct;
import com.linjr.vo.req.BaseProductPageReqVO;
import com.linjr.vo.req.BaseProductUpdateReqVO;
import com.linjr.vo.resp.BaseProDuctColorRespVO;
import com.linjr.vo.resp.PageVO;

import java.util.HashMap;
import java.util.List;

public interface BaseProductService {

    PageVO<BaseProduct> baseProductPageInfo(BaseProductPageReqVO vo);

    List<BaseProduct> selectAll();

    BaseProduct selectBaseProductByProdCode(String prodcode, String colorcode, String pattern);

    List<BaseProDuctColorRespVO> selectOneList();

    void updateBaseProduct(BaseProductUpdateReqVO vo);

    List<BaseProduct> selectBaseProductByClientCode(String clientcode );

    List<BaseProduct> selectProductByClient(String whereclient);

    List<HashMap<String,Object>> screenProductByClient(String whereclient);

}

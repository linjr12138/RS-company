package com.linjr.myhystrix;

import com.linjr.contants.Constant;
import com.linjr.entity.db2.BaseClientShop;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.myfeign.BaseProductByFeign;
import com.linjr.service.BaseClientShopService;
import com.linjr.utils.DataResult;
import com.linjr.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public class BaseProductByHystrix implements BaseProductByFeign {

    @Override
    public DataResult<List<HashMap>> getProductsByClient(HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult<List<HashMap<String, Object>>> screenProductByClient(HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }
}

package com.linjr.myhystrix;

import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.myfeign.HomeByFeign;
import com.linjr.utils.DataResult;
import com.linjr.vo.resp.HomeRespVO;

import javax.servlet.http.HttpServletRequest;

public class HomeByHystrix implements HomeByFeign {
    @Override
    public DataResult<HomeRespVO> getHome(HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }
}

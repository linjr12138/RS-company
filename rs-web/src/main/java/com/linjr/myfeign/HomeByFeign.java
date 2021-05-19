package com.linjr.myfeign;

import com.linjr.contants.ServiceName;
import com.linjr.myhystrix.HomeByHystrix;
import com.linjr.utils.DataResult;
import com.linjr.vo.resp.HomeRespVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;

@FeignClient(contextId = "HomeClient",name = ServiceName.RS_web,fallback = HomeByHystrix.class)
public interface HomeByFeign {

    @GetMapping("/api/home")
    DataResult<HomeRespVO> getHome(HttpServletRequest request);
}

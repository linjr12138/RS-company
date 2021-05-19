package com.linjr.myfeign;

import com.linjr.config.FeignConfig;
import com.linjr.contants.ServiceName;
import com.linjr.myhystrix.BaseProductByHystrix;
import com.linjr.myhystrix.HomeByHystrix;
import com.linjr.utils.DataResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@FeignClient(contextId = "BaseProductClient",name = ServiceName.RS_web,configuration = FeignConfig.class)
public interface BaseProductByFeign {

    @GetMapping("/api/productsbyclient")
    @ApiOperation(value = "按照店铺编号查询品牌控制货品")
    DataResult<List<HashMap>> getProductsByClient(@RequestHeader HttpServletRequest request);

    @GetMapping("/api/screenproduct")
    @ApiOperation(value = "货品资料字段筛选")
    DataResult<List<HashMap<String,Object>>> screenProductByClient(@RequestHeader HttpServletRequest request);
}

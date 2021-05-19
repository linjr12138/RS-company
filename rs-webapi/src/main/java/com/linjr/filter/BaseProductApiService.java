package com.linjr.filter;

import com.linjr.myfeign.BaseProductByFeign;
import com.linjr.utils.DataResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/webapi")
@Api(tags = "Feign用户接口")
public class BaseProductApiService {

    @Autowired
    private BaseProductByFeign baseProductByFeign;


    @GetMapping("/productsbyclient")
    public DataResult<List<HashMap>> getProductsByClient(HttpServletRequest request){
        return baseProductByFeign.getProductsByClient(request);
    }

    @GetMapping("/screenproduct")
    public DataResult<List<HashMap<String,Object>>> screenProductByClient(HttpServletRequest request){
        return baseProductByFeign.screenProductByClient(request);
    }
}

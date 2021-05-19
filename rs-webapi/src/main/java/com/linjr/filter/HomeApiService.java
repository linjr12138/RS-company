package com.linjr.filter;


import com.linjr.myfeign.HomeByFeign;
import com.linjr.utils.DataResult;
import com.linjr.vo.resp.HomeRespVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/webapi")
@Api(tags = "Feign用户接口")
public class HomeApiService {

    @Autowired
    private HomeByFeign homeByFeign;

    @GetMapping("/home")
    public DataResult<HomeRespVO> getHome(@RequestHeader HttpServletRequest request){
        return homeByFeign.getHome(request);
    }

}

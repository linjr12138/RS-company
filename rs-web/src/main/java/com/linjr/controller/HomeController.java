package com.linjr.controller;

import com.linjr.aop.annotation.MyLog;
import com.linjr.contants.Constant;
import com.linjr.service.HomeService;
import com.linjr.utils.DataResult;
import com.linjr.utils.JwtTokenUtil;
import com.linjr.vo.resp.HomeRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Api(tags = "首页模块", description = "首页相关模块")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    @ApiOperation(value = "获取首页数据")
    @MyLog(title = "首页模块", action = "获取首页数据")
    public DataResult<HomeRespVO> getHome(HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String userId = JwtTokenUtil.getUserId(accessToken);
        DataResult result = new DataResult();
        result.setData(homeService.setHome(userId));
        return result;
    }
}

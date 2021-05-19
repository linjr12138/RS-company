package com.linjr.controller;

import com.linjr.aop.annotation.MyLog;
import com.linjr.service.BaseProductSizeService;
import com.linjr.utils.DataResult;
import com.linjr.vo.resp.XMSelectNameValueRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/XM")
@Api(tags = "XM-Select组件数据返回")
public class XMSelectController {

    @Autowired
    private BaseProductSizeService baseProductSizeService;

    @ApiOperation(value = "用户登陆接口")
    @GetMapping("/productsizes")
    @MyLog(title = "XM-Select组件数据返回-货品资料尺码组select初始化", action = "货品资料尺码组select初始化")
    public DataResult<List<XMSelectNameValueRespVO>> productSizeList(){
        DataResult result = DataResult.success();
        result.setData(baseProductSizeService.baseProductSizeClassSize());
        return result;
    }
}

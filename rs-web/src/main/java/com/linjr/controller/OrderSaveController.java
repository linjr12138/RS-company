package com.linjr.controller;

import com.linjr.contants.Constant;
import com.linjr.entity.db2.BaseProduct;
import com.linjr.service.Order2Service;
import com.linjr.utils.DataResult;
import com.linjr.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "RS-订单保存管理", description = "订单保存管理")
public class OrderSaveController {

    @Autowired
    private Order2Service order2Service;

    @PostMapping("/saveorder")
    @ApiOperation(value = "保存订单")
    public DataResult saveOrder(HttpServletRequest request, List<BaseProduct> baseProductList) {
        DataResult result = DataResult.success();
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String clientcode = JwtTokenUtil.getUserId(accessToken);
        try {
            order2Service.saveOrderByProduct2(baseProductList, clientcode);
        }catch (IllegalAccessException e1)
        {
            e1.printStackTrace();
        }catch (IntrospectionException e2){
            e2.printStackTrace();
        }catch (InvocationTargetException e3)
        {
            e3.printStackTrace();
        }
        result.setData("保存成功");
        return result;
    }

}

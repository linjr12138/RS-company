package com.linjr.controller;

import com.linjr.entity.db2.BaseClientShop;
import com.linjr.service.BaseClientShopService;
import com.linjr.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SQLServerApi")
public class BaseClientShopController {

    @Autowired
    private BaseClientShopService baseClientShopService;

    @GetMapping("/getBaseClientShop")
    public DataResult<List<BaseClientShop>> getBaseClientShop(){
        DataResult result = DataResult.success();
        result.setData(baseClientShopService.selectAll());
        return result;
    }
}

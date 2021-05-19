package com.linjr.controller;

import com.linjr.aop.annotation.MyLog;
import com.linjr.entity.db2.BaseClient;
import com.linjr.service.BaseClientService;
import com.linjr.utils.DataResult;
import com.linjr.vo.resp.BaseClientRespNodeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "联欣-客户资料管理", description = "客户资料管理接口")
public class BaseClientController {

    @Autowired
    private BaseClientService baseClientService;

    @GetMapping("/baseclient/tree")
    @ApiOperation(value = "客户资料管理树接口-只递归查询到经销商")
    @MyLog(title = "联欣-客户资料管理", action = "客户资料管理树接口-只递归查询到经销商")
    public DataResult<List<BaseClientRespNodeVO>> getAllBaseClientTreeDEALER(){
        DataResult result = DataResult.success();
        result.setData(baseClientService.baseClientTreeList());
        return result;
    }

    @GetMapping("/baseclient/tree/all")
    @ApiOperation(value = "客户资料管理树接口-只递归查询所有")
    @MyLog(title = "联欣-客户资料管理", action = "客户资料管理树接口-只递归查询所有")
    public DataResult<List<BaseClientRespNodeVO>> getAllBaseClientTree(){
        DataResult result = DataResult.success();
        result.setData(baseClientService.baseClienAllTreeList());
        return result;
    }

    @GetMapping("/baseclients")
    @ApiOperation(value = "获取客户资料")
    @MyLog(title = "联欣-客户资料管理", action = "获取所有的客户资料")
    public DataResult<List<BaseClient>> getAllBaseClient(){
        DataResult result = DataResult.success();
        result.setData(baseClientService.selectAll());
        return result;
    }
}

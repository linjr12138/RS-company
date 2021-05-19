package com.linjr.controller;

import com.linjr.aop.annotation.MyLog;
import com.linjr.entity.db1.SysLog;
import com.linjr.service.LogService;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.SysLogPageReqVO;
import com.linjr.vo.resp.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "系统管理-日志管理", description = "日志管理相关接口")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/logs")
    @ApiOperation(value = "分页查找操作日志接口")
    @RequiresPermissions("sys:log:list")
    public DataResult<PageVO<SysLog>> pageInfo(@RequestBody SysLogPageReqVO vo) {
        DataResult result = DataResult.success();
        PageVO<SysLog> sysLogPageVO = logService.pageInfo(vo);
        result.setData(sysLogPageVO);
        return result;
    }

    @DeleteMapping("log")
    @ApiOperation(value = "删除操作日志接口")
    @MyLog(title = "系统管理-日志管理", action = "删除操作日志接口")
    @RequiresPermissions("sys:log:delete")
    public DataResult deletedLog(@RequestBody @ApiParam(value = "日志ID集合") List<String> logIds) {
        DataResult result = DataResult.success();
        logService.deletedLog(logIds);
        return result;
    }
}

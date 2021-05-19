package com.linjr.controller;

import com.linjr.aop.annotation.MyLog;
import com.linjr.entity.db1.IpadManager;
import com.linjr.service.IPADManagerService;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.IPADAddReqVO;
import com.linjr.vo.req.IPADUpdateReqVO;
import com.linjr.vo.req.IpadManagerPageReqVO;
import com.linjr.vo.resp.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "IPAD-IPAD管理", description = "IPAD管理相关接口")
public class IPADManagerController {
    @Autowired
    private IPADManagerService ipadManagerService;

    @PostMapping("/ipads")
    @ApiOperation(value = "分页IPAD接口")
    @MyLog(title = "IPAD-IPAD管理", action = "分页IPAD接口")
    public DataResult<PageVO<IpadManager>> pageIPADInfo(@RequestBody IpadManagerPageReqVO vo) {
        DataResult result = DataResult.success();
        result.setData(ipadManagerService.pageInfo(vo));
        return result;
    }

    @ApiOperation(value = "新增IAPD数量接口")
    @PostMapping("/ipad")
    @MyLog(title = "IPAD-IPAD管理", action = "新增IAPD数量接口")
    public DataResult addIPAD(@RequestBody @Valid IPADAddReqVO vo) {
        DataResult result = DataResult.success();
        ipadManagerService.IPADAdd(vo);
        return result;
    }

    @PutMapping("/ipad")
    @ApiOperation(value = "列表修改ipad信息接口")
    @MyLog(title = "IPAD-IPAD管理", action = "列表修改ipad信息接口")
    public DataResult updateIPADInfo(@RequestBody @Valid IPADUpdateReqVO vo) {
        DataResult result = DataResult.success();
        ipadManagerService.IPADUpadteInfo(vo);
        return result;
    }

    @DeleteMapping("/ipad")
    @ApiOperation(value = "删除/批量删除IPAD接口")
    @MyLog(title = "IPAD-IPAD管理", action = "删除/批量删除IPAD接口")
    public DataResult deletedIPADs(@RequestBody @ApiParam(value = "IPAD序号ID集合") List<String> ids) {
        DataResult result = DataResult.success();
        ipadManagerService.DeletedIPAD(ids);
        return result;
    }
}

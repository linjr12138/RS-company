package com.linjr.controller;

import com.linjr.aop.annotation.MyLog;
import com.linjr.service.RegionService;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.RegionAddReqVO;
import com.linjr.vo.resp.RegionInfoRespVO;
import com.linjr.vo.resp.RegionRespNodeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "区域管理模块", description = "区域相关接口")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/region/tree")
    @ApiOperation(value = "查询所有区域树数据")
    @MyLog(title = "IPAD-区域管理模块", action = "查询所有区域树数据")
    public DataResult<List<RegionRespNodeVO>> getDeptTree(@RequestParam(required = false) String regionId) {
        DataResult result = DataResult.success();
        result.setData(regionService.regionTreeList(regionId));
        return result;
    }

    @GetMapping("/regions")
    @ApiOperation(value = "获取IPAD借还信息")
    @MyLog(title = "IPAD-区域管理模块", action = "获取IPAD借还信息")
    public DataResult<List<RegionInfoRespVO>> getAllRegionIPADInfo() {
        DataResult result = DataResult.success();
        result.setData(regionService.regionInfo());
        return result;
    }

    @ApiOperation(value = "新增区域数量接口")
    @PostMapping("/region")
    @MyLog(title = "IPAD-区域管理模块", action = "新增区域数量接口")
    public DataResult regionAdd(@RequestBody @Valid RegionAddReqVO vo) {
        DataResult result = DataResult.success();
        regionService.regionAdd(vo);
        return result;
    }
}

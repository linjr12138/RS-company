package com.linjr.controller;

import com.linjr.aop.annotation.MyLog;
import com.linjr.contants.Constant;
import com.linjr.entity.db2.BaseProduct;
import com.linjr.service.BaseProductService;
import com.linjr.utils.DataResult;
import com.linjr.utils.JwtTokenUtil;
import com.linjr.vo.req.BaseProductPageReqVO;
import com.linjr.vo.req.BaseProductUpdateReqVO;
import com.linjr.vo.req.DeptUpdateReqVO;
import com.linjr.vo.resp.BaseProDuctColorRespVO;
import com.linjr.vo.resp.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "联欣-货品资料管理", description = "货品资料管理接口")
public class BaseProductController {

    @Autowired
    private BaseProductService baseProductService;

    @PostMapping("/products")
    @ApiOperation(value = "分页查找货品资料接口")
    public DataResult<PageVO<BaseProduct>> pageInfo(@RequestBody BaseProductPageReqVO vo){
        DataResult result = DataResult.success();
        PageVO<BaseProduct> baseProductPageVO = baseProductService.baseProductPageInfo(vo);
        result.setData(baseProductPageVO);
        return result;
    }

    @GetMapping("/products")
    @ApiOperation(value = "查找所有货品资料接口")
    public DataResult<List<BaseProduct>> getAllBaseProduct(){
        DataResult result = DataResult.success();
        result.setData(baseProductService.selectAll());
        return result;
    }

    @GetMapping("/productcolorlist")
    @ApiOperation(value = "查找所有货品资料颜色")
    public DataResult<List<BaseProDuctColorRespVO>> getBaseProductColorList(){
        DataResult result = DataResult.success();
        result.setData(baseProductService.selectOneList());
        return result;
    }

    @PutMapping("/product")
    @ApiOperation(value = "跟新货品资料接口")
    public DataResult updateDept(@RequestBody @Valid BaseProductUpdateReqVO vo) {
        baseProductService.updateBaseProduct(vo);
        DataResult result = DataResult.success();
        return result;
    }

    @GetMapping("/productlist")
    @ApiOperation(value = "查找所有货品资料且订货明细")
    public DataResult<List<BaseProduct>> getAllProductAndAlready(HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String clientcode = JwtTokenUtil.getUserId(accessToken);
        DataResult result = DataResult.success();
        List<BaseProduct> baseProductList = baseProductService.selectBaseProductByClientCode(clientcode);
        result.setData(baseProductList);
        return result;
    }

    @GetMapping("/productsbyclient")
    @ApiOperation(value = "按照店铺编号查询品牌控制货品")
    public DataResult<List<BaseProduct>> getProductsByClient(HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String clientcode = JwtTokenUtil.getUserId(accessToken);
        DataResult result = DataResult.success();
        result.setData(baseProductService.selectProductByClient(clientcode));
        return result;
    }

    @GetMapping("/screenproduct")
    @ApiOperation(value = "货品资料字段筛选")
    public DataResult<List<HashMap<String,Object>>> screenProductByClient(HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String clientcode = JwtTokenUtil.getUserId(accessToken);
        DataResult result = DataResult.success();
        result.setData(baseProductService.screenProductByClient(clientcode));
        return result;
    }




}

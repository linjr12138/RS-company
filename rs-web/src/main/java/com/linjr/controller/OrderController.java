package com.linjr.controller;


import com.linjr.entity.db2.OrderDetail;
import com.linjr.entity.db2.VAllOrderDiscount;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.service.Order2Service;
import com.linjr.service.OrderService;
import com.linjr.service.VAllOrderDiscountService;
import com.linjr.utils.DataResult;
import com.linjr.utils.ExcelUtils;
import com.linjr.vo.req.OrderPageReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "联欣-订单管理", description = "订单管理")
public class OrderController {

    @Autowired
    private VAllOrderDiscountService vAllOrderDiscountService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private Order2Service order2Service;

    @PostMapping("/orders")
    @ApiOperation(value = "分页查找订单接口")
    public DataResult<List<VAllOrderDiscount>> pageInfo(@RequestBody OrderPageReqVO vo){
        DataResult result = DataResult.success();
        result.setData(vAllOrderDiscountService.pageInfo(vo));
        return result;
    }

    @PostMapping("/uploadFile")
    @ApiOperation(value = "导入EXCEL订单")
    public DataResult bathAddData(@RequestParam("file")MultipartFile file){
        DataResult result = DataResult.success();
        String fileName = file.getOriginalFilename();
        try {
            orderService.batchAddData(fileName,file);
        }catch (Exception e){
            throw new BusinessException(BaseResponseCode.IMPORT_ERROR);
        }
        return result;

    }


    @PostMapping("/uploadFile2")
    @ApiOperation(value = "导入EXCEL订单")
    public DataResult bathAddData2(@RequestParam("file")MultipartFile file){
        DataResult result = DataResult.success();
        String fileName = file.getOriginalFilename();
        try {
            order2Service.batchAddData2(fileName,file);
        }catch (Exception e){
            throw new BusinessException(BaseResponseCode.IMPORT_ERROR);
        }
        return result;

    }

    @PostMapping("/unidimensionaluploadFile")
    @ApiOperation(value = "导入EXCEL订单")
    public DataResult unidimensionalBathAddData(@RequestParam("file")MultipartFile file){
        DataResult result = DataResult.success();
        String fileName = file.getOriginalFilename();
        try {
            orderService.Unidimensional(fileName,file);
        }catch (Exception e){
            throw new BusinessException(BaseResponseCode.IMPORT_ERROR);
        }
        return result;
    }

    @PostMapping("/unidimensionaluploadFile2")
    @ApiOperation(value = "导入EXCEL订单")
    public DataResult unidimensionalBathAddData2(@RequestParam("file")MultipartFile file){
        DataResult result = DataResult.success();
        String fileName = file.getOriginalFilename();
        try {
            order2Service.Unidimensional2(fileName,file);
        }catch (Exception e){
            throw new BusinessException(BaseResponseCode.IMPORT_ERROR);
        }
        return result;
    }
}

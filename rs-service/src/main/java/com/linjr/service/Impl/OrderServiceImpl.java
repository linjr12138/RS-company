package com.linjr.service.Impl;

import com.linjr.entity.db2.*;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db2.OrderDetailMapper;
import com.linjr.service.*;
import com.linjr.utils.ExcelUtils;
import com.linjr.utils.ReflectionUtils;
import com.linjr.vo.req.SaveOrderReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderMainService orderMainService;

    @Autowired
    private BaseProductService baseProductService;

    @Autowired
    private BaseClientService baseClientService;

    @Autowired
    private BaseProductSizeService baseProductSizeService;

    @Transactional(transactionManager = "db2TransactionManager",rollbackFor = Exception.class)
    @Override
    public void batchAddData(String fileName, MultipartFile file) throws Exception {
        List<BaseProduct> notExistBaseProduct = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new BusinessException(BaseResponseCode.FORMAT_ERROR);
        }
        InputStream is = file.getInputStream();
        List<Object> entityList =  ExcelUtils.importDataFromExcel(new OrderImport(),is,fileName);
        if(entityList.isEmpty()){
            throw new BusinessException(BaseResponseCode.EXECLEMPTY_ERROR);
        }

        for (Object object : entityList){

            OrderImport orderImport = (OrderImport)object;
            OrderDetail orderDetail = new OrderDetail();
            //判断店铺是否存在
            OrderMain orderMain = getOrderNo(orderImport.getClientcode());
            //以下的都是有订单

            //取订单号
            orderDetail.setOrderno(orderMain.getOrderno());
            //取货品，到这里说明货品资料中有这一款色
            BaseProduct baseProduct = getBaseProduct(orderImport.getProdcode(),orderImport.getColorcode(),orderImport.getPattern());
            //判断OrderDetail是否有该货品订量
            boolean type;
            OrderDetail orderDetailExist = getOrderDetail(orderDetail.getOrderno(),baseProduct.getProdcode(),baseProduct.getColorcode(),baseProduct.getPattern());
            //true为订量已经存在，则跟新。false为订量不存在需要插入
            if (orderDetailExist != null){
                BeanUtils.copyProperties(orderDetailExist,orderDetail);
                type = true;
            }else{
                orderDetail.setDetailuid(UUID.randomUUID().toString());
                type = false;
            }
            BeanUtils.copyProperties(baseProduct,orderDetail);
            orderDetail.setQtysum(Integer.parseInt(orderImport.getQtysum()));
            orderDetail.setAmountsum(new BigDecimal(Integer.parseInt(orderImport.getQtysum())).multiply(baseProduct.getUnitprice()));
            orderDetail.setUploadtime(new Date());
            orderDetail.setIsdeleted(false);

            orderDetail.setSize1(dealWithSize(orderImport.getSize1()));
            orderDetail.setSize2(dealWithSize(orderImport.getSize2()));
            orderDetail.setSize3(dealWithSize(orderImport.getSize3()));
            orderDetail.setSize4(dealWithSize(orderImport.getSize4()));
            orderDetail.setSize5(dealWithSize(orderImport.getSize5()));
            orderDetail.setSize6(dealWithSize(orderImport.getSize6()));
            orderDetail.setSize7(dealWithSize(orderImport.getSize7()));
            orderDetail.setSize8(dealWithSize(orderImport.getSize8()));
            orderDetail.setSize9(dealWithSize(orderImport.getSize9()));
            orderDetail.setSize10(dealWithSize(orderImport.getSize10()));
            orderDetail.setSize11(dealWithSize(orderImport.getSize11()));
            orderDetail.setSize12(dealWithSize(orderImport.getSize12()));
            orderDetail.setSize13(dealWithSize(orderImport.getSize13()));
            orderDetail.setSize14(dealWithSize(orderImport.getSize14()));
            orderDetail.setSize15(dealWithSize(orderImport.getSize15()));
            orderDetail.setSize16(dealWithSize(orderImport.getSize16()));
            orderDetail.setSize17(dealWithSize(orderImport.getSize17()));
            orderDetail.setSize18(dealWithSize(orderImport.getSize18()));
            orderDetail.setSize19(dealWithSize(orderImport.getSize19()));
            orderDetail.setSize20(dealWithSize(orderImport.getSize20()));
            orderDetail.setSize21(dealWithSize(orderImport.getSize21()));
            orderDetail.setSize22(dealWithSize(orderImport.getSize22()));
            orderDetail.setSize23(dealWithSize(orderImport.getSize23()));
            orderDetail.setSize24(dealWithSize(orderImport.getSize24()));
            orderDetail.setSize25(dealWithSize(orderImport.getSize25()));
            orderDetail.setSize26(dealWithSize(orderImport.getSize26()));
            orderDetail.setSize27(dealWithSize(orderImport.getSize27()));
            orderDetail.setSize28(dealWithSize(orderImport.getSize28()));
            orderDetail.setSize29(dealWithSize(orderImport.getSize29()));
            orderDetail.setSize30(dealWithSize(orderImport.getSize30()));

            //判断size是否为空或者0
//            if (orderImport.getSize1() == null || orderImport.getSize1().equals("0")){
//                orderDetail.setSize1(null);
//            }else{
//                orderDetail.setSize1(Integer.parseInt(orderImport.getSize1()));
//            }
//            if (orderImport.getSize2() == null || orderImport.getSize2().equals("0")){
//                orderDetail.setSize2(null);
//            }else{
//                orderDetail.setSize2(Integer.parseInt(orderImport.getSize2()));
//            }
//            if (orderImport.getSize3() == null || orderImport.getSize3().equals("0")){
//                orderDetail.setSize3(null);
//            }else{
//                orderDetail.setSize3(Integer.parseInt(orderImport.getSize3()));
//            }
//            if (orderImport.getSize4() == null || orderImport.getSize4().equals("0")){
//                orderDetail.setSize4(null);
//            }else{
//                orderDetail.setSize4(Integer.parseInt(orderImport.getSize4()));
//            }
//            if (orderImport.getSize5() == null || orderImport.getSize5().equals("0")){
//                orderDetail.setSize5(null);
//            }else{
//                orderDetail.setSize5(Integer.parseInt(orderImport.getSize5()));
//            }
//            if (orderImport.getSize6() == null || orderImport.getSize6().equals("0")){
//                orderDetail.setSize6(null);
//            }else{
//                orderDetail.setSize6(Integer.parseInt(orderImport.getSize6()));
//            }
//            if (orderImport.getSize7() == null || orderImport.getSize7().equals("0")){
//                orderDetail.setSize7(null);
//            }else{
//                orderDetail.setSize7(Integer.parseInt(orderImport.getSize7()));
//            }
//            if (orderImport.getSize8() == null || orderImport.getSize8().equals("0")){
//                orderDetail.setSize8(null);
//            }else{
//                orderDetail.setSize8(Integer.parseInt(orderImport.getSize8()));
//            }
//            if (orderImport.getSize9() == null || orderImport.getSize9().equals("0")){
//                orderDetail.setSize9(null);
//            }else{
//                orderDetail.setSize9(Integer.parseInt(orderImport.getSize9()));
//            }
//            if (orderImport.getSize10() == null || orderImport.getSize10().equals("0")){
//                orderDetail.setSize10(null);
//            }else{
//                orderDetail.setSize10(Integer.parseInt(orderImport.getSize10()));
//            }
//            if (orderImport.getSize11() == null || orderImport.getSize11().equals("0")){
//                orderDetail.setSize11(null);
//            }else{
//                orderDetail.setSize11(Integer.parseInt(orderImport.getSize11()));
//            }
//            if (orderImport.getSize12() == null || orderImport.getSize12().equals("0")){
//                orderDetail.setSize12(null);
//            }else{
//                orderDetail.setSize12(Integer.parseInt(orderImport.getSize12()));
//            }
//            if (orderImport.getSize13() == null || orderImport.getSize13().equals("0")){
//                orderDetail.setSize13(null);
//            }else{
//                orderDetail.setSize13(Integer.parseInt(orderImport.getSize13()));
//            }
//            if (orderImport.getSize14() == null || orderImport.getSize14().equals("0")){
//                orderDetail.setSize14(null);
//            }else {
//                orderDetail.setSize14(Integer.parseInt(orderImport.getSize14()));
//            }
//            if (orderImport.getSize15() == null || orderImport.getSize15().equals("0")){
//                orderDetail.setSize15(null);
//            }else{
//                orderDetail.setSize15(Integer.parseInt(orderImport.getSize15()));
//            }
//            if (orderImport.getSize16() == null || orderImport.getSize16().equals("0")){
//                orderDetail.setSize16(null);
//            }else{
//                orderDetail.setSize16(Integer.parseInt(orderImport.getSize16()));
//            }
//            if (orderImport.getSize17() == null || orderImport.getSize17().equals("0")){
//                orderDetail.setSize17(null);
//            }else{
//                orderDetail.setSize17(Integer.parseInt(orderImport.getSize17()));
//            }
//            if (orderImport.getSize18() == null || orderImport.getSize18().equals("0")){
//                orderDetail.setSize18(null);
//            }else{
//                orderDetail.setSize18(Integer.parseInt(orderImport.getSize18()));
//            }
//            if (orderImport.getSize19() == null || orderImport.getSize19().equals("0")){
//                orderDetail.setSize19(null);
//            }else{
//                orderDetail.setSize19(Integer.parseInt(orderImport.getSize19()));
//            }
//            if (orderImport.getSize20() == null || orderImport.getSize20().equals("0")){
//                orderDetail.setSize20(null);
//            }else{
//                orderDetail.setSize20(Integer.parseInt(orderImport.getSize20()));
//            }
//            if (orderImport.getSize21() == null || orderImport.getSize21().equals("0")){
//                orderDetail.setSize21(null);
//            }else{
//                orderDetail.setSize21(Integer.parseInt(orderImport.getSize21()));
//            }
//            if (orderImport.getSize22() == null || orderImport.getSize22().equals("0")){
//                orderDetail.setSize22(null);
//            }else{
//                orderDetail.setSize22(Integer.parseInt(orderImport.getSize22()));
//            }
//            if (orderImport.getSize23() == null || orderImport.getSize23().equals("0")){
//                orderDetail.setSize23(null);
//            }else{
//                orderDetail.setSize23(Integer.parseInt(orderImport.getSize23()));
//            }
//            if (orderImport.getSize24() == null || orderImport.getSize24().equals("0")){
//                orderDetail.setSize24(null);
//            }else{
//                orderDetail.setSize24(Integer.parseInt(orderImport.getSize24()));
//            }
//            if (orderImport.getSize25() == null || orderImport.getSize25().equals("0")){
//                orderDetail.setSize25(null);
//            }else{
//                orderDetail.setSize25(Integer.parseInt(orderImport.getSize25()));
//            }
//            if (orderImport.getSize26() == null || orderImport.getSize26().equals("0")){
//                orderDetail.setSize26(null);
//            }else{
//                orderDetail.setSize26(Integer.parseInt(orderImport.getSize26()));
//            }
//            if (orderImport.getSize27() == null || orderImport.getSize27().equals("0")){
//                orderDetail.setSize27(null);
//            }else{
//                orderDetail.setSize27(Integer.parseInt(orderImport.getSize27()));
//            }
//            if (orderImport.getSize28() == null || orderImport.getSize28().equals("0")){
//                orderDetail.setSize28(null);
//            }else{
//                orderDetail.setSize28(Integer.parseInt(orderImport.getSize28()));
//            }
//            if (orderImport.getSize29() == null || orderImport.getSize29().equals("0")){
//                orderDetail.setSize29(null);
//            }else{
//                orderDetail.setSize29(Integer.parseInt(orderImport.getSize29()));
//            }
//            if (orderImport.getSize30() == null || orderImport.getSize30().equals("0")){
//                orderDetail.setSize30(null);
//            }else{
//                orderDetail.setSize30(Integer.parseInt(orderImport.getSize30()));
//            }

            orderDetail.setWno(new Date());
            orderDetail.setSourcecode("林景荣");
            orderDetail.setEdituser("林景荣");
            orderDetail.setUploadversion(0);
            int i;
            if (type) {
                i = orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
            }else{
                i = orderDetailMapper.insertSelective(orderDetail);
            }
            if (i != 1){
                throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
            }
        }
    }

    @Transactional(transactionManager = "db2TransactionManager",rollbackFor = Exception.class)
    @Override
    public void Unidimensional(String fileName, MultipartFile file) throws Exception {
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new BusinessException(BaseResponseCode.FORMAT_ERROR);
        }
        InputStream is = file.getInputStream();
        List<Object> entityList =  ExcelUtils.importDataFromExcel(new UnidimensionalOrderImport(),is,fileName);
        for (Object object : entityList){
            UnidimensionalOrderImport unidimensionalOrderImport = (UnidimensionalOrderImport)object;
            OrderDetail orderDetail = new OrderDetail();
            //判断店铺是否存在
            OrderMain orderMain = getOrderNo(unidimensionalOrderImport.getClientcode());
            //取订单号
            orderDetail.setOrderno(orderMain.getOrderno());
            //取货品，到这里说明货品资料中有这一款色
            BaseProduct baseProduct = getBaseProduct(unidimensionalOrderImport.getProdcode(),unidimensionalOrderImport.getColorcode(),unidimensionalOrderImport.getPattern());
            //判断OrderDetail是否有该货品订量
            boolean type;
            OrderDetail orderDetailExist = getOrderDetail(orderDetail.getOrderno(),baseProduct.getProdcode(),baseProduct.getColorcode(),baseProduct.getPattern());
            //true为订量已经存在，则跟新。false为订量不存在需要插入
            if (orderDetailExist != null){
                BeanUtils.copyProperties(orderDetailExist,orderDetail);
                type = true;
            }else{
                orderDetail.setDetailuid(UUID.randomUUID().toString());
                orderDetail.setQtysum(0);
                type = false;
            }
            BeanUtils.copyProperties(baseProduct,orderDetail);
            orderDetail.setQtysum(orderDetail.getQtysum()+Integer.parseInt(unidimensionalOrderImport.getQtysum()));
            orderDetail.setAmountsum(new BigDecimal(orderDetail.getQtysum()).multiply(baseProduct.getUnitprice()));
            orderDetail.setUploadtime(new Date());
            orderDetail.setIsdeleted(false);

            List<BaseProductSize> baseProductSizeList = baseProductSizeService.selectAssociationSize();
            for (BaseProductSize baseProductSize : baseProductSizeList){
                if (baseProductSize.getSizeclass().equals(unidimensionalOrderImport.getSizeclass())){
                    String strSize[] =  baseProductSize.getSize().split("");
                    for (int k=0;k<strSize.length;k++){
                        if (unidimensionalOrderImport.getSize().equals(strSize[k])){
                           orderDetail = setsize(k+1,orderDetail,unidimensionalOrderImport.getQtysum());
                        }
                    }
                }
            }

            orderDetail.setWno(new Date());
            orderDetail.setSourcecode("林景荣");
            orderDetail.setEdituser("林景荣");
            orderDetail.setUploadversion(0);
            int i;
            if (type) {
                i = orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
            }else{
                i = orderDetailMapper.insertSelective(orderDetail);
            }
            if (i != 1){
                throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
            }

        }
    }

    @Transactional(transactionManager = "db2TransactionManager",rollbackFor = Exception.class)
    @Override
    public void saveOrderByProduct(SaveOrderReqVO vo, String clientcode) {
        //这一步为一定可以拿到订单号
        OrderMain orderMain = getOrderNo(clientcode);
        //这一步为查询货品信息，有返回，则一定有货品信息
        BaseProduct baseProduct = getBaseProduct(vo.getProdcode(),vo.getColorcode(),vo.getPattern());
        OrderDetail orderDetail = new OrderDetail();
        OrderDetail newOrderDetail = new OrderDetail();
        //检查该款，颜色，版型，是否有下订量
        orderDetail = getOrderDetail(orderMain.getOrderno(),baseProduct.getProdcode(),baseProduct.getColorcode(),baseProduct.getPattern());
        if (orderDetail != null){//如果有，则更新
            BeanUtils.copyProperties(orderDetail,newOrderDetail);
            //跟新，需要变更的字段有:尺码订量，总订量，吊牌额
           /* 跟新尺码订量 */
            newOrderDetail.setSize1(dealWithSize(vo.getSize1()));
            newOrderDetail.setSize2(dealWithSize(vo.getSize2()));
            newOrderDetail.setSize3(dealWithSize(vo.getSize3()));
            newOrderDetail.setSize4(dealWithSize(vo.getSize4()));
            newOrderDetail.setSize5(dealWithSize(vo.getSize5()));
            newOrderDetail.setSize6(dealWithSize(vo.getSize6()));
            newOrderDetail.setSize7(dealWithSize(vo.getSize7()));
            newOrderDetail.setSize8(dealWithSize(vo.getSize8()));
            newOrderDetail.setSize9(dealWithSize(vo.getSize9()));
            newOrderDetail.setSize10(dealWithSize(vo.getSize10()));
            newOrderDetail.setSize11(dealWithSize(vo.getSize11()));
            newOrderDetail.setSize12(dealWithSize(vo.getSize12()));
            newOrderDetail.setSize13(dealWithSize(vo.getSize13()));
            newOrderDetail.setSize14(dealWithSize(vo.getSize14()));
            newOrderDetail.setSize15(dealWithSize(vo.getSize15()));
            newOrderDetail.setSize16(dealWithSize(vo.getSize16()));
            newOrderDetail.setSize17(dealWithSize(vo.getSize17()));
            newOrderDetail.setSize18(dealWithSize(vo.getSize18()));
            newOrderDetail.setSize19(dealWithSize(vo.getSize19()));
            newOrderDetail.setSize20(dealWithSize(vo.getSize20()));
            newOrderDetail.setSize21(dealWithSize(vo.getSize21()));
            newOrderDetail.setSize22(dealWithSize(vo.getSize22()));
            newOrderDetail.setSize23(dealWithSize(vo.getSize23()));
            newOrderDetail.setSize24(dealWithSize(vo.getSize24()));
            newOrderDetail.setSize25(dealWithSize(vo.getSize25()));
            newOrderDetail.setSize26(dealWithSize(vo.getSize26()));
            newOrderDetail.setSize27(dealWithSize(vo.getSize27()));
            newOrderDetail.setSize28(dealWithSize(vo.getSize28()));
            newOrderDetail.setSize29(dealWithSize(vo.getSize29()));
            newOrderDetail.setSize30(dealWithSize(vo.getSize30()));
            /* 结束跟新尺码订量 */

            //计算总订量
            newOrderDetail.setQtysum(calculationQyt(newOrderDetail));
            //计算吊牌额
            newOrderDetail.setAmountsum(new BigDecimal(newOrderDetail.getQtysum()).multiply(newOrderDetail.getUnitprice()));

            int i = orderDetailMapper.updateByPrimaryKeySelective(newOrderDetail);

            if (i < 1){
                throw new BusinessException(BaseResponseCode.SAVEORDER_ERROR);
            }

        }else{//如果没有，则插入
            BeanUtils.copyProperties(baseProduct,newOrderDetail);

            /* 尺码订量 */
            newOrderDetail.setSize1(dealWithSize(vo.getSize1()));
            newOrderDetail.setSize2(dealWithSize(vo.getSize2()));
            newOrderDetail.setSize3(dealWithSize(vo.getSize3()));
            newOrderDetail.setSize4(dealWithSize(vo.getSize4()));
            newOrderDetail.setSize5(dealWithSize(vo.getSize5()));
            newOrderDetail.setSize6(dealWithSize(vo.getSize6()));
            newOrderDetail.setSize7(dealWithSize(vo.getSize7()));
            newOrderDetail.setSize8(dealWithSize(vo.getSize8()));
            newOrderDetail.setSize9(dealWithSize(vo.getSize9()));
            newOrderDetail.setSize10(dealWithSize(vo.getSize10()));
            newOrderDetail.setSize11(dealWithSize(vo.getSize11()));
            newOrderDetail.setSize12(dealWithSize(vo.getSize12()));
            newOrderDetail.setSize13(dealWithSize(vo.getSize13()));
            newOrderDetail.setSize14(dealWithSize(vo.getSize14()));
            newOrderDetail.setSize15(dealWithSize(vo.getSize15()));
            newOrderDetail.setSize16(dealWithSize(vo.getSize16()));
            newOrderDetail.setSize17(dealWithSize(vo.getSize17()));
            newOrderDetail.setSize18(dealWithSize(vo.getSize18()));
            newOrderDetail.setSize19(dealWithSize(vo.getSize19()));
            newOrderDetail.setSize20(dealWithSize(vo.getSize20()));
            newOrderDetail.setSize21(dealWithSize(vo.getSize21()));
            newOrderDetail.setSize22(dealWithSize(vo.getSize22()));
            newOrderDetail.setSize23(dealWithSize(vo.getSize23()));
            newOrderDetail.setSize24(dealWithSize(vo.getSize24()));
            newOrderDetail.setSize25(dealWithSize(vo.getSize25()));
            newOrderDetail.setSize26(dealWithSize(vo.getSize26()));
            newOrderDetail.setSize27(dealWithSize(vo.getSize27()));
            newOrderDetail.setSize28(dealWithSize(vo.getSize28()));
            newOrderDetail.setSize29(dealWithSize(vo.getSize29()));
            newOrderDetail.setSize30(dealWithSize(vo.getSize30()));
            /* 尺码订量 */

            //计算总订量
            newOrderDetail.setQtysum(calculationQyt(newOrderDetail));
            //计算吊牌额
            newOrderDetail.setAmountsum(new BigDecimal(newOrderDetail.getQtysum()).multiply(newOrderDetail.getUnitprice()));

            int i = orderDetailMapper.insertSelective(newOrderDetail);

            if (i <= 1){
                throw new BusinessException(BaseResponseCode.SAVEORDER_ERROR);
            }



        }

    }

    //通过店铺编号查找订单,如果不存在，测查村是否有该店铺
    private OrderMain getOrderNo(String clientcode){
        //查询店铺是否存在
        BaseClient baseClient = baseClientService.selectByClientCode(clientcode);
        if (baseClient == null){//不存在
            throw new BusinessException(BaseResponseCode.IMPORTBASECLIENTEMPTY_ERROR);
        }else{
            OrderMain orderMain = orderMainService.selectByClientCode(clientcode);
            if (orderMain == null)
            orderMainService.ImportCreateOrderMain(clientcode);
        }
        return orderMainService.selectByClientCode(clientcode);
    }
    //通过款号查找货品是否存在，如果存在，则补全信息，如果不存在，则不导入，且抛出异常
    private BaseProduct getBaseProduct(String prodcode,String colorcode,String pattern){
        BaseProduct baseProduct = baseProductService.selectBaseProductByProdCode(prodcode,colorcode,pattern);
        if (baseProduct == null){
            throw new BusinessException(BaseResponseCode.IMPORTBASEPRODUCTEMPTY_ERROR);
        }
        return baseProduct;
    }

    //判断是否已经有这款的订量
    private OrderDetail getOrderDetail(String orderno,String prodcode,String colorcode,String pattern){
        return orderDetailMapper.selectByOrderNoProdCodeColorCode(orderno,prodcode,colorcode,pattern);
    }

    //判断Size是否为空或者null，或者等于

    private Integer dealWithSize(String size){
        if (size == null || size.equals("0") || size.equals("")){
            return null;
        }
        return Integer.parseInt(size);

    }

    private OrderDetail  setsize(int k,OrderDetail orderDetail,String qty){
        if (k == 1){
            orderDetail.setSize1(dealWithSize(qty));
        }
        if (k == 2){
            orderDetail.setSize2(dealWithSize(qty));
        }
        if (k == 3){
            orderDetail.setSize3(dealWithSize(qty));
        }
        if (k == 4){
            orderDetail.setSize4(dealWithSize(qty));
        }
        if (k == 5){
            orderDetail.setSize5(dealWithSize(qty));
        }
        if (k == 6){
            orderDetail.setSize6(dealWithSize(qty));
        }
        if (k == 7){
            orderDetail.setSize7(dealWithSize(qty));
        }
        if (k == 8){
            orderDetail.setSize8(dealWithSize(qty));
        }
        if (k == 9){
            orderDetail.setSize9(dealWithSize(qty));
        }
        if (k == 10){
            orderDetail.setSize10(dealWithSize(qty));
        }
        if (k == 11){
            orderDetail.setSize11(dealWithSize(qty));
        }
        if (k == 12){
            orderDetail.setSize12(dealWithSize(qty));
        }
        if (k == 13){
            orderDetail.setSize13(dealWithSize(qty));
        }
        if (k == 14){
            orderDetail.setSize14(dealWithSize(qty));
        }
        if (k == 15){
            orderDetail.setSize15(dealWithSize(qty));
        }
        if (k == 16){
            orderDetail.setSize16(dealWithSize(qty));
        }
        if (k == 17){
            orderDetail.setSize17(dealWithSize(qty));
        }
        if (k == 18){
            orderDetail.setSize18(dealWithSize(qty));
        }
        if (k == 19){
            orderDetail.setSize19(dealWithSize(qty));
        }
        if (k == 20){
            orderDetail.setSize20(dealWithSize(qty));
        }
        if (k == 21){
            orderDetail.setSize21(dealWithSize(qty));
        }
        if (k == 22){
            orderDetail.setSize22(dealWithSize(qty));
        }
        if (k == 23){
            orderDetail.setSize23(dealWithSize(qty));
        }
        if (k == 24){
            orderDetail.setSize24(dealWithSize(qty));
        }
        if (k == 25){
            orderDetail.setSize25(dealWithSize(qty));
        }
        if (k == 26){
            orderDetail.setSize26(dealWithSize(qty));
        }
        if (k == 27){
            orderDetail.setSize27(dealWithSize(qty));
        }
        if (k == 28){
            orderDetail.setSize28(dealWithSize(qty));
        }
        if (k == 29){
            orderDetail.setSize29(dealWithSize(qty));
        }
        if (k == 30){
            orderDetail.setSize30(dealWithSize(qty));
        }
        return orderDetail;
    }

    private Integer calculationQyt(OrderDetail orderDetail){
        Integer qty = 0;

        if (orderDetail.getSize1() != null){
                    qty +=orderDetail.getSize1();
            }

        if (orderDetail.getSize2() != null){
            qty +=orderDetail.getSize2();
        }
        if (orderDetail.getSize3() != null){
            qty +=orderDetail.getSize3();
        }
        if (orderDetail.getSize4() != null){
            qty +=orderDetail.getSize4();
        }
        if (orderDetail.getSize5() != null){
            qty +=orderDetail.getSize5();
        }
        if (orderDetail.getSize6() != null){
            qty +=orderDetail.getSize6();
        }
        if (orderDetail.getSize7() != null){
            qty +=orderDetail.getSize7();
        }
        if (orderDetail.getSize8() != null){
            qty +=orderDetail.getSize8();
        }
        if (orderDetail.getSize9() != null){
            qty +=orderDetail.getSize9();
        }
        if (orderDetail.getSize10() != null){
            qty +=orderDetail.getSize10();
        }
        if (orderDetail.getSize11() != null){
            qty +=orderDetail.getSize11();
        }
        if (orderDetail.getSize12() != null){
            qty +=orderDetail.getSize12();
        }
        if (orderDetail.getSize13() != null){
            qty +=orderDetail.getSize13();
        }
        if (orderDetail.getSize14() != null){
            qty +=orderDetail.getSize14();
        }
        if (orderDetail.getSize15() != null){
            qty +=orderDetail.getSize15();
        }
        if (orderDetail.getSize16() != null){
            qty +=orderDetail.getSize16();
        }
        if (orderDetail.getSize17() != null){
            qty +=orderDetail.getSize17();
        }
        if (orderDetail.getSize18() != null){
            qty +=orderDetail.getSize18();
        }
        if (orderDetail.getSize19() != null){
            qty +=orderDetail.getSize19();
        }
        if (orderDetail.getSize20() != null){
            qty +=orderDetail.getSize20();
        }
        if (orderDetail.getSize21() != null){
            qty +=orderDetail.getSize21();
        }
        if (orderDetail.getSize22() != null){
            qty +=orderDetail.getSize22();
        }
        if (orderDetail.getSize23() != null){
            qty +=orderDetail.getSize23();
        }
        if (orderDetail.getSize24() != null){
            qty +=orderDetail.getSize24();
        }
        if (orderDetail.getSize25() != null){
            qty +=orderDetail.getSize25();
        }
        if (orderDetail.getSize26() != null){
            qty +=orderDetail.getSize26();
        }
        if (orderDetail.getSize27() != null){
            qty +=orderDetail.getSize27();
        }
        if (orderDetail.getSize28() != null){
            qty +=orderDetail.getSize28();
        }
        if (orderDetail.getSize29() != null){
            qty +=orderDetail.getSize29();
        }
        if (orderDetail.getSize30() != null){
            qty +=orderDetail.getSize30();
        }

        return qty;
    }

}

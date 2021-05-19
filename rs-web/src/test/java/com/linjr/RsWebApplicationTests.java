package com.linjr;


import com.linjr.entity.db1.SysUser;
import com.linjr.entity.db2.BaseClientShop;
import com.linjr.entity.db2.BaseProduct;
import com.linjr.entity.db2.OrderDetail;
import com.linjr.mapper.db1.SysUserMapper;
import com.linjr.mapper.db1.TestJpaMapper;
import com.linjr.mapper.db2.BaseClientShopMapper;
import com.linjr.mapper.db2.BaseProductMapper;
import com.linjr.mapper.db2.OrderDetailMapper;
import com.linjr.mapper.db2.SqlJpaTestMapper;
import com.linjr.service.BaseClientShopService;
import com.linjr.service.BaseProductService;
import com.linjr.service.Order2Service;
import com.linjr.service.OrderService;
import com.linjr.utils.ReflectionUtils;
import com.linjr.vo.req.SaveOrderReqVO;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RsWebApplicationTests {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BaseProductMapper baseProductMapper;

    @Autowired
    private TestJpaMapper testJpaMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private BaseClientShopMapper baseClientShopMapper;

    @Autowired
    private SqlJpaTestMapper sqlJpaTestMapper;

    @Autowired
    private BaseProductService baseProductService;

    @Autowired
    private BaseClientShopService baseClientShopService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private Order2Service order2Service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1(){
        SysUser sysUser = sysUserMapper.selectByPrimaryKey("fcf34b56-a7a2-4719-9236-867495e74c31");
        System.out.println(sysUser);
    }

    @Test
    public void test2(){
        List<BaseProduct> baseProduct = baseProductMapper.selectAllByClientCode("1000");
        for (BaseProduct b : baseProduct){
            System.out.println(b);
        }
    }

    @Test
    public  void test3(){
        List<HashMap> mapList = testJpaMapper.procTest("60accf1a-e7e5-4fc9-b10b-89e7a77f7097");
        System.out.println(mapList);
    }

    @Test
    public void test4(){
//        List<HashMap<String,Object>> mapList = baseProductMapper.screenProductByClient("1000");
        List<HashMap<String,Object>> oldHashMapList = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> hashMap1 = new HashMap<String, Object>();
        List list1 = new ArrayList();
        hashMap1.put("fieldproperty","Brand");
        list1.add("abc");
        list1.add("def");
        hashMap1.put("fieldvalus",list1);



        HashMap<String,Object> hashMap2 = new HashMap<String, Object>();
        List list2 = new ArrayList();
        hashMap2.put("fieldproperty","Category");
        list2.add("ghi");
        list2.add("jkl");
        hashMap2.put("fieldvalus",list2);
        oldHashMapList.add(hashMap1);
        oldHashMapList.add(hashMap2);

        List<HashMap<String,Object>> newHashMapList =  new ArrayList<HashMap<String,Object>>();
        newHashMapList.add(oldHashMapList.get(0));

        List newList = new ArrayList<>();
        List newList1 = new ArrayList<>();
        newList = (List) newHashMapList.get(0).get("fieldvalus");
        newList.forEach(a->
                newList1.add(a.toString()));
        newList.add(newHashMapList.get(0).get("fieldvalus"));
        newList1.add("123");

        HashMap<String,Object> newHashMap = new HashMap<String, Object>();
        newHashMap.put("fieldproperty","Brand");
        newHashMap.put("fieldvalus",newList1);

        newHashMapList.set(0,newHashMap);


        System.out.println(newHashMapList);

    }

    @Test
    public void test5(){
        List<BaseProduct> hashMapList = baseProductService.selectBaseProductByClientCode("1000");
        System.out.println(hashMapList);
    }

    @Test
    public void test6(){

        BaseClientShop baseClientShop = baseClientShopService.selectByUsername("1000");
        System.out.println(baseClientShop);

    }

    @Test
    public void test7(){
        SaveOrderReqVO saveOrderReqVO = new SaveOrderReqVO();
        saveOrderReqVO.setProdcode("CDL1B077");
        saveOrderReqVO.setColorcode("N20");
        saveOrderReqVO.setPattern("");

        saveOrderReqVO.setSize1("5");
        saveOrderReqVO.setSize2("2");
        saveOrderReqVO.setSize3("2");
        saveOrderReqVO.setSize4("2");
        saveOrderReqVO.setSize5("1");
        saveOrderReqVO.setSize6("");
        saveOrderReqVO.setSize7("");
        saveOrderReqVO.setSize8("");
        saveOrderReqVO.setSize9("");
        saveOrderReqVO.setSize10("");
        saveOrderReqVO.setSize11("");
        saveOrderReqVO.setSize12("");
        saveOrderReqVO.setSize13("");
        saveOrderReqVO.setSize14("");
        saveOrderReqVO.setSize15("");
        saveOrderReqVO.setSize16("");
        saveOrderReqVO.setSize17("");
        saveOrderReqVO.setSize18("");
        saveOrderReqVO.setSize19("");
        saveOrderReqVO.setSize20("");
        saveOrderReqVO.setSize21("");
        saveOrderReqVO.setSize22("");
        saveOrderReqVO.setSize23("");
        saveOrderReqVO.setSize24("");
        saveOrderReqVO.setSize25("");
        saveOrderReqVO.setSize26("");
        saveOrderReqVO.setSize27("");
        saveOrderReqVO.setSize28("");
        saveOrderReqVO.setSize29("");
        saveOrderReqVO.setSize30("");

        orderService.saveOrderByProduct(saveOrderReqVO,"1000");

    }

    @Test
    public void test8(){

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        OrderDetail orderDetail2 = new OrderDetail();

        orderDetail1 =  orderDetailMapper.selectByOrderNoProdCodeColorCode("1000200226001","216311D1C12","B00","");
        orderDetail2 =  orderDetailMapper.selectByOrderNoProdCodeColorCode("1000200226001","CDL1B077","N20","");

        orderDetail1.setSize2(2);
        orderDetail1.setQtysum(5);
        orderDetail1.setAmountsum(new BigDecimal(orderDetail1.getQtysum()).multiply(orderDetail1.getUnitprice()));
        orderDetailList.add(orderDetail1);


        orderDetail2.setSize1(4);
        orderDetail2.setQtysum(11);
        orderDetail2.setAmountsum(new BigDecimal(orderDetail2.getQtysum()).multiply(orderDetail2.getUnitprice()));
        orderDetailList.add(orderDetail2);

        int i = orderDetailMapper.batchUpdateOrder(orderDetailList);
    }

    @Test
    public void test9(){
        BaseProduct baseProduct = baseProductMapper.selectByPrimaryKey("216311D1C12","B00","");
        System.out.println(baseProduct);
    }

    @Test
    public void test10(){
        List<BaseProduct> baseProductArrayList = new ArrayList<>();
        BaseProduct baseProduct1 = new BaseProduct();
        BaseProduct baseProduct2 = new BaseProduct();
        BaseProduct baseProduct3 = new BaseProduct();

        baseProduct1.setProdcode("216311D1C12");
        baseProduct1.setColorcode("B00");
        baseProduct1.setPattern("");
        baseProduct1.setSize1("");
        baseProduct1.setSize2("2");
        baseProduct1.setSize3("2");
        baseProduct1.setSize4("2");
        baseProduct1.setSize5("2");
        baseProduct1.setSize6("");
        baseProduct1.setSize7("");
        baseProduct1.setSize8("");
        baseProduct1.setSize9("");
        baseProduct1.setSize10("");
        baseProduct1.setSize11("");
        baseProduct1.setSize12("");
        baseProduct1.setSize13("");
        baseProduct1.setSize14("");
        baseProduct1.setSize15("");
        baseProduct1.setSize16("");
        baseProduct1.setSize17("");
        baseProduct1.setSize18("");
        baseProduct1.setSize19("");
        baseProduct1.setSize20("");
        baseProduct1.setSize21("");
        baseProduct1.setSize22("");
        baseProduct1.setSize23("");
        baseProduct1.setSize24("");
        baseProduct1.setSize25("");
        baseProduct1.setSize26("");
        baseProduct1.setSize27("");
        baseProduct1.setSize28("");
        baseProduct1.setSize29("");
        baseProduct1.setSize30("");


        baseProduct2.setProdcode("CDL1B077");
        baseProduct2.setColorcode("N20");
        baseProduct2.setPattern("");
        baseProduct2.setSize1("4");
        baseProduct2.setSize2("3");
        baseProduct2.setSize3("3");
        baseProduct2.setSize4("3");
        baseProduct2.setSize5("1");
        baseProduct2.setSize6("");
        baseProduct2.setSize7("");
        baseProduct2.setSize8("");
        baseProduct2.setSize9("");
        baseProduct2.setSize10("");
        baseProduct2.setSize11("");
        baseProduct2.setSize12("");
        baseProduct2.setSize13("");
        baseProduct2.setSize14("");
        baseProduct2.setSize15("");
        baseProduct2.setSize16("");
        baseProduct2.setSize17("");
        baseProduct2.setSize18("");
        baseProduct2.setSize19("");
        baseProduct2.setSize20("");
        baseProduct2.setSize21("");
        baseProduct2.setSize22("");
        baseProduct2.setSize23("");
        baseProduct2.setSize24("");
        baseProduct2.setSize25("");
        baseProduct2.setSize26("");
        baseProduct2.setSize27("");
        baseProduct2.setSize28("");
        baseProduct2.setSize29("");
        baseProduct2.setSize30("");


        baseProduct3.setProdcode("216311D1C27");
        baseProduct3.setColorcode("B00");
        baseProduct3.setPattern("");
        baseProduct3.setSize1("");
        baseProduct3.setSize2("2");
        baseProduct3.setSize3("2");
        baseProduct3.setSize4("2");
        baseProduct3.setSize5("");
        baseProduct3.setSize6("");
        baseProduct3.setSize7("");
        baseProduct3.setSize8("");
        baseProduct3.setSize9("");
        baseProduct3.setSize10("");
        baseProduct3.setSize11("");
        baseProduct3.setSize12("");
        baseProduct3.setSize13("");
        baseProduct3.setSize14("");
        baseProduct3.setSize15("");
        baseProduct3.setSize16("");
        baseProduct3.setSize17("");
        baseProduct3.setSize18("");
        baseProduct3.setSize19("");
        baseProduct3.setSize20("");
        baseProduct3.setSize21("");
        baseProduct3.setSize22("");
        baseProduct3.setSize23("");
        baseProduct3.setSize24("");
        baseProduct3.setSize25("");
        baseProduct3.setSize26("");
        baseProduct3.setSize27("");
        baseProduct3.setSize28("");
        baseProduct3.setSize29("");
        baseProduct3.setSize30("");

        baseProductArrayList.add(baseProduct1);
        baseProductArrayList.add(baseProduct2);
        baseProductArrayList.add(baseProduct3);

        for (BaseProduct baseProduct : baseProductArrayList){
            System.out.println(baseProduct);
        }
        System.out.println(baseProductArrayList);

        try{
            order2Service.saveOrderByProduct2(baseProductArrayList,"1000");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test11() throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        OrderDetail orderDetail = orderDetailMapper.selectByOrderNoProdCodeColorCode("1000200226001","216311D1C12","B00","");
        OrderDetail newOrderDetail = new OrderDetail();
        BeanUtils.copyProperties(orderDetail,newOrderDetail);
        ReflectionUtils.setPropertyVal("size2",newOrderDetail,3);
        System.out.println(ReflectionUtils.getPropertyVal("size1",orderDetail));
        ReflectionUtils.setPropertyVal("size1",newOrderDetail,dealWithSize(null));
        System.out.println(newOrderDetail.getSize2());
        System.out.println(newOrderDetail.getSize1());
    }

    @Test
    public void test12() throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        OrderDetail orderDetail = orderDetailMapper.selectByOrderNoProdCodeColorCode("1000200226001","216311D1C12","B00","");
        Integer qty = 0;
        for (int i =1 ; i<=30 ; i++){
            //System.out.println(ReflectionUtils.getPropertyVal("size"+i,orderDetail));

            //qty+=Integer.parseInt((String) ReflectionUtils.getPropertyVal("size"+i,orderDetail));
            if (ReflectionUtils.getPropertyVal("size"+i,orderDetail)!=null){
                qty+=(Integer) ReflectionUtils.getPropertyVal("size"+i,orderDetail);
                System.out.println(ReflectionUtils.getPropertyVal("size"+i,orderDetail));
            }

        }
        System.out.println(qty);
    }


    private Integer dealWithSize(String size){
        if (size == null || size.equals("0") || size.equals("")){
            return null;
        }
        return Integer.parseInt(size);

    }

    @Test
    public void test13(){
        BaseClientShop baseClientShop = baseClientShopService.selectByUsername("1000");
        System.out.println(baseClientShop);
    }

}


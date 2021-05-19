package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class OrderRespVO {

    @ApiModelProperty(value = "店铺编号")
    private String shop;

    @ApiModelProperty(value = "店铺名称")
    private String shopname;

    @ApiModelProperty(value = "数量合计")
    private Integer qtysum;

    @ApiModelProperty(value = "折后金额")
    private BigDecimal discountmoney;

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Integer getQtysum() {
        return qtysum;
    }

    public void setQtysum(Integer qtysum) {
        this.qtysum = qtysum;
    }

    public BigDecimal getDiscountmoney() {
        return discountmoney;
    }

    public void setDiscountmoney(BigDecimal discountmoney) {
        this.discountmoney = discountmoney;
    }

    @Override
    public String toString() {
        return "OrderRespVO{" +
                "shop='" + shop + '\'' +
                ", shopname='" + shopname + '\'' +
                ", qtysum=" + qtysum +
                ", discountmoney=" + discountmoney +
                '}';
    }
}

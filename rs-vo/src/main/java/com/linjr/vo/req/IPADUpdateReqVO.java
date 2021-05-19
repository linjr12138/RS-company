package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class IPADUpdateReqVO {
    @ApiModelProperty(value = "用户id")
    @NotBlank(message = "用户id不能为空")
    private String id;

    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "所属区域")
    @NotBlank(message = "所属区域不能为空")
    private String regionId;


    @ApiModelProperty(value = "账户状态(1.借 2.还 )")
    private Integer borrowReturn;

    @ApiModelProperty(value = "IPAD数量")
    @NotNull(message = "IPAD数量不能为空")
    private Integer ipadsum;

    @ApiModelProperty(value = "充电头")
    @NotNull(message = "充电头数量不能为空")
    private Integer charger;

    @ApiModelProperty(value = "充电线")
    @NotNull(message = "充电线数量不能为空")
    private Integer chargingLine;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Integer getBorrowReturn() {
        return borrowReturn;
    }

    public void setBorrowReturn(Integer borrowReturn) {
        this.borrowReturn = borrowReturn;
    }

    public Integer getIpadsum() {
        return ipadsum;
    }

    public void setIpadsum(Integer ipadsum) {
        this.ipadsum = ipadsum;
    }

    public Integer getCharger() {
        return charger;
    }

    public void setCharger(Integer charger) {
        this.charger = charger;
    }

    public Integer getChargingLine() {
        return chargingLine;
    }

    public void setChargingLine(Integer chargingLine) {
        this.chargingLine = chargingLine;
    }

    @Override
    public String toString() {
        return "IPADUpdateReqVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", regionId='" + regionId + '\'' +
                ", borrowReturn=" + borrowReturn +
                ", ipadsum=" + ipadsum +
                ", charger=" + charger +
                ", chargingLine=" + chargingLine +
                '}';
    }
}

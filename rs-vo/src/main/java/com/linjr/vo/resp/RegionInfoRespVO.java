package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

public class RegionInfoRespVO {

    @ApiModelProperty(value = "区域id")
    private String id;

    @ApiModelProperty(value = "部门名称")
    private String regionname;

    @ApiModelProperty(value = "区域负责人")
    private String manager;

    @ApiModelProperty(value = "负责人身份证号码")
    private String identification;

    @ApiModelProperty(value = "区域父级ID")
    private String pid;

    @ApiModelProperty(value = "区域父级名称")
    private String pidName;

    @ApiModelProperty(value = "计划借用IPAD")
    private Integer planipadsum;

    @ApiModelProperty(value = "IPAD总数")
    private Integer ipadsum;

    @ApiModelProperty(value = "已借IPAD数量")
    private Integer borrowedIAPD;

    @ApiModelProperty(value = "已借IPAD充电头")
    private Integer borrowedCharger;

    @ApiModelProperty(value = "已借IPAD充电线")
    private Integer borrowedChargingLine;

    @ApiModelProperty(value = "已还IPAD数量")
    private Integer returnIAPD;

    @ApiModelProperty(value = "已还IPAD充电头")
    private Integer returnCharger;

    @ApiModelProperty(value = "已还IPAD充电线")
    private Integer returnChargingLine;

    @ApiModelProperty(value = "未还IPAD数量")
    private int notYetIAPD;

    @ApiModelProperty(value = "未还IPAD充电头")
    private int notYetCharger;

    @ApiModelProperty(value = "未还IPAD充电线")
    private int notYetChargingLine;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionname;
    }

    public void setRegionName(String regionname) {
        this.regionname = regionname;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPidName() {
        return pidName;
    }

    public void setPidName(String pidName) {
        this.pidName = pidName;
    }

    public Integer getPlanipadsum() {
        return planipadsum;
    }

    public void setPlanipadsum(Integer planipadsum) {
        this.planipadsum = planipadsum;
    }

    public Integer getBorrowedIAPD() {
        return borrowedIAPD;
    }

    public void setBorrowedIAPD(Integer borrowedIAPD) {
        this.borrowedIAPD = borrowedIAPD;
    }

    public Integer getBorrowedCharger() {
        return borrowedCharger;
    }

    public void setBorrowedCharger(Integer borrowedCharger) {
        this.borrowedCharger = borrowedCharger;
    }

    public Integer getBorrowedChargingLine() {
        return borrowedChargingLine;
    }

    public void setBorrowedChargingLine(Integer borrowedChargingLine) {
        this.borrowedChargingLine = borrowedChargingLine;
    }


    public Integer getReturnIAPD() {
        return returnIAPD;
    }

    public void setReturnIAPD(Integer returnIAPD) {
        this.returnIAPD = returnIAPD;
    }

    public Integer getReturnCharger() {
        return returnCharger;
    }

    public void setReturnCharger(Integer returnCharger) {
        this.returnCharger = returnCharger;
    }

    public Integer getReturnChargingLine() {
        return returnChargingLine;
    }

    public void setReturnChargingLine(Integer returnChargingLine) {
        this.returnChargingLine = returnChargingLine;
    }

    public Integer getIpadsum() {
        return ipadsum;
    }

    public void setIpadsum(Integer ipadsum) {
        this.ipadsum = ipadsum;
    }

    public int getNotYetIAPD() {
        return notYetIAPD;
    }

    public void setNotYetIAPD(int notYetIAPD) {
        this.notYetIAPD = notYetIAPD;
    }

    public int getNotYetCharger() {
        return notYetCharger;
    }

    public void setNotYetCharger(int notYetCharger) {
        this.notYetCharger = notYetCharger;
    }

    public int getNotYetChargingLine() {
        return notYetChargingLine;
    }

    public void setNotYetChargingLine(int notYetChargingLine) {
        this.notYetChargingLine = notYetChargingLine;
    }

    @Override
    public String toString() {
        return "RegionInfoRespVO{" +
                "id='" + id + '\'' +
                ", regionName='" + regionname + '\'' +
                ", manager='" + manager + '\'' +
                ", identification='" + identification + '\'' +
                ", pid='" + pid + '\'' +
                ", pidName='" + pidName + '\'' +
                ", planipadsum=" + planipadsum +
                ", ipadsum=" + ipadsum +
                ", borrowedIAPD=" + borrowedIAPD +
                ", borrowedCharger=" + borrowedCharger +
                ", borrowedChargingLine=" + borrowedChargingLine +
                ", returnIAPD=" + returnIAPD +
                ", returnCharger=" + returnCharger +
                ", returnChargingLine=" + returnChargingLine +
                ", notYetIAPD=" + notYetIAPD +
                ", notYetCharger=" + notYetCharger +
                ", notYetChargingLine=" + notYetChargingLine +
                '}';
    }
}

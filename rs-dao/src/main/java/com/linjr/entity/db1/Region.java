package com.linjr.entity.db1;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Region implements Serializable {
    private String id;

    private String regionname;

    private String manager;

    private String phone;

    private String identification;

    private Date createTime;

    private Date updateTime;

    private Byte deleted;

    private Integer planipadsum;

    private String pid;

    private String pidName;

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

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Integer getPlanipadsum() {
        return planipadsum;
    }

    public void setPlanipadsum(Integer planipadsum) {
        this.planipadsum = planipadsum;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPidName() {
        return pidName;
    }

    public void setPidName(String pidName) {
        this.pidName = pidName;
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
        return "Region{" +
                "id='" + id + '\'' +
                ", regionname='" + regionname + '\'' +
                ", manager='" + manager + '\'' +
                ", phone='" + phone + '\'' +
                ", identification='" + identification + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                ", planipadsum=" + planipadsum +
                ", pid='" + pid + '\'' +
                ", pidName='" + pidName + '\'' +
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
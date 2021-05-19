package com.linjr.entity.db1;

import java.io.Serializable;
import java.util.Date;

public class IpadManager implements Serializable {
    private String id;

    private String name;

    private String regionId;

    private Integer ipadsum;

    private Integer borrowReturn;

    private Integer deleted;

    private Date updateTime;

    private Date createTime;

    private String phone;

    private String regionName;

    private Integer charger;

    private Integer chargingLine;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public Integer getIpadsum() {
        return ipadsum;
    }

    public void setIpadsum(Integer ipadsum) {
        this.ipadsum = ipadsum;
    }

    public Integer getBorrowReturn() {
        return borrowReturn;
    }

    public void setBorrowReturn(Integer borrowReturn) {
        this.borrowReturn = borrowReturn;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", regionId=").append(regionId);
        sb.append(", regionName=").append(regionName);
        sb.append(", ipadsum=").append(ipadsum);
        sb.append(", borrowReturn=").append(borrowReturn);
        sb.append(", deleted=").append(deleted);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", phone=").append(phone);
        sb.append(", charger=").append(charger);
        sb.append(", chargingLine=").append(chargingLine);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
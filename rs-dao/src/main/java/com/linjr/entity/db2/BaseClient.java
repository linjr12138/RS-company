package com.linjr.entity.db2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseClient implements Serializable {
    private String clientcode;

    private String clientname;

    private String pdaentrycode;

    private String parentcode;

    private String parentname;

    private BigDecimal discount;

    private String manager;

    private String clientsort;

    private String clientlevel;

    private String clientremark;

    private String edituser;

    private Date wno;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private Integer version;

    private String discountgroup;

    private String fixedgroup;

    private String district;

    private String province;

    private String city;

    private String address;

    private String postcode;

    private String phone;

    private String bossname;

    private String area;

    private String mode;

    private BigDecimal payrate;

    private Integer ordertype;

    private String padusercode;

    private String paduserpwd;

    private String salt;

    private Boolean isenable;

    private Boolean issurvey;

    private String preordertype;

    private Integer padusertype;

    private byte[] timestamp;

    private static final long serialVersionUID = 1L;

    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode == null ? null : clientcode.trim();
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname == null ? null : clientname.trim();
    }

    public String getPdaentrycode() {
        return pdaentrycode;
    }

    public void setPdaentrycode(String pdaentrycode) {
        this.pdaentrycode = pdaentrycode == null ? null : pdaentrycode.trim();
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode == null ? null : parentcode.trim();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getClientsort() {
        return clientsort;
    }

    public void setClientsort(String clientsort) {
        this.clientsort = clientsort == null ? null : clientsort.trim();
    }

    public String getClientlevel() {
        return clientlevel;
    }

    public void setClientlevel(String clientlevel) {
        this.clientlevel = clientlevel == null ? null : clientlevel.trim();
    }

    public String getClientremark() {
        return clientremark;
    }

    public void setClientremark(String clientremark) {
        this.clientremark = clientremark == null ? null : clientremark.trim();
    }

    public String getEdituser() {
        return edituser;
    }

    public void setEdituser(String edituser) {
        this.edituser = edituser == null ? null : edituser.trim();
    }

    public Date getWno() {
        return wno;
    }

    public void setWno(Date wno) {
        this.wno = wno;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDiscountgroup() {
        return discountgroup;
    }

    public void setDiscountgroup(String discountgroup) {
        this.discountgroup = discountgroup == null ? null : discountgroup.trim();
    }

    public String getFixedgroup() {
        return fixedgroup;
    }

    public void setFixedgroup(String fixedgroup) {
        this.fixedgroup = fixedgroup == null ? null : fixedgroup.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBossname() {
        return bossname;
    }

    public void setBossname(String bossname) {
        this.bossname = bossname == null ? null : bossname.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public BigDecimal getPayrate() {
        return payrate;
    }

    public void setPayrate(BigDecimal payrate) {
        this.payrate = payrate;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public String getPadusercode() {
        return padusercode;
    }

    public void setPadusercode(String padusercode) {
        this.padusercode = padusercode == null ? null : padusercode.trim();
    }

    public String getPaduserpwd() {
        return paduserpwd;
    }

    public void setPaduserpwd(String paduserpwd) {
        this.paduserpwd = paduserpwd == null ? null : paduserpwd.trim();
    }

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public Boolean getIssurvey() {
        return issurvey;
    }

    public void setIssurvey(Boolean issurvey) {
        this.issurvey = issurvey;
    }

    public String getPreordertype() {
        return preordertype;
    }

    public void setPreordertype(String preordertype) {
        this.preordertype = preordertype == null ? null : preordertype.trim();
    }

    public Integer getPadusertype() {
        return padusertype;
    }

    public void setPadusertype(Integer padusertype) {
        this.padusertype = padusertype;
    }

    public byte[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clientcode=").append(clientcode);
        sb.append(", clientname=").append(clientname);
        sb.append(", pdaentrycode=").append(pdaentrycode);
        sb.append(", parentcode=").append(parentcode);
        sb.append(", parentname=").append(parentname);
        sb.append(", discount=").append(discount);
        sb.append(", manager=").append(manager);
        sb.append(", clientsort=").append(clientsort);
        sb.append(", clientlevel=").append(clientlevel);
        sb.append(", clientremark=").append(clientremark);
        sb.append(", edituser=").append(edituser);
        sb.append(", wno=").append(wno);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", reserve3=").append(reserve3);
        sb.append(", version=").append(version);
        sb.append(", discountgroup=").append(discountgroup);
        sb.append(", fixedgroup=").append(fixedgroup);
        sb.append(", district=").append(district);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", address=").append(address);
        sb.append(", postcode=").append(postcode);
        sb.append(", phone=").append(phone);
        sb.append(", bossname=").append(bossname);
        sb.append(", area=").append(area);
        sb.append(", mode=").append(mode);
        sb.append(", payrate=").append(payrate);
        sb.append(", ordertype=").append(ordertype);
        sb.append(", padusercode=").append(padusercode);
        sb.append(", paduserpwd=").append(paduserpwd);
        sb.append(", salt=").append(salt);
        sb.append(", isenable=").append(isenable);
        sb.append(", issurvey=").append(issurvey);
        sb.append(", preordertype=").append(preordertype);
        sb.append(", padusertype=").append(padusertype);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.linjr.entity.db2;

import java.io.Serializable;
import java.math.BigDecimal;

public class BaseClientShop implements Serializable {
    private String shop;

    private String shopname;

    private String dealer;

    private String dealername;

    private String agent;

    private String agentname;

    private String region;

    private String regionname;

    private String head;

    private String headname;

    private String manager;

    private String clientsort;

    private Boolean isenable;

    private BigDecimal discount;

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

    private String shopremark;

    private String shopreserve1;

    private String shopreserve2;

    private String shopreserve3;

    private String padusercode;

    private String paduserpwd;

    private String salt;

    private Integer padusertype;

    private String preordertype;

    private Boolean issurvey;

    private static final long serialVersionUID = 1L;

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop == null ? null : shop.trim();
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer == null ? null : dealer.trim();
    }

    public String getDealername() {
        return dealername;
    }

    public void setDealername(String dealername) {
        this.dealername = dealername == null ? null : dealername.trim();
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname == null ? null : agentname.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getHeadname() {
        return headname;
    }

    public void setHeadname(String headname) {
        this.headname = headname == null ? null : headname.trim();
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

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public String getShopremark() {
        return shopremark;
    }

    public void setShopremark(String shopremark) {
        this.shopremark = shopremark == null ? null : shopremark.trim();
    }

    public String getShopreserve1() {
        return shopreserve1;
    }

    public void setShopreserve1(String shopreserve1) {
        this.shopreserve1 = shopreserve1 == null ? null : shopreserve1.trim();
    }

    public String getShopreserve2() {
        return shopreserve2;
    }

    public void setShopreserve2(String shopreserve2) {
        this.shopreserve2 = shopreserve2 == null ? null : shopreserve2.trim();
    }

    public String getShopreserve3() {
        return shopreserve3;
    }

    public void setShopreserve3(String shopreserve3) {
        this.shopreserve3 = shopreserve3 == null ? null : shopreserve3.trim();
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

    public Integer getPadusertype() {
        return padusertype;
    }

    public void setPadusertype(Integer padusertype) {
        this.padusertype = padusertype;
    }

    public String getPreordertype() {
        return preordertype;
    }

    public void setPreordertype(String preordertype) {
        this.preordertype = preordertype == null ? null : preordertype.trim();
    }

    public Boolean getIssurvey() {
        return issurvey;
    }

    public void setIssurvey(Boolean issurvey) {
        this.issurvey = issurvey;
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
        sb.append(", shop=").append(shop);
        sb.append(", shopname=").append(shopname);
        sb.append(", dealer=").append(dealer);
        sb.append(", dealername=").append(dealername);
        sb.append(", agent=").append(agent);
        sb.append(", agentname=").append(agentname);
        sb.append(", region=").append(region);
        sb.append(", regionname=").append(regionname);
        sb.append(", head=").append(head);
        sb.append(", headname=").append(headname);
        sb.append(", manager=").append(manager);
        sb.append(", clientsort=").append(clientsort);
        sb.append(", isenable=").append(isenable);
        sb.append(", discount=").append(discount);
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
        sb.append(", shopremark=").append(shopremark);
        sb.append(", shopreserve1=").append(shopreserve1);
        sb.append(", shopreserve2=").append(shopreserve2);
        sb.append(", shopreserve3=").append(shopreserve3);
        sb.append(", padusercode=").append(padusercode);
        sb.append(", paduserpwd=").append(paduserpwd);
        sb.append(", salt=").append(salt);
        sb.append(", padusertype=").append(padusertype);
        sb.append(", preordertype=").append(preordertype);
        sb.append(", issurvey=").append(issurvey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
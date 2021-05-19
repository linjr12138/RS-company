package com.linjr.entity.db2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VAllOrderDiscount implements Serializable {
    private String head;

    private String headname;

    private String region;

    private String regionname;

    private String agent;

    private String agentname;

    private String dealer;

    private String dealername;

    private String shop;

    private String shopname;

    private String clientsort;

    private String district;

    private String province;

    private String city;

    private Integer ordertype;

    private String address;

    private String postcode;

    private String phone;

    private String bossname;

    private String area;

    private String mode;

    private BigDecimal payrate;

    private String orderno;

    private Byte orderstate;

    private Date orderdate;

    private String prodcode;

    private String colorcode;

    private String color;

    private String pattern;

    private Integer qtysum;

    private BigDecimal unitprice;

    private BigDecimal amountsum;

    private String matchcontent;

    private Integer qtycase;

    private BigDecimal unitprice2;

    private BigDecimal unitprice3;

    private BigDecimal unitprice4;

    private BigDecimal discount;

    private BigDecimal discountprice;

    private BigDecimal discountmoney;

    private Integer size1;

    private Integer size2;

    private Integer size3;

    private Integer size4;

    private Integer size5;

    private Integer size6;

    private Integer size7;

    private Integer size8;

    private Integer size9;

    private Integer size10;

    private Integer size11;

    private Integer size12;

    private Integer size13;

    private Integer size14;

    private Integer size15;

    private Integer size16;

    private Integer size17;

    private Integer size18;

    private Integer size19;

    private Integer size20;

    private Integer size21;

    private Integer size22;

    private Integer size23;

    private Integer size24;

    private Integer size25;

    private Integer size26;

    private Integer size27;

    private Integer size28;

    private Integer size29;

    private Integer size30;

    private Integer prodid;

    private String barcode;

    private String prodname;

    private String brand;

    private String category;

    private String clazz;

    private String series;

    private String sex;

    private String marketband;

    private String prodyear;

    private String season;

    private String sizeclass;

    private String part;

    private String priceband;

    private String ageband;

    private String recommendtype;

    private String position;

    private String colorseries;

    private String material;

    private String designer;

    private Boolean mustorder;

    private Integer minimumorder;

    private String basicunit;

    private String businessunit;

    private String packingspec;

    private String prodremark;

    private String targetsort;

    private String discountsort;

    private Boolean isoldproduct;

    private Boolean ismainorder;

    private String picturecode;

    private String assortpicturecode;

    private Integer prodguid;

    private Boolean isadvertisement;

    private Boolean isdisplaywindow;

    private Boolean isbasic;

    private String groupcode;

    private String orderlcm;

    private String remark;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    private String reserve7;

    private String reserve8;

    private String reserve9;

    private String reserve10;

    private Boolean isactive;

    private Integer sizedesc;

    private Integer realsizenumber;

    private static final long serialVersionUID = 1L;

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

    public String getClientsort() {
        return clientsort;
    }

    public void setClientsort(String clientsort) {
        this.clientsort = clientsort == null ? null : clientsort.trim();
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

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
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

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Byte getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Byte orderstate) {
        this.orderstate = orderstate;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getProdcode() {
        return prodcode;
    }

    public void setProdcode(String prodcode) {
        this.prodcode = prodcode == null ? null : prodcode.trim();
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode == null ? null : colorcode.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

    public Integer getQtysum() {
        return qtysum;
    }

    public void setQtysum(Integer qtysum) {
        this.qtysum = qtysum;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public BigDecimal getAmountsum() {
        return amountsum;
    }

    public void setAmountsum(BigDecimal amountsum) {
        this.amountsum = amountsum;
    }

    public String getMatchcontent() {
        return matchcontent;
    }

    public void setMatchcontent(String matchcontent) {
        this.matchcontent = matchcontent == null ? null : matchcontent.trim();
    }

    public Integer getQtycase() {
        return qtycase;
    }

    public void setQtycase(Integer qtycase) {
        this.qtycase = qtycase;
    }

    public BigDecimal getUnitprice2() {
        return unitprice2;
    }

    public void setUnitprice2(BigDecimal unitprice2) {
        this.unitprice2 = unitprice2;
    }

    public BigDecimal getUnitprice3() {
        return unitprice3;
    }

    public void setUnitprice3(BigDecimal unitprice3) {
        this.unitprice3 = unitprice3;
    }

    public BigDecimal getUnitprice4() {
        return unitprice4;
    }

    public void setUnitprice4(BigDecimal unitprice4) {
        this.unitprice4 = unitprice4;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(BigDecimal discountprice) {
        this.discountprice = discountprice;
    }

    public BigDecimal getDiscountmoney() {
        return discountmoney;
    }

    public void setDiscountmoney(BigDecimal discountmoney) {
        this.discountmoney = discountmoney;
    }

    public Integer getSize1() {
        return size1;
    }

    public void setSize1(Integer size1) {
        this.size1 = size1;
    }

    public Integer getSize2() {
        return size2;
    }

    public void setSize2(Integer size2) {
        this.size2 = size2;
    }

    public Integer getSize3() {
        return size3;
    }

    public void setSize3(Integer size3) {
        this.size3 = size3;
    }

    public Integer getSize4() {
        return size4;
    }

    public void setSize4(Integer size4) {
        this.size4 = size4;
    }

    public Integer getSize5() {
        return size5;
    }

    public void setSize5(Integer size5) {
        this.size5 = size5;
    }

    public Integer getSize6() {
        return size6;
    }

    public void setSize6(Integer size6) {
        this.size6 = size6;
    }

    public Integer getSize7() {
        return size7;
    }

    public void setSize7(Integer size7) {
        this.size7 = size7;
    }

    public Integer getSize8() {
        return size8;
    }

    public void setSize8(Integer size8) {
        this.size8 = size8;
    }

    public Integer getSize9() {
        return size9;
    }

    public void setSize9(Integer size9) {
        this.size9 = size9;
    }

    public Integer getSize10() {
        return size10;
    }

    public void setSize10(Integer size10) {
        this.size10 = size10;
    }

    public Integer getSize11() {
        return size11;
    }

    public void setSize11(Integer size11) {
        this.size11 = size11;
    }

    public Integer getSize12() {
        return size12;
    }

    public void setSize12(Integer size12) {
        this.size12 = size12;
    }

    public Integer getSize13() {
        return size13;
    }

    public void setSize13(Integer size13) {
        this.size13 = size13;
    }

    public Integer getSize14() {
        return size14;
    }

    public void setSize14(Integer size14) {
        this.size14 = size14;
    }

    public Integer getSize15() {
        return size15;
    }

    public void setSize15(Integer size15) {
        this.size15 = size15;
    }

    public Integer getSize16() {
        return size16;
    }

    public void setSize16(Integer size16) {
        this.size16 = size16;
    }

    public Integer getSize17() {
        return size17;
    }

    public void setSize17(Integer size17) {
        this.size17 = size17;
    }

    public Integer getSize18() {
        return size18;
    }

    public void setSize18(Integer size18) {
        this.size18 = size18;
    }

    public Integer getSize19() {
        return size19;
    }

    public void setSize19(Integer size19) {
        this.size19 = size19;
    }

    public Integer getSize20() {
        return size20;
    }

    public void setSize20(Integer size20) {
        this.size20 = size20;
    }

    public Integer getSize21() {
        return size21;
    }

    public void setSize21(Integer size21) {
        this.size21 = size21;
    }

    public Integer getSize22() {
        return size22;
    }

    public void setSize22(Integer size22) {
        this.size22 = size22;
    }

    public Integer getSize23() {
        return size23;
    }

    public void setSize23(Integer size23) {
        this.size23 = size23;
    }

    public Integer getSize24() {
        return size24;
    }

    public void setSize24(Integer size24) {
        this.size24 = size24;
    }

    public Integer getSize25() {
        return size25;
    }

    public void setSize25(Integer size25) {
        this.size25 = size25;
    }

    public Integer getSize26() {
        return size26;
    }

    public void setSize26(Integer size26) {
        this.size26 = size26;
    }

    public Integer getSize27() {
        return size27;
    }

    public void setSize27(Integer size27) {
        this.size27 = size27;
    }

    public Integer getSize28() {
        return size28;
    }

    public void setSize28(Integer size28) {
        this.size28 = size28;
    }

    public Integer getSize29() {
        return size29;
    }

    public void setSize29(Integer size29) {
        this.size29 = size29;
    }

    public Integer getSize30() {
        return size30;
    }

    public void setSize30(Integer size30) {
        this.size30 = size30;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname == null ? null : prodname.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series == null ? null : series.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMarketband() {
        return marketband;
    }

    public void setMarketband(String marketband) {
        this.marketband = marketband == null ? null : marketband.trim();
    }

    public String getProdyear() {
        return prodyear;
    }

    public void setProdyear(String prodyear) {
        this.prodyear = prodyear == null ? null : prodyear.trim();
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
    }

    public String getSizeclass() {
        return sizeclass;
    }

    public void setSizeclass(String sizeclass) {
        this.sizeclass = sizeclass == null ? null : sizeclass.trim();
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part == null ? null : part.trim();
    }

    public String getPriceband() {
        return priceband;
    }

    public void setPriceband(String priceband) {
        this.priceband = priceband == null ? null : priceband.trim();
    }

    public String getAgeband() {
        return ageband;
    }

    public void setAgeband(String ageband) {
        this.ageband = ageband == null ? null : ageband.trim();
    }

    public String getRecommendtype() {
        return recommendtype;
    }

    public void setRecommendtype(String recommendtype) {
        this.recommendtype = recommendtype == null ? null : recommendtype.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getColorseries() {
        return colorseries;
    }

    public void setColorseries(String colorseries) {
        this.colorseries = colorseries == null ? null : colorseries.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer == null ? null : designer.trim();
    }

    public Boolean getMustorder() {
        return mustorder;
    }

    public void setMustorder(Boolean mustorder) {
        this.mustorder = mustorder;
    }

    public Integer getMinimumorder() {
        return minimumorder;
    }

    public void setMinimumorder(Integer minimumorder) {
        this.minimumorder = minimumorder;
    }

    public String getBasicunit() {
        return basicunit;
    }

    public void setBasicunit(String basicunit) {
        this.basicunit = basicunit == null ? null : basicunit.trim();
    }

    public String getBusinessunit() {
        return businessunit;
    }

    public void setBusinessunit(String businessunit) {
        this.businessunit = businessunit == null ? null : businessunit.trim();
    }

    public String getPackingspec() {
        return packingspec;
    }

    public void setPackingspec(String packingspec) {
        this.packingspec = packingspec == null ? null : packingspec.trim();
    }

    public String getProdremark() {
        return prodremark;
    }

    public void setProdremark(String prodremark) {
        this.prodremark = prodremark == null ? null : prodremark.trim();
    }

    public String getTargetsort() {
        return targetsort;
    }

    public void setTargetsort(String targetsort) {
        this.targetsort = targetsort == null ? null : targetsort.trim();
    }

    public String getDiscountsort() {
        return discountsort;
    }

    public void setDiscountsort(String discountsort) {
        this.discountsort = discountsort == null ? null : discountsort.trim();
    }

    public Boolean getIsoldproduct() {
        return isoldproduct;
    }

    public void setIsoldproduct(Boolean isoldproduct) {
        this.isoldproduct = isoldproduct;
    }

    public Boolean getIsmainorder() {
        return ismainorder;
    }

    public void setIsmainorder(Boolean ismainorder) {
        this.ismainorder = ismainorder;
    }

    public String getPicturecode() {
        return picturecode;
    }

    public void setPicturecode(String picturecode) {
        this.picturecode = picturecode == null ? null : picturecode.trim();
    }

    public String getAssortpicturecode() {
        return assortpicturecode;
    }

    public void setAssortpicturecode(String assortpicturecode) {
        this.assortpicturecode = assortpicturecode == null ? null : assortpicturecode.trim();
    }

    public Integer getProdguid() {
        return prodguid;
    }

    public void setProdguid(Integer prodguid) {
        this.prodguid = prodguid;
    }

    public Boolean getIsadvertisement() {
        return isadvertisement;
    }

    public void setIsadvertisement(Boolean isadvertisement) {
        this.isadvertisement = isadvertisement;
    }

    public Boolean getIsdisplaywindow() {
        return isdisplaywindow;
    }

    public void setIsdisplaywindow(Boolean isdisplaywindow) {
        this.isdisplaywindow = isdisplaywindow;
    }

    public Boolean getIsbasic() {
        return isbasic;
    }

    public void setIsbasic(Boolean isbasic) {
        this.isbasic = isbasic;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    public String getOrderlcm() {
        return orderlcm;
    }

    public void setOrderlcm(String orderlcm) {
        this.orderlcm = orderlcm == null ? null : orderlcm.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4 == null ? null : reserve4.trim();
    }

    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5 == null ? null : reserve5.trim();
    }

    public String getReserve6() {
        return reserve6;
    }

    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6 == null ? null : reserve6.trim();
    }

    public String getReserve7() {
        return reserve7;
    }

    public void setReserve7(String reserve7) {
        this.reserve7 = reserve7 == null ? null : reserve7.trim();
    }

    public String getReserve8() {
        return reserve8;
    }

    public void setReserve8(String reserve8) {
        this.reserve8 = reserve8 == null ? null : reserve8.trim();
    }

    public String getReserve9() {
        return reserve9;
    }

    public void setReserve9(String reserve9) {
        this.reserve9 = reserve9 == null ? null : reserve9.trim();
    }

    public String getReserve10() {
        return reserve10;
    }

    public void setReserve10(String reserve10) {
        this.reserve10 = reserve10 == null ? null : reserve10.trim();
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Integer getSizedesc() {
        return sizedesc;
    }

    public void setSizedesc(Integer sizedesc) {
        this.sizedesc = sizedesc;
    }

    public Integer getRealsizenumber() {
        return realsizenumber;
    }

    public void setRealsizenumber(Integer realsizenumber) {
        this.realsizenumber = realsizenumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", head=").append(head);
        sb.append(", headname=").append(headname);
        sb.append(", region=").append(region);
        sb.append(", regionname=").append(regionname);
        sb.append(", agent=").append(agent);
        sb.append(", agentname=").append(agentname);
        sb.append(", dealer=").append(dealer);
        sb.append(", dealername=").append(dealername);
        sb.append(", shop=").append(shop);
        sb.append(", shopname=").append(shopname);
        sb.append(", clientsort=").append(clientsort);
        sb.append(", district=").append(district);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", ordertype=").append(ordertype);
        sb.append(", address=").append(address);
        sb.append(", postcode=").append(postcode);
        sb.append(", phone=").append(phone);
        sb.append(", bossname=").append(bossname);
        sb.append(", area=").append(area);
        sb.append(", mode=").append(mode);
        sb.append(", payrate=").append(payrate);
        sb.append(", orderno=").append(orderno);
        sb.append(", orderstate=").append(orderstate);
        sb.append(", orderdate=").append(orderdate);
        sb.append(", prodcode=").append(prodcode);
        sb.append(", colorcode=").append(colorcode);
        sb.append(", color=").append(color);
        sb.append(", pattern=").append(pattern);
        sb.append(", qtysum=").append(qtysum);
        sb.append(", unitprice=").append(unitprice);
        sb.append(", amountsum=").append(amountsum);
        sb.append(", matchcontent=").append(matchcontent);
        sb.append(", qtycase=").append(qtycase);
        sb.append(", unitprice2=").append(unitprice2);
        sb.append(", unitprice3=").append(unitprice3);
        sb.append(", unitprice4=").append(unitprice4);
        sb.append(", discount=").append(discount);
        sb.append(", discountprice=").append(discountprice);
        sb.append(", discountmoney=").append(discountmoney);
        sb.append(", size1=").append(size1);
        sb.append(", size2=").append(size2);
        sb.append(", size3=").append(size3);
        sb.append(", size4=").append(size4);
        sb.append(", size5=").append(size5);
        sb.append(", size6=").append(size6);
        sb.append(", size7=").append(size7);
        sb.append(", size8=").append(size8);
        sb.append(", size9=").append(size9);
        sb.append(", size10=").append(size10);
        sb.append(", size11=").append(size11);
        sb.append(", size12=").append(size12);
        sb.append(", size13=").append(size13);
        sb.append(", size14=").append(size14);
        sb.append(", size15=").append(size15);
        sb.append(", size16=").append(size16);
        sb.append(", size17=").append(size17);
        sb.append(", size18=").append(size18);
        sb.append(", size19=").append(size19);
        sb.append(", size20=").append(size20);
        sb.append(", size21=").append(size21);
        sb.append(", size22=").append(size22);
        sb.append(", size23=").append(size23);
        sb.append(", size24=").append(size24);
        sb.append(", size25=").append(size25);
        sb.append(", size26=").append(size26);
        sb.append(", size27=").append(size27);
        sb.append(", size28=").append(size28);
        sb.append(", size29=").append(size29);
        sb.append(", size30=").append(size30);
        sb.append(", prodid=").append(prodid);
        sb.append(", barcode=").append(barcode);
        sb.append(", prodname=").append(prodname);
        sb.append(", brand=").append(brand);
        sb.append(", category=").append(category);
        sb.append(", clazz=").append(clazz);
        sb.append(", series=").append(series);
        sb.append(", sex=").append(sex);
        sb.append(", marketband=").append(marketband);
        sb.append(", prodyear=").append(prodyear);
        sb.append(", season=").append(season);
        sb.append(", sizeclass=").append(sizeclass);
        sb.append(", part=").append(part);
        sb.append(", priceband=").append(priceband);
        sb.append(", ageband=").append(ageband);
        sb.append(", recommendtype=").append(recommendtype);
        sb.append(", position=").append(position);
        sb.append(", colorseries=").append(colorseries);
        sb.append(", material=").append(material);
        sb.append(", designer=").append(designer);
        sb.append(", mustorder=").append(mustorder);
        sb.append(", minimumorder=").append(minimumorder);
        sb.append(", basicunit=").append(basicunit);
        sb.append(", businessunit=").append(businessunit);
        sb.append(", packingspec=").append(packingspec);
        sb.append(", prodremark=").append(prodremark);
        sb.append(", targetsort=").append(targetsort);
        sb.append(", discountsort=").append(discountsort);
        sb.append(", isoldproduct=").append(isoldproduct);
        sb.append(", ismainorder=").append(ismainorder);
        sb.append(", picturecode=").append(picturecode);
        sb.append(", assortpicturecode=").append(assortpicturecode);
        sb.append(", prodguid=").append(prodguid);
        sb.append(", isadvertisement=").append(isadvertisement);
        sb.append(", isdisplaywindow=").append(isdisplaywindow);
        sb.append(", isbasic=").append(isbasic);
        sb.append(", groupcode=").append(groupcode);
        sb.append(", orderlcm=").append(orderlcm);
        sb.append(", remark=").append(remark);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", reserve3=").append(reserve3);
        sb.append(", reserve4=").append(reserve4);
        sb.append(", reserve5=").append(reserve5);
        sb.append(", reserve6=").append(reserve6);
        sb.append(", reserve7=").append(reserve7);
        sb.append(", reserve8=").append(reserve8);
        sb.append(", reserve9=").append(reserve9);
        sb.append(", reserve10=").append(reserve10);
        sb.append(", isactive=").append(isactive);
        sb.append(", sizedesc=").append(sizedesc);
        sb.append(", realsizenumber=").append(realsizenumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.linjr.entity.db2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseProduct implements Serializable {
    private String prodcode;

    private String colorcode;

    private String pattern;

    private Integer prodguid;

    private Integer prodid;

    private String color;

    private String barcode;

    private String prodname;

    private String brand;

    private String category;

    private String series;

    private String sex;

    private String clazz;

    private String sizeclass;

    private String size;

    private String part;

    private String position;

    private String colorseries;

    private String material;

    private BigDecimal unitprice;

    private Boolean mustorder;

    private String recommendtype;

    private String marketband;

    private String priceband;

    private String ageband;

    private String designer;

    private Integer minimumorder;

    private String pdainterface1;

    private String pdainterface2;

    private String prodyear;

    private String season;

    private String basicunit;

    private String businessunit;

    private String packingspec;

    private Boolean isactive;

    private Boolean isdeleted;

    private String prodremark;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String edituser;

    private Date wno;

    private Integer version;

    private BigDecimal unitprice2;

    private BigDecimal unitprice3;

    private BigDecimal unitprice4;

    private String targetsort;

    private String discountsort;

    private String unionprodcode;

    private String groupcode;

    private Boolean isoldproduct;

    private Boolean ismainorder;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    private String reserve7;

    private String reserve8;

    private String reserve9;

    private String reserve10;

    private Boolean isfixedprod;

    private String picturecode;

    private String assortpicturecode;

    private String orderlcm;

    private String editdesc;

    private String disablesize;

    private String shpicturecode;

    private Boolean issurvey;

    private Boolean isadvertisement;

    private Boolean isdisplaywindow;

    private Boolean isbasic;

    private String unordersize;

    private Integer qtysum;

    private String size1;

    private String size2;

    private String size3;

    private String size4;

    private String size5;

    private String size6;

    private String size7;

    private String size8;

    private String size9;

    private String size10;

    private String size11;

    private String size12;

    private String size13;

    private String size14;

    private String size15;

    private String size16;

    private String size17;

    private String size18;

    private String size19;

    private String size20;

    private String size21;

    private String size22;

    private String size23;

    private String size24;

    private String size25;

    private String size26;

    private String size27;

    private String size28;

    private String size29;

    private String size30;


    private byte[] timestamp;

    private static final long serialVersionUID = 1L;

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

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

    public Integer getProdguid() {
        return prodguid;
    }

    public void setProdguid(Integer prodguid) {
        this.prodguid = prodguid;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
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

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Boolean getMustorder() {
        return mustorder;
    }

    public void setMustorder(Boolean mustorder) {
        this.mustorder = mustorder;
    }

    public String getRecommendtype() {
        return recommendtype;
    }

    public void setRecommendtype(String recommendtype) {
        this.recommendtype = recommendtype == null ? null : recommendtype.trim();
    }

    public String getMarketband() {
        return marketband;
    }

    public void setMarketband(String marketband) {
        this.marketband = marketband == null ? null : marketband.trim();
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

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer == null ? null : designer.trim();
    }

    public Integer getMinimumorder() {
        return minimumorder;
    }

    public void setMinimumorder(Integer minimumorder) {
        this.minimumorder = minimumorder;
    }

    public String getPdainterface1() {
        return pdainterface1;
    }

    public void setPdainterface1(String pdainterface1) {
        this.pdainterface1 = pdainterface1 == null ? null : pdainterface1.trim();
    }

    public String getPdainterface2() {
        return pdainterface2;
    }

    public void setPdainterface2(String pdainterface2) {
        this.pdainterface2 = pdainterface2 == null ? null : pdainterface2.trim();
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

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getProdremark() {
        return prodremark;
    }

    public void setProdremark(String prodremark) {
        this.prodremark = prodremark == null ? null : prodremark.trim();
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getUnionprodcode() {
        return unionprodcode;
    }

    public void setUnionprodcode(String unionprodcode) {
        this.unionprodcode = unionprodcode == null ? null : unionprodcode.trim();
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
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

    public Boolean getIsfixedprod() {
        return isfixedprod;
    }

    public void setIsfixedprod(Boolean isfixedprod) {
        this.isfixedprod = isfixedprod;
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

    public String getOrderlcm() {
        return orderlcm;
    }

    public void setOrderlcm(String orderlcm) {
        this.orderlcm = orderlcm == null ? null : orderlcm.trim();
    }

    public String getEditdesc() {
        return editdesc;
    }

    public void setEditdesc(String editdesc) {
        this.editdesc = editdesc == null ? null : editdesc.trim();
    }

    public String getDisablesize() {
        return disablesize;
    }

    public void setDisablesize(String disablesize) {
        this.disablesize = disablesize == null ? null : disablesize.trim();
    }

    public String getShpicturecode() {
        return shpicturecode;
    }

    public void setShpicturecode(String shpicturecode) {
        this.shpicturecode = shpicturecode == null ? null : shpicturecode.trim();
    }

    public Boolean getIssurvey() {
        return issurvey;
    }

    public void setIssurvey(Boolean issurvey) {
        this.issurvey = issurvey;
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

    public String getUnordersize() {
        return unordersize;
    }

    public void setUnordersize(String unordersize) {
        this.unordersize = unordersize == null ? null : unordersize.trim();
    }

    public byte[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQtysum() {
        return qtysum;
    }

    public void setQtysum(Integer qtysum) {
        this.qtysum = qtysum;
    }

    public String getSize1() {
        return size1;
    }

    public void setSize1(String size1) {
        this.size1 = size1;
    }

    public String getSize2() {
        return size2;
    }

    public void setSize2(String size2) {
        this.size2 = size2;
    }

    public String getSize3() {
        return size3;
    }

    public void setSize3(String size3) {
        this.size3 = size3;
    }

    public String getSize4() {
        return size4;
    }

    public void setSize4(String size4) {
        this.size4 = size4;
    }

    public String getSize5() {
        return size5;
    }

    public void setSize5(String size5) {
        this.size5 = size5;
    }

    public String getSize6() {
        return size6;
    }

    public void setSize6(String size6) {
        this.size6 = size6;
    }

    public String getSize7() {
        return size7;
    }

    public void setSize7(String size7) {
        this.size7 = size7;
    }

    public String getSize8() {
        return size8;
    }

    public void setSize8(String size8) {
        this.size8 = size8;
    }

    public String getSize9() {
        return size9;
    }

    public void setSize9(String size9) {
        this.size9 = size9;
    }

    public String getSize10() {
        return size10;
    }

    public void setSize10(String size10) {
        this.size10 = size10;
    }

    public String getSize11() {
        return size11;
    }

    public void setSize11(String size11) {
        this.size11 = size11;
    }

    public String getSize12() {
        return size12;
    }

    public void setSize12(String size12) {
        this.size12 = size12;
    }

    public String getSize13() {
        return size13;
    }

    public void setSize13(String size13) {
        this.size13 = size13;
    }

    public String getSize14() {
        return size14;
    }

    public void setSize14(String size14) {
        this.size14 = size14;
    }

    public String getSize15() {
        return size15;
    }

    public void setSize15(String size15) {
        this.size15 = size15;
    }

    public String getSize16() {
        return size16;
    }

    public void setSize16(String size16) {
        this.size16 = size16;
    }

    public String getSize17() {
        return size17;
    }

    public void setSize17(String size17) {
        this.size17 = size17;
    }

    public String getSize18() {
        return size18;
    }

    public void setSize18(String size18) {
        this.size18 = size18;
    }

    public String getSize19() {
        return size19;
    }

    public void setSize19(String size19) {
        this.size19 = size19;
    }

    public String getSize20() {
        return size20;
    }

    public void setSize20(String size20) {
        this.size20 = size20;
    }

    public String getSize21() {
        return size21;
    }

    public void setSize21(String size21) {
        this.size21 = size21;
    }

    public String getSize22() {
        return size22;
    }

    public void setSize22(String size22) {
        this.size22 = size22;
    }

    public String getSize23() {
        return size23;
    }

    public void setSize23(String size23) {
        this.size23 = size23;
    }

    public String getSize24() {
        return size24;
    }

    public void setSize24(String size24) {
        this.size24 = size24;
    }

    public String getSize25() {
        return size25;
    }

    public void setSize25(String size25) {
        this.size25 = size25;
    }

    public String getSize26() {
        return size26;
    }

    public void setSize26(String size26) {
        this.size26 = size26;
    }

    public String getSize27() {
        return size27;
    }

    public void setSize27(String size27) {
        this.size27 = size27;
    }

    public String getSize28() {
        return size28;
    }

    public void setSize28(String size28) {
        this.size28 = size28;
    }

    public String getSize29() {
        return size29;
    }

    public void setSize29(String size29) {
        this.size29 = size29;
    }

    public String getSize30() {
        return size30;
    }

    public void setSize30(String size30) {
        this.size30 = size30;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prodcode=").append(prodcode);
        sb.append(", colorcode=").append(colorcode);
        sb.append(", pattern=").append(pattern);
        sb.append(", prodguid=").append(prodguid);
        sb.append(", prodid=").append(prodid);
        sb.append(", color=").append(color);
        sb.append(", barcode=").append(barcode);
        sb.append(", prodname=").append(prodname);
        sb.append(", brand=").append(brand);
        sb.append(", category=").append(category);
        sb.append(", series=").append(series);
        sb.append(", sex=").append(sex);
        sb.append(", clazz=").append(clazz);
        sb.append(", sizeclass=").append(sizeclass);
        sb.append(", size=").append(size);
        sb.append(", part=").append(part);
        sb.append(", position=").append(position);
        sb.append(", colorseries=").append(colorseries);
        sb.append(", material=").append(material);
        sb.append(", unitprice=").append(unitprice);
        sb.append(", mustorder=").append(mustorder);
        sb.append(", recommendtype=").append(recommendtype);
        sb.append(", marketband=").append(marketband);
        sb.append(", priceband=").append(priceband);
        sb.append(", ageband=").append(ageband);
        sb.append(", designer=").append(designer);
        sb.append(", minimumorder=").append(minimumorder);
        sb.append(", pdainterface1=").append(pdainterface1);
        sb.append(", pdainterface2=").append(pdainterface2);
        sb.append(", prodyear=").append(prodyear);
        sb.append(", season=").append(season);
        sb.append(", basicunit=").append(basicunit);
        sb.append(", businessunit=").append(businessunit);
        sb.append(", packingspec=").append(packingspec);
        sb.append(", isactive=").append(isactive);
        sb.append(", isdeleted=").append(isdeleted);
        sb.append(", prodremark=").append(prodremark);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", reserve3=").append(reserve3);
        sb.append(", edituser=").append(edituser);
        sb.append(", wno=").append(wno);
        sb.append(", version=").append(version);
        sb.append(", unitprice2=").append(unitprice2);
        sb.append(", unitprice3=").append(unitprice3);
        sb.append(", unitprice4=").append(unitprice4);
        sb.append(", targetsort=").append(targetsort);
        sb.append(", discountsort=").append(discountsort);
        sb.append(", unionprodcode=").append(unionprodcode);
        sb.append(", groupcode=").append(groupcode);
        sb.append(", isoldproduct=").append(isoldproduct);
        sb.append(", ismainorder=").append(ismainorder);
        sb.append(", reserve4=").append(reserve4);
        sb.append(", reserve5=").append(reserve5);
        sb.append(", reserve6=").append(reserve6);
        sb.append(", reserve7=").append(reserve7);
        sb.append(", reserve8=").append(reserve8);
        sb.append(", reserve9=").append(reserve9);
        sb.append(", reserve10=").append(reserve10);
        sb.append(", isfixedprod=").append(isfixedprod);
        sb.append(", picturecode=").append(picturecode);
        sb.append(", assortpicturecode=").append(assortpicturecode);
        sb.append(", orderlcm=").append(orderlcm);
        sb.append(", editdesc=").append(editdesc);
        sb.append(", disablesize=").append(disablesize);
        sb.append(", shpicturecode=").append(shpicturecode);
        sb.append(", issurvey=").append(issurvey);
        sb.append(", isadvertisement=").append(isadvertisement);
        sb.append(", isdisplaywindow=").append(isdisplaywindow);
        sb.append(", isbasic=").append(isbasic);
        sb.append(", unordersize=").append(unordersize);
        sb.append(", qtysum=").append(qtysum);
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
        sb.append(", timestamp=").append(timestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
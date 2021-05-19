package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BaseProductUpdateReqVO {

    @ApiModelProperty(value = "序号")
    @NotNull(message = "序号不能为空")
    private Integer prodid;

    @ApiModelProperty(value = "款号")
    @NotBlank(message = "款号不能为空")
    private String prodcode;

    @ApiModelProperty(value = "版型")
    private String pattern;

    @ApiModelProperty(value = "色号")
    @NotBlank(message = "色号不能为空")
    private String colorcode;

    @ApiModelProperty(value = "大类")
    private String category;

    @ApiModelProperty(value = "类别")
    private String clazz;

    @ApiModelProperty(value = "尺码组")
    @NotBlank(message = "尺码组不能为空")
    private String sizeclass;

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public String getProdcode() {
        return prodcode;
    }

    public void setProdcode(String prodcode) {
        this.prodcode = prodcode;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSizeclass() {
        return sizeclass;
    }

    public void setSizeclass(String sizeclass) {
        this.sizeclass = sizeclass;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "BaseProductUpdateReqVO{" +
                "prodid=" + prodid +
                ", prodcode='" + prodcode + '\'' +
                ", pattern='" + pattern + '\'' +
                ", colorcode='" + colorcode + '\'' +
                ", category='" + category + '\'' +
                ", clazz='" + clazz + '\'' +
                ", sizeclass='" + sizeclass + '\'' +
                '}';
    }
}

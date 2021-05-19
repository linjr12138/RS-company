package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class BaseProductPageReqVO {
    @ApiModelProperty("当前页数")
    private Integer pageNum;

    @ApiModelProperty("当前页总数")
    private Integer pageSize;

    @ApiModelProperty("序号")
    private Integer prodid;

    @ApiModelProperty("款号")
    private String prodcode;

    @ApiModelProperty("色号集合")
    private List<String> colorcode;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

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

    public List<String> getColorcode() {
        return colorcode;
    }

    public void setColorcode(List<String> colorcode) {
        this.colorcode = colorcode;
    }

    @Override
    public String toString() {
        return "BaseProductPageReqVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", prodid=" + prodid +
                ", prodcode='" + prodcode + '\'' +
                ", colorcode=" + colorcode +
                '}';
    }
}

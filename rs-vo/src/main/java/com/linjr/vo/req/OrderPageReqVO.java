package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class OrderPageReqVO {

    @ApiModelProperty(value = "当前第几页")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "当前页的总数")
    private Integer pageSize = 10;

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

    @Override
    public String toString() {
        return "OrderPageReqVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}

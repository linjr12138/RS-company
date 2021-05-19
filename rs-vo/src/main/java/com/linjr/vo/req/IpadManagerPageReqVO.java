package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class IpadManagerPageReqVO {
    @ApiModelProperty(value = "当前第几页")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "当前页的总数")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "区域ID")
    private String regionId;

    @ApiModelProperty(value = "账户状态(1.借 2.还 ")
    private Integer borrowReturn;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Integer getBorrowReturn() {
        return borrowReturn;
    }

    public void setBorrowReturn(Integer borrowReturn) {
        this.borrowReturn = borrowReturn;
    }

    @Override
    public String toString() {
        return "IpadManagerPageReqVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", regionId='" + regionId + '\'' +
                ", borrowReturn=" + borrowReturn +
                '}';
    }
}

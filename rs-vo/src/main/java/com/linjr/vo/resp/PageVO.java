package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: PageVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class PageVO<T> {
    @ApiModelProperty(value = "总记录数")
    private Long totalRows;
    @ApiModelProperty(value = "分页列表数据")
    private List<T> list;
    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private Integer totalPages;

    /**
     * 当前第几页
     */
    @ApiModelProperty(value = "当前第几页")
    private Integer pageNum;
    /**
     * 每页记录数
     */
    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;
    /**
     * 当前页记录数
     */
    @ApiModelProperty(value = "当前页记录数")
    private Integer curPageSize;

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

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

    public Integer getCurPageSize() {
        return curPageSize;
    }

    public void setCurPageSize(Integer curPageSize) {
        this.curPageSize = curPageSize;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "totalRows=" + totalRows +
                ", list=" + list +
                ", totalPages=" + totalPages +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", curPageSize=" + curPageSize +
                '}';
    }
}

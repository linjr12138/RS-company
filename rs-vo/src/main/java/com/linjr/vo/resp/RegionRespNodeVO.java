package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class RegionRespNodeVO {

    @ApiModelProperty(value = "区域id")
    private String id;

    @ApiModelProperty(value = "区域名称名称")
    private String title;

    @ApiModelProperty("是否展开 默认true")
    private boolean spread = true;

    @ApiModelProperty(value = "子集叶子节点")
    private List<?> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "RegionRespNodeVO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", spread=" + spread +
                ", children=" + children +
                '}';
    }
}

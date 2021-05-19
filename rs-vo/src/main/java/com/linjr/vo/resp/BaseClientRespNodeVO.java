package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class BaseClientRespNodeVO {
    @ApiModelProperty(value = "店铺id")
    private String clientcode;

    @ApiModelProperty(value = "名称")
    private String title;

    @ApiModelProperty("是否展开 默认true")
    private boolean spread = true;

    @ApiModelProperty(value = "子集叶子节点")
    private List<?> children;


    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode;
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
        return "BaseClientRespNodeVO{" +
                "clientcode='" + clientcode + '\'' +
                ", title='" + title + '\'' +
                ", spread=" + spread +
                ", children=" + children +
                '}';
    }
}

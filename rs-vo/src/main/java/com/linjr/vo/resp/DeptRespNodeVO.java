package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: DeptRespNodeVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class DeptRespNodeVO {

    @ApiModelProperty(value = "部门id")
    private String id;

    @ApiModelProperty(value = "部门名称")
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
        return "DeptRespNodeVO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", spread=" + spread +
                ", children=" + children +
                '}';
    }
}

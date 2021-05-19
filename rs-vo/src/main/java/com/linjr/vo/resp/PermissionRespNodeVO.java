package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: PermissionRespNodeVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class PermissionRespNodeVO {
    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "跳转地址")
    private String url;

    @ApiModelProperty(value = "菜单权限名称")
    private String title;

    @ApiModelProperty(value = "子集集合")
    private List<?> children;

    @ApiModelProperty(value = "默认展开")
    private boolean spread = true;

    @ApiModelProperty(value = "节点是否选中")
    private boolean checked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "PermissionRespNodeVO{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", children=" + children +
                ", spread=" + spread +
                ", checked=" + checked +
                '}';
    }
}

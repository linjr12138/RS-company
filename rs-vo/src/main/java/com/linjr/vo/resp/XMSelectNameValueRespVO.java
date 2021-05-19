package com.linjr.vo.resp;

public class XMSelectNameValueRespVO {

    private String name;

    private String value;

    private boolean selected = false;

    private boolean disabled = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "XMSelectNameValueRespVO{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", selected=" + selected +
                ", disabled=" + disabled +
                '}';
    }
}

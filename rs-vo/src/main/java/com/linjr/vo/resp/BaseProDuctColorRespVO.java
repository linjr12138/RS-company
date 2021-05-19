package com.linjr.vo.resp;

public class BaseProDuctColorRespVO {

    private String name;

    private String value;


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

    @Override
    public String toString() {
        return "BaseProDuctColorRespVO{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

package com.linjr.entity.db2;

import java.util.Objects;

public class UnidimensionalOrderImport {
    private String clientcode;

    private String prodcode;

    private String colorcode;

    private String color;

    private String pattern;

    private String sizeclass;

    private String size;

    private String qtysum;

    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode;
    }

    public String getProdcode() {
        return prodcode;
    }

    public void setProdcode(String prodcode) {
        this.prodcode = prodcode;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getQtysum() {
        return qtysum;
    }

    public void setQtysum(String qtysum) {
        this.qtysum = qtysum;
    }

    public String getSizeclass() {
        return sizeclass;
    }

    public void setSizeclass(String sizeclass) {
        this.sizeclass = sizeclass;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "UnidimensionalOrderImport{" +
                "clientcode='" + clientcode + '\'' +
                ", prodcode='" + prodcode + '\'' +
                ", colorcode='" + colorcode + '\'' +
                ", color='" + color + '\'' +
                ", pattern='" + pattern + '\'' +
                ", qtysum='" + qtysum + '\'' +
                ", sizeclass='" + sizeclass + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

}

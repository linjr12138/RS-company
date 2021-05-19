package com.linjr.entity.db2;

import java.io.Serializable;

public class PsoDelTest implements Serializable {
    private String psoNum;

    private Integer prodId;

    private static final long serialVersionUID = 1L;

    public String getPsoNum() {
        return psoNum;
    }

    public void setPsoNum(String psoNum) {
        this.psoNum = psoNum == null ? null : psoNum.trim();
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", psoNum=").append(psoNum);
        sb.append(", prodId=").append(prodId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
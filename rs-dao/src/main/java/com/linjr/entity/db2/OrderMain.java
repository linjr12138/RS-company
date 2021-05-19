package com.linjr.entity.db2;

import java.io.Serializable;
import java.util.Date;

public class OrderMain implements Serializable {
    private String orderno;

    private String clientcode;

    private Byte ordertype;

    private Byte orderstate;

    private Boolean isinvalid;

    private String pdacode;

    private String orderremark;

    private String confirmman;

    private Date confirmdate;

    private String checkman;

    private Date checkdate;

    private String orderman;

    private Date orderdate;

    private Date wno;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private static final long serialVersionUID = 1L;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode == null ? null : clientcode.trim();
    }

    public Byte getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Byte ordertype) {
        this.ordertype = ordertype;
    }

    public Byte getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Byte orderstate) {
        this.orderstate = orderstate;
    }

    public Boolean getIsinvalid() {
        return isinvalid;
    }

    public void setIsinvalid(Boolean isinvalid) {
        this.isinvalid = isinvalid;
    }

    public String getPdacode() {
        return pdacode;
    }

    public void setPdacode(String pdacode) {
        this.pdacode = pdacode == null ? null : pdacode.trim();
    }

    public String getOrderremark() {
        return orderremark;
    }

    public void setOrderremark(String orderremark) {
        this.orderremark = orderremark == null ? null : orderremark.trim();
    }

    public String getConfirmman() {
        return confirmman;
    }

    public void setConfirmman(String confirmman) {
        this.confirmman = confirmman == null ? null : confirmman.trim();
    }

    public Date getConfirmdate() {
        return confirmdate;
    }

    public void setConfirmdate(Date confirmdate) {
        this.confirmdate = confirmdate;
    }

    public String getCheckman() {
        return checkman;
    }

    public void setCheckman(String checkman) {
        this.checkman = checkman == null ? null : checkman.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getOrderman() {
        return orderman;
    }

    public void setOrderman(String orderman) {
        this.orderman = orderman == null ? null : orderman.trim();
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getWno() {
        return wno;
    }

    public void setWno(Date wno) {
        this.wno = wno;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderno=").append(orderno);
        sb.append(", clientcode=").append(clientcode);
        sb.append(", ordertype=").append(ordertype);
        sb.append(", orderstate=").append(orderstate);
        sb.append(", isinvalid=").append(isinvalid);
        sb.append(", pdacode=").append(pdacode);
        sb.append(", orderremark=").append(orderremark);
        sb.append(", confirmman=").append(confirmman);
        sb.append(", confirmdate=").append(confirmdate);
        sb.append(", checkman=").append(checkman);
        sb.append(", checkdate=").append(checkdate);
        sb.append(", orderman=").append(orderman);
        sb.append(", orderdate=").append(orderdate);
        sb.append(", wno=").append(wno);
        sb.append(", reserve1=").append(reserve1);
        sb.append(", reserve2=").append(reserve2);
        sb.append(", reserve3=").append(reserve3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
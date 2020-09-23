package com.qiu.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private String oid;
    private int uid;
    private int aid;
    private BigDecimal ocount;
    private Date otime;
    private int ostate;
   private String adetail;

    public String getAdetail() {
        return adetail;
    }

    public void setAdetail(String adetail) {
        this.adetail = adetail;
    }

    public Order(String oid, int uid, int aid, BigDecimal ocount, Date otime, int ostate ,String adetail) {
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmdd");
        this.oid = sdf.format(date)+oid;
        this.uid = uid;
        this.aid = aid;
        this.ocount = ocount;
        this.otime = otime;
        this.ostate = ostate;
        this.adetail=adetail;
    }

    public Order() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public BigDecimal getOcount() {
        return ocount;
    }

    public void setOcount(BigDecimal ocount) {
        this.ocount = ocount;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }


}

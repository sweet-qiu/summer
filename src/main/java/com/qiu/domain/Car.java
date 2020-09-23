package com.qiu.domain;

import java.math.BigDecimal;

public class Car {
    private int cid;
    private int uid;
    private int pid;
    private BigDecimal ccount;
    private int cnum;
    private  String pname;
    private BigDecimal pprice;
    private  Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Car() {
    }
public Car(int cid, int uid, int pid, BigDecimal ccount, int cnum ){
    this.cid = cid;
    this.uid = uid;
    this.pid = pid;
    this.ccount = ccount;
    this.cnum = cnum;
}
    public Car(int cid, int uid, int pid, BigDecimal ccount, int cnum, String pname, BigDecimal pprice) {
        this.cid = cid;
        this.uid = uid;
        this.pid = pid;
        this.ccount = ccount;
        this.cnum = cnum;
        this.pname = pname;
        this.pprice = pprice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", ccount=" + ccount +
                ", cnum=" + cnum +
                ", pname='" + pname + '\'' +
                ", pprice=" + pprice +
                ", product=" + product +
                '}';
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public BigDecimal getCcount() {
        return ccount;
    }

    public void setCcount(BigDecimal ccount) {
        this.ccount = ccount;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }
}

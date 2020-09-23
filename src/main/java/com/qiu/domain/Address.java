package com.qiu.domain;

public class Address {
    private int aid;
    private int uid;
    private String aname;
    private String aphone;
    private String  adetail;
    private int astate;

    public Address() {
    }

    public Address(int aid, int uid, String aname, String aphone, String adetail, int astate) {
        this.aid = aid;
        this.uid = uid;
        this.aname = aname;
        this.aphone = aphone;
        this.adetail = adetail;
        this.astate = astate;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getAdetail() {
        return adetail;
    }

    public void setAdetail(String adetail) {
        this.adetail = adetail;
    }

    public int getAstate() {
        return astate;
    }

    public void setAstate(int astate) {
        this.astate = astate;
    }
}

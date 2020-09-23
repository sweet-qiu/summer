package com.qiu.domain;

public class Types {
    private  int tid;
    private String tname;
    private String tinfo;

    public Types() {
    }

    public Types(int tid, String tname, String tinfo) {
        this.tid = tid;
        this.tname = tname;
        this.tinfo = tinfo;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTinfo() {
        return tinfo;
    }

    public void setTinfo(String tinfo) {
        this.tinfo = tinfo;
    }
}

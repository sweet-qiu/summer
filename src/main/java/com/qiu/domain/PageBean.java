package com.qiu.domain;

import java.util.List;

public class PageBean {
    public long pagesize=5;
    public long nowpage;
    public long pagecount;
    public long totlecount;
    public long start;
    public List<?> list;
    public PageBean() {
    }

    public PageBean(long pagesize, long nowpage, long pagecount, long totlecount, long start, List<?> list) {
        this.pagesize = pagesize;
        this.nowpage = nowpage;
        this.pagecount = pagecount;
        this.totlecount = totlecount;
        this.start = start;
        this.list = list;
    }

    public long getPagesize() {
        return pagesize;
    }

    public void setPagesize(long pagesize) {
        this.pagesize = pagesize;
    }

    public long getNowpage() {
        return nowpage;
    }

    public void setNowpage(long nowpage) {
        this.nowpage = nowpage;
    }

    public long getPagecount() {
        return totlecount%pagesize==0?totlecount/pagesize:totlecount/pagesize+1;
    }

    public void setPagecount(long pagecount) {
        this.pagecount = pagecount;
    }

    public long getTotlecount() {
        return totlecount;
    }

    public void setTotlecount(long totlecount) {
        this.totlecount = totlecount;
    }


    public long getStart() {
        return (nowpage-1)*pagesize;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}

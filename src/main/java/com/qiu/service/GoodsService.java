package com.qiu.service;

import com.qiu.domain.PageBean;
import com.qiu.domain.Product;
import com.qiu.domain.Types;

import java.util.List;

public interface GoodsService {
    List<Types> findTypes();
    PageBean getGoods(int tid, int start, int pagesize);
   Product show(int pid);
}

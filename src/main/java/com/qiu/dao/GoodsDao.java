package com.qiu.dao;

import com.qiu.domain.Product;
import com.qiu.domain.Types;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
   List<Types> findTypes() throws SQLException;
    Long findBytype(int tid) throws SQLException;
   List<Product> queryGoods(int tid, int start, int pagesize) throws SQLException;
   Product queryById(int pid) throws SQLException;

}

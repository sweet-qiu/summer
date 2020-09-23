package com.qiu.dao;

import com.qiu.domain.Address;
import com.qiu.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    List<Address> query(int uid) throws SQLException;
    void insertAdd(Address address)throws SQLException;
    List<Order> queryOrder(int uid)throws SQLException;
    void addOrder(Order order)throws SQLException;
    Order QueryByOid(String oid)throws  SQLException;
}

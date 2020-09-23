package com.qiu.service;

import com.qiu.domain.Address;
import com.qiu.domain.Car;
import com.qiu.domain.Order;

import java.util.List;

public interface OrderService {
    List<Address> addAdress(int uid);
    void add(Address address);
    List<Order> orderList(int uid);
    Order addOrder(int aid, int uid);
    Order searchOrder(String oid);
    List<Car> show(int uid);
}

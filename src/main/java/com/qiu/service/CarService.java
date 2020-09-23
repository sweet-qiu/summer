package com.qiu.service;

import com.qiu.domain.Car;

import java.math.BigDecimal;
import java.util.List;

public interface CarService {
    int addCar(int pid, int uid);
    List<Car> getCar(int uid);
     int updateNum(int num, BigDecimal price, int cid);
    void clearAll(int uid);
    void clear(int cid);
}

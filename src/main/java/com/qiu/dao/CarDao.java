package com.qiu.dao;

import com.qiu.domain.Car;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    Car query(int uid, int pid) throws SQLException;
    int insertCar(Car car)throws SQLException;
    int update(BigDecimal count, int num, int cid) throws SQLException;
    List<Car> query(int uid)throws SQLException;
    Car queryByCid(int cid)throws  SQLException;
    void delete(int uid)throws  SQLException;
    void deleteBycid(int cid)throws SQLException;
    List<Car> queryCar(int uid)throws Exception;
}

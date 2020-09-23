package com.qiu.dao.userdaoimpl;

import com.qiu.domain.Car;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        CarDaoImpl dao=new CarDaoImpl();
        try {
            List<Car> cars = dao.queryCar(26);
            System.out.println(cars.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

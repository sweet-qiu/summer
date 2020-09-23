package com.qiu.service.serviceimpl;

import com.qiu.dao.CarDao;
import com.qiu.dao.OrderDao;
import com.qiu.dao.userdaoimpl.CarDaoImpl;
import com.qiu.dao.userdaoimpl.OrderDaoImpl;
import com.qiu.domain.Address;
import com.qiu.domain.Car;
import com.qiu.domain.Order;
import com.qiu.service.OrderService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderServiceIpl implements OrderService {
    private OrderDao dao=new OrderDaoImpl();
    private CarDao carDao=new CarDaoImpl();
    @Override
    public List<Order> orderList(int uid) {
        try {
            List<Order> orders = dao.queryOrder(uid);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order addOrder(int aid, int uid) {
        try {
            List<Car> query = carDao.query(uid);
            BigDecimal count=new BigDecimal(0);
            for (Car car : query) {
               count=count.add(car.getCcount());
            }
            int i = new Random().nextInt(10);

            Order order=new Order(1+"",uid ,aid ,count ,new Date(),0 ,null );
            dao.addOrder(order);
            return order;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Address address) {
        try {
            dao.insertAdd(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Address> addAdress(int uid) {
        try {
            List<Address> query = dao.query(uid);
            System.out.println(query+"***");
            if(query!=null) {
                return query;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> show(int uid) {
        try {
            List<Car> list = carDao.queryCar(uid);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order searchOrder(String oid) {
        try {
            Order order = dao.QueryByOid(oid);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

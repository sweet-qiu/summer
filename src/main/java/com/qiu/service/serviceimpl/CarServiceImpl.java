package com.qiu.service.serviceimpl;

import com.qiu.dao.CarDao;
import com.qiu.dao.GoodsDao;
import com.qiu.dao.userdaoimpl.CarDaoImpl;
import com.qiu.dao.userdaoimpl.GoodsDaoImpl;
import com.qiu.domain.Car;
import com.qiu.domain.Product;
import com.qiu.service.CarService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CarService {
    private CarDao dao=new CarDaoImpl();
    private GoodsDao goodsDao=new GoodsDaoImpl();

    @Override
    public int addCar(int pid,int uid) {

        try {
            Product product = goodsDao.queryById(pid);
            Car query = dao.query(uid, pid);
            int num=0;
            if(query==null){
                int i = dao.insertCar(new Car(0,uid,pid,product.getPprice(),1));
                Car query1 = dao.query(uid, pid);
                return query1.getCid();
            }else {
                int num1=query.getCnum()+1;
                int i = dao.update(query.getCcount().add(product.getPprice()), num1, query.getCid());
                return query.getCid();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Car> getCar(int uid) {
        try {
          return dao.query(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void clearAll(int uid) {
        try {
            dao.delete(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear(int cid) {
        try {
            dao.deleteBycid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int updateNum(int num, BigDecimal price, int cid){
        int i = 0;
        try {
            Car car = dao.queryByCid(cid);
            BigDecimal count=new BigDecimal(0);
            int num1=0;
            if(car!=null) {
                num1 = car.getCnum() + num;
                 count= car.getCcount();
            }
            if(num==0){
                dao.deleteBycid(cid);
                return 0;
            }
          if(num>0) {
               count = car.getCcount().add(price);
          }else {
              count=car.getCcount().subtract(price);

          }
            i = dao.update(count, num1, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}

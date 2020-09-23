package com.qiu.dao.userdaoimpl;

import com.qiu.dao.CarDao;
import com.qiu.domain.Car;
import com.qiu.domain.Product;
import com.qiu.utils.Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarDaoImpl implements CarDao {
    QueryRunner runner=new QueryRunner(Utils.getDataSource());
    @Override
    public Car query(int uid, int pid) throws SQLException {
        String sql="select c_id cid,u_id uid,p_id pid,c_count ccount,c_num cnum from cart where u_id=? and p_id=?";
        Car car = runner.query(sql, new BeanHandler<>(Car.class), uid, pid);
        return car;
    }

    @Override
    public int insertCar(Car car) throws SQLException {
        String sql="insert into cart values(0,?,?,?,?);";
        int i = runner.update(sql, car.getUid(), car.getPid(), car.getCcount(), car.getCnum());
        return i;
    }

    @Override
    public void deleteBycid(int cid) throws SQLException {
        String sql="delete from cart where c_id=?";
        runner.update(sql,cid );
    }

    @Override
    public void delete(int uid) throws SQLException {
        String sql = "delete from cart where u_id=?";
         runner.update(sql,uid);
    }

    @Override
    public Car queryByCid(int cid) throws SQLException {
        String sql="select c_id cid,u_id uid,p_id pid,c_count ccount,c_num cnum from cart where c_id=?";
        Car car = runner.query(sql, new BeanHandler<>(Car.class), cid);
        return car;
    }

    @Override
    public int update(BigDecimal count, int num, int cid) throws SQLException {
        String sql="update cart set c_count=?,c_num=? where c_id=?;";
        int i = runner.update(sql, count, num, cid);
        return i;
    }

    @Override
    public List<Car> query(int uid) throws SQLException {
        String sql="select c_id cid, p_name pname ,p_price pprice,c_count ccount ,c_num cnum FROM cart as c INNER join product as  p WHERE c.p_id=p.p_id AND u_id=?;";
        List<Car> list = runner.query(sql, new BeanListHandler<>(Car.class), uid);
        return list;
    }
    @Override
    public  List<Car> queryCar(int uid) throws Exception {
        String sql="select c_id cid,p_name pname,p_state pstate,p_price pprice,p_image pimage,p_time ptime,c_count ccount,c_num cnum from cart c ,product p where c.p_id=p.p_id and u_id=?";
        List<Map<String, Object>> query = runner.query(sql, new MapListHandler(), uid);
        List<Car> list=new ArrayList<>();
        for (Map<String, Object> map : query) {
            Car car=new Car();
            Product pro=new Product();
            BeanUtils.populate(car, map);
            BeanUtils.populate(pro, map);
            car.setProduct(pro);
            list.add(car);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        CarDaoImpl car=new CarDaoImpl();
        List<Car> list = car.queryCar(26);
        for (Car car1 : list) {
            System.out.println(car1.toString());
        }
    }
}

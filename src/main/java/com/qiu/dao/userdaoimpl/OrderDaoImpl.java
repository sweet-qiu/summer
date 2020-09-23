package com.qiu.dao.userdaoimpl;

import com.qiu.dao.OrderDao;
import com.qiu.domain.Address;
import com.qiu.domain.Order;
import com.qiu.utils.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    QueryRunner runner=new QueryRunner(Utils.getDataSource());

    @Override
    public Order QueryByOid(String oid) throws SQLException {
        String sql="select o_id oid,o.u_id uid,o.a_id aid,o_count ocount,o_time otime,o_state ostate ,a_detail adetail from address a,orders o where a.a_id=o.a_id and o.o_id=?; ";
        return runner.query(sql,new BeanHandler<>(Order.class),oid);
    }

    @Override
    public List<Address> query(int uid) throws SQLException {
        String sql="select a_id aid,u_id uid,a_name aname,a_phone aphone,a_detail adetail,a_state astate from address where u_id=?";
        return runner.query(sql, new BeanListHandler<>(Address.class),uid);
    }

    @Override
    public List<Order> queryOrder(int uid) throws SQLException {
        String sql="select o_id oid,o.a_id aid,o_count ocount,o_time otime,o_state ostate,a_detail adetail from address a,orders o where a.a_id=o.a_id and o.u_id=?;";
        return   runner.query(sql, new BeanListHandler<>(Order.class),uid);

    }

    @Override
    public void addOrder(Order order) throws SQLException {
        String sql="insert into orders values(?,?,?,?,?,?)";

     runner.update(sql,order.getOid(),order.getUid(),order.getAid(),order.getOcount(),order.getOtime(),order.getOstate() );


    }

    @Override
    public void insertAdd(Address address) throws SQLException {
       String sql="insert into address values(?,?,?,?,?,?);" ;
       runner.update(sql,address.getAid(),address.getUid(),address.getAname(),address.getAphone(),address.getAdetail(),0 );
    }
}

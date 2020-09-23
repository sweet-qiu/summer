package com.qiu.dao.userdaoimpl;

import com.qiu.dao.GoodsDao;
import com.qiu.domain.Product;
import com.qiu.domain.Types;
import com.qiu.utils.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    QueryRunner runner=new QueryRunner(Utils.getDataSource());

    @Override
    public Long findBytype(int tid) throws SQLException {
        String sql="select count(*) from  product where t_id=?";
        Long query = (Long)runner.query(sql, new ScalarHandler(), tid);
        return query;
    }

    @Override
    public List<Product> queryGoods(int tid,int start,int pagesize) throws SQLException {

        String sql="select p_id pid,t_id tid,p_name pname,p_time ptime,p_image pimage,p_price pprice,p_state pstate,p_info pinfo from product where t_id=? limit ?,?;";
        List<Product> goods = runner.query(sql, new BeanListHandler<>(Product.class), tid,start,pagesize);
        return goods;
    }

    @Override
    public Product queryById(int pid) throws SQLException {
        String sql="select p_id pid,t_id tid,p_name pname,p_time ptime,p_image pimage,p_price pprice,p_state pstate,p_info pinfo from product where p_id=?;";
        Product product = runner.query(sql, new BeanHandler<>(Product.class), pid);
        return product;
    }

    @Override
    public List<Types> findTypes() throws SQLException {
        String sql="select t_id tid,t_name tname from type;";
        List<Types> types = runner.query(sql, new BeanListHandler<>(Types.class));
        return types;
    }
}

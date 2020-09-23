package com.qiu.service.serviceimpl;

import com.qiu.dao.GoodsDao;
import com.qiu.dao.userdaoimpl.GoodsDaoImpl;
import com.qiu.domain.PageBean;
import com.qiu.domain.Product;
import com.qiu.domain.Types;
import com.qiu.service.GoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao dao=new GoodsDaoImpl();


    @Override
    public Product show(int pid) {

        try {
            Product product = dao.queryById(pid);
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageBean getGoods(int tid, int start, int pagesize) {
        PageBean bean=new PageBean( );
        try {
            Long count = dao.findBytype(tid);
            List<Product> products = dao.queryGoods(tid,start,pagesize );

            bean.setTotlecount(count);
            bean.setList(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public List<Types> findTypes() {

        try {
            List<Types> types = dao.findTypes();
            if(types!=null){
                return types;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

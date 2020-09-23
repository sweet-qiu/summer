package com.qiu.dao.userdaoimpl;


import com.qiu.dao.UserDao;
import com.qiu.domain.User;
import com.qiu.utils.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner runner=new QueryRunner(Utils.getDataSource());
    @Override
    public User queryByName(String name) throws SQLException {
        String sql="select u_id as id, u_name as name, u_password as password, u_email as email, u_sex as sex, u_status as status, u_code as code, u_role as role from user where u_name=?;";
        User user = runner.query(sql, new BeanHandler<>(User.class), name);
        return user;
    }

    @Override
    public User queryByCode(String code) throws SQLException {
        String sql="select u_id as id, u_name as name, u_password as password, u_email as email, u_sex as sex, u_status as status, u_code as code, u_role as role from user where u_code=?;";
        return runner.query(sql, new BeanHandler<User>(User.class),code);
    }

    @Override
    public int update(User user) throws SQLException {
        String sql="update  user set u_status =1,u_code=null where u_code=?;";
        int i = runner.update(sql,user.getCode());
        return i;
    }

    @Override
    public int  insert(User user) throws SQLException {
String sql="insert into user values(?,?,?,?,?,?,?,?)";
Object[] param={user.getId(),user.getName(),user.getPassword(),user.getEmail(),user.getSex(),user.getStatus(),user.getCode(),user.getRole()};
        int i = runner.update(sql, param);
        return i;
    }
}

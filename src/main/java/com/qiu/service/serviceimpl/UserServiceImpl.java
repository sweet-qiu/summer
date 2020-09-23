package com.qiu.service.serviceimpl;

import com.qiu.dao.UserDao;
import com.qiu.dao.userdaoimpl.UserDaoImpl;
import com.qiu.domain.User;
import com.qiu.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public int register(User user) {
        int i=0;
        try {
              i = dao.insert(user);
//            if(i>0){
//                String code = user.getCode();
//                String s = Base64.getEncoder().encode(code.getBytes()).toString();
//                String title="小米商城激活";
//                String ip = InetAddress.getLocalHost().getHostAddress();
//                String url="http://"+ip+":8080/controller?method=active&code=YRTUMRDLEZVTHCIIHJBJ"+code;
//                String content=user.getName()+":<br>您好，<a href='"+url+"'>请点击该链接激活账户</a>";
//                EmailUtils.sendEmail(title, content, user.getEmail());
//                return i;
//            }
            System.out.println(i+"********");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return i;
    }

    @Override
    public User login(String name,String password) {
        User user=null;
        try {
             user = dao.queryByName(name);
             if(user!=null&&user.getPassword().equals(password)){
                 return user;
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkName(String name) {
        try {
            User user = dao.queryByName(name);
            if(user==null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean active(String code) {
        try {
            User user = dao.queryByCode(code);
            if(user!=null){
                int i = dao.update(user);
                if(i!=0){
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

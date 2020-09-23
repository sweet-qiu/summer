package com.qiu.dao;

import com.qiu.domain.User;

import java.sql.SQLException;

public interface UserDao {
    User queryByName(String name) throws SQLException;
    int  insert(User user) throws SQLException;
    User queryByCode(String code) throws SQLException;
    int  update(User user) throws SQLException;
}

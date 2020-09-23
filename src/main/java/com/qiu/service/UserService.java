package com.qiu.service;

import com.qiu.domain.Car;
import com.qiu.domain.User;

import java.util.List;

public interface UserService {

    int  register(User user);
    User login(String name, String password);
    boolean checkName(String name);
    boolean active(String code);

}

package com.educationexampleproject.education.system.service.impl;

import com.educationexampleproject.education.system.dao.UserDao;
import com.educationexampleproject.education.system.entity.User;
import com.educationexampleproject.education.system.service.UserService;
import com.educationexampleproject.education.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public List<User> queryUser(String name) {
        return userDao.queryUser(name);
    }

    @Override
    public User login(String name, String password) {
        User user = userDao.login(name, password);
        return user;
    }

    @Override
    public int addUser(User user) {
        user.setId(UUIDUtil.getUUID());
        user.setPhone("xxx-xxxx-xxxx");
        user.setHeadImg("xxx");
        return userDao.addUser(user);
    }
}

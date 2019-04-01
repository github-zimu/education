package com.educationexampleproject.education.system.service;

import com.educationexampleproject.education.system.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> queryUser(String name);

    /**
     * 登录
     *
     * @return
     */
    User login(String name, String password);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);
}

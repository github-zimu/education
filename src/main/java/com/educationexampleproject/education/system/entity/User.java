package com.educationexampleproject.education.system.entity;

/**
 *  用户实体类
 */
public class User {

    // id
    private String id;
    // 用户名
    private String name;
    // 用户密码
    private String password;
    // 电话
    private String phone;
    // 头像路径
    private String headImg;
    // token验证
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getHeadImg() {
        return headImg;
    }
}

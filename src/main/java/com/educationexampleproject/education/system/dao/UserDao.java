package com.educationexampleproject.education.system.dao;

import com.educationexampleproject.education.system.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Select("select * from sys_user t where t.name = #{name}")
    List<User> queryUser(String name);

    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    @Select("select * from sys_user t where t.name = #{name} and password = #{password}")
    User login(@Param("name") String name, @Param("password") String password);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Insert("insert into sys_user(id,name,password,phone,head_img) values(#{id},#{name},#{password},#{phone},#{headImg})")
    int addUser(User user);
}

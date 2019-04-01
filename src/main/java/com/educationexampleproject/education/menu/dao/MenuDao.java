package com.educationexampleproject.education.menu.dao;

import com.educationexampleproject.education.menu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuDao {

    /**
     * 查询所有菜单信息
     *
     * @return
     */
    @Select("select * from menu")
    List<Menu> queryMenus();
}

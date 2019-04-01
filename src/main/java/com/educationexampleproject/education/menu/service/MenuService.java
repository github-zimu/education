package com.educationexampleproject.education.menu.service;

import com.educationexampleproject.education.menu.entity.Menu;

import java.util.List;

public interface MenuService {

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<Menu> queryMenus();
}

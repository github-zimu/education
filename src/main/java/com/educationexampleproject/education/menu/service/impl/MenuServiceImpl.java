package com.educationexampleproject.education.menu.service.impl;

import com.educationexampleproject.education.menu.dao.MenuDao;
import com.educationexampleproject.education.menu.entity.Menu;
import com.educationexampleproject.education.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> queryMenus() {
        return menuDao.queryMenus();
    }
}

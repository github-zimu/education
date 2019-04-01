package com.educationexampleproject.education.menu.controller;

import com.educationexampleproject.education.menu.service.MenuService;
import com.educationexampleproject.education.utils.JsonUtil;
import com.educationexampleproject.education.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * 查询所有菜单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryMenus.do", produces = "application/json;charset=utf-8")
    public String queryMenus() {
        return JsonUtil.toJSon(new ResponseData("200", "成功获取数据!", menuService.queryMenus()));
    }

}

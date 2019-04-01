package com.educationexampleproject.education.menu.entity;

/**
 * 菜单实体类
 */
public class Menu {
    // id
    private String id;
    // 菜单
    private String menus;
    // 菜单跳转路径
    private String menuUrl;

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuUrl() {

        return menuUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public String getId() {
        return id;
    }

    public String getMenus() {
        return menus;
    }
}

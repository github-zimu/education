package com.educationexampleproject.education.card.entity;

/**
 * 帖子实体类
 */
public class Card {
    // 编号
    private String id;
    // 菜单编号
    private String menuId;
    // 帖子标题
    private String title;
    // 帖子内容
    private String context;
    // 用户编号
    private String userId;
    // 上传时间
    private String upTime;
    // 单条帖子的评论数
    private String disNumber;
    // 图片地址
    private String imgUrl;
    // 简介
    private String synopsis;
    // 二级标题
    private String cardTwo;

    public void setCardTwo(String cardTwo) {
        this.cardTwo = cardTwo;
    }

    public String getCardTwo() {
        return cardTwo;

    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {

        return imgUrl;
    }

    public void setDisNumber(String disNumber) {
        this.disNumber = disNumber;
    }

    public String getDisNumber() {

        return disNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getId() {

        return id;
    }

    public String getMenuId() {
        return menuId;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public String getUserId() {
        return userId;
    }

    public String getUpTime() {
        return upTime;
    }
}

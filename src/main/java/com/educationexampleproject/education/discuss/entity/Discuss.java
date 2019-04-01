package com.educationexampleproject.education.discuss.entity;

/**
 * 评论实体类
 */
public class Discuss {
    // 编号
    private String id;
    // 用户编号
    private String userId;
    // 评论时间
    private String disTime;
    // 内容
    private String context;
    // 帖子编号
    private String cardId;

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDisTime(String disTime) {
        this.disTime = disTime;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getId() {

        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisTime() {
        return disTime;
    }

    public String getContext() {
        return context;
    }

    public String getCardId() {
        return cardId;
    }
}

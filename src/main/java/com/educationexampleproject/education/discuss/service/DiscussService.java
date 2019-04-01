package com.educationexampleproject.education.discuss.service;

import com.educationexampleproject.education.discuss.entity.Discuss;

import java.util.List;

public interface DiscussService {

    /**
     * 根据帖子ID查询相关评论
     *
     * @param cardId
     * @return
     */
    List<Discuss> queryDiscuss(String cardId);

    /**
     * 添加评论
     *
     * @param discuss
     * @return
     */
    int addDiscuss(Discuss discuss);
}

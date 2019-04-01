package com.educationexampleproject.education.card.service;

import com.educationexampleproject.education.card.entity.Card;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardService {

    /**
     * 根据菜单ID查询菜单下所有帖子
     *
     * @param menuId
     * @return
     */
    List<Card> queryCard(String menuId, String cardTwo);

    /**
     * 根据标题查询帖子详情
     *
     * @param title
     * @return
     */
    Card queryCardToTitle(@Param("title") String title);
}

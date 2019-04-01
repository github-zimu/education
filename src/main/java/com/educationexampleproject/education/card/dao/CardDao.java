package com.educationexampleproject.education.card.dao;

import com.educationexampleproject.education.card.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CardDao {

    /**
     * 查询菜单下的帖子
     *
     * @param menuId
     * @return
     */
    @Select("<script>" +
            "SELECT t.id,t.title,t.context,t.up_time,t.img_url,t.synopsis," +
            "(SELECT u.name FROM sys_user u WHERE u.id=t.user_id) AS userId," +
            "(SELECT m.menus FROM menu m WHERE m.id=t.menu_id) AS menuId," +
            "(SELECT COUNT(d.id) FROM discuss d WHERE d.card_id = t.id) AS disNumber FROM card t " +
            "WHERE 1=1" +
            "<if test = 'menuId != 0 '>" +
            "and t.menu_id = #{menuId}" +
            "</if>" +
            "<if test = 'cardTwo == 0 '>" +
            "AND TO_DAYS(t.up_time) = TO_DAYS(NOW())" +
            "</if>" +
            "<if test = 'cardTwo == 1 '>" +
            "AND DATEDIFF(t.up_time,NOW()) = -1" +
            "</if>" +
            "</script>")
    List<Card> queryCard(@Param("menuId") String menuId, @Param("cardTwo") String cardTwo);

    @Select("SELECT t.id,t.title,t.context,t.up_time,t.img_url,t.synopsis," +
            "(SELECT u.name FROM sys_user u WHERE u.id=t.user_id) AS userId," +
            "(SELECT m.menus FROM menu m WHERE m.id=t.menu_id) AS menuId," +
            "(SELECT COUNT(d.id) FROM discuss d WHERE d.card_id = t.id) AS disNumber FROM card t " +
            "WHERE 1=1 and t.title=#{title}" )
    Card queryCardToTitle(@Param("title") String title);
}

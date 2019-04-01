package com.educationexampleproject.education.discuss.dao;

import com.educationexampleproject.education.discuss.entity.Discuss;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiscussDao {

    /**
     * 通过帖子ID查询帖子下的所有评论
     *
     * @param cardId
     * @return
     */
    @Select("select t.card_id,t.context,t.dis_time,t.id,(SELECT u.name FROM sys_user u WHERE u.id=t.user_id) AS userId from discuss t where t.card_id = #{cardId} order by t.dis_time")
    List<Discuss> queryDiscuss(String cardId);

    /**
     * 添加评论
     *
     * @param discuss
     * @return
     */
    @Insert("insert into discuss(id,user_id,dis_time,context,card_id) values(#{id},#{userId},#{disTime},#{context},#{cardId})")
    int addDiscuss(Discuss discuss);
}

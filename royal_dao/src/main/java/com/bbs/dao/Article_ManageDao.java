package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Article_ManageDao {
    /**
     * 查找未屏蔽的帖子
     * @return
     */
    @Select("select * from bbs_article_table where isReport=0")
    @Results(id = "map",value = {
            @Result(id = true,column = "articleId",property = "articleId"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "sendTime",property = "sendTime"),
            @Result(column = "senderName",property = "senderName"),
            @Result(column = "isTop",property = "isTop"),
            @Result(column = "replyCount",property = "replyCount"),
            @Result(column = "upvoteCount",property = "upvoteCount"),
            @Result(column = "browseCount",property = "browseCount"),
            @Result(column = "isReport",property = "isReport"),
            @Result(column = "zoneId",property = "zone",javaType = Zone.class,
                    one = @One(select = "com.bbs.dao.Zone_ManageDao.findById")),
    })
    List<Article> findAll() throws Exception;

    /*条件查询*/
    @Select("select * from bbs_article_table where isReport=0 and title like concat('%',#{article.title},'%') and senderName like concat('%',#{article.senderName},'%') ")
    @ResultMap("map")
    List<Article> findBySearch(@Param("article") Article article) throws Exception;

    /**
     * 根据articleId查找帖子
     * @param id
     * @return
     */
    @Select("select * from bbs_article_table where articleId=#{id}")
    Article findById(int id) throws Exception;

    /**
     * 修改帖子的置顶状态
     * @param article
     */
    @Update("update bbs_article_table set isTop=#{article.isTop} where articleId=#{article.articleId}")
    void changeStatus(@Param("article") Article article) throws Exception;

    /**
     * 修改举报的状态
     * @param article
     */
    @Update("update bbs_article_table set isReport=#{article.isReport} where articleId=#{article.articleId}")
    void updateIsReport(@Param("article") Article article) throws Exception;


}

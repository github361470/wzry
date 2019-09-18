package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {
    @Select("select * from bbs_article_table")
    @Results(id = "map", value = {
            @Result(id = true, column = "articleId", property = "articleId"),
            @Result(column = "title", property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "sendTime", property = "sendTime"),
            @Result(column = "senderName", property = "senderName"),
            @Result(column = "isTop", property = "isTop"),
            @Result(column = "replyCount", property = "replyCount"),
            @Result(column = "upvoteCount", property = "upvoteCount"),
            @Result(column = "browseCount", property = "browseCount"),
            @Result(column = "isReport", property = "isReport"),
            @Result(column = "zoneId", property = "zone", javaType = Zone.class,
                    one = @One(select = "com.bbs.dao.ZoneDao.findById")),
    })
    List<Article> findAll();

    /*条件查询*/
    @Select("select * from bbs_article_table where  title like concat('%',#{title},'%') and senderName like concat('%',#{senderName},'%') ")
    @ResultMap("map")
    List<Article> findByCondition(Article article);
}

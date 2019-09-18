package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GetArticleDao {


    @Select("select * from bbs_article_table where senderName = #{senderName}")
    @Results({
            @Result(id = true, property = "articleId", column = "articleId"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "sendTime", column = "sendTime"),
            @Result(property = "senderName", column = "senderName"),
            @Result(property = "isTop", column = "isTop"),
            @Result(property = "replyCount", column = "replyCount"),
            @Result(property = "upvoteCount", column = "upvoteCount"),
            @Result(property = "browseCount", column = "browseCount"),
            @Result(property = "zoneId", column = "zoneId"),
            @Result(property = "isReport", column = "isReport"),
            @Result(property = "comments", column = "articleId", javaType = List.class, many = @Many(select = "com.bbs.dao.AllCommentsDao.findbyArticleId")),

    })
    List<Article> findDetailArticle(String senderName);


    @Select("select * from bbs_article_table where articleId = #{articleId}")
    @Results({
            @Result(id = true, property = "articleId", column = "articleId"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "sendTime", column = "sendTime"),
            @Result(property = "senderName", column = "senderName"),
            @Result(property = "isTop", column = "isTop"),
            @Result(property = "replyCount", column = "replyCount"),
            @Result(property = "upvoteCount", column = "upvoteCount"),
            @Result(property = "browseCount", column = "browseCount"),
            @Result(property = "zoneId", column = "zoneId"),
            @Result(property = "isReport", column = "isReport"),
            @Result(property = "comments", column = "articleId", javaType = List.class, many = @Many(select = "com.bbs.dao.AllCommentsDao.findbyArticleId")),
            @Result(property = "user", column = "senderName", javaType = User.class, one = @One(select = "com.bbs.dao.AllCommentsDao.findbySenderName")),
    })
    Article findDetailArticleById(String articleId);
}

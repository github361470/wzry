package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SaveSendArticleDao {


    @Insert("insert into bbs_article_table (title,content,sendTime,senderName,zoneId) values (#{title},#{content},#{sendTime},#{senderName},#{zoneId})")
    void sendArticle(Article article);



    @Select("select * from bbs_article_table where senderName = #{senderName}")
    List<Article> findDetailArticle(String senderName);
}

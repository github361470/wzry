package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SearchDao {
    @Select("select * from bbs_article_table where title like #{title} and zoneId = #{zoneId}")
    List<Article> searchArticle(@Param("title") String title, @Param("zoneId") String zoneId);


    @Select("select * from bbs_user_table where userName = #{userName}")
    String searchTalkStatus(String userName);
}

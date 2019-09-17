package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZoneDao {


    @Select("select * from bbs_article_table where zoneId = #{zoneId}")
    List<Article> findAllById(String zoneId);
}

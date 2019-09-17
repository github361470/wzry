package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VisitDao {


    @Select("select * from bbs_article_table")
    List<Article> todayVisit();
    @Select("select count(*) from bbs_article_table ")
    String totalVisit();
}

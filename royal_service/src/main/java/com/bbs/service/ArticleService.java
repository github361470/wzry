package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll(int page,int size);

    List<Article> findByCondition(Article article,int page,int size);
}

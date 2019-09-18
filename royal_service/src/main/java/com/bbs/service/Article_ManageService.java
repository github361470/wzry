package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface Article_ManageService {
    List<Article> findAll(int page,int size) throws Exception;
    void changeStatus(int articleId) throws Exception;
    void changeIsReport(int articleId) throws Exception;
    Article findById(int articleId) throws Exception;
    List<Article> findByCondition(int page,int size,Article article) throws  Exception;

}

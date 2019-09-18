package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> findAll(int page, int size) {
        PageHelper.startPage(page, size);
        return articleDao.findAll();
    }


    /*条件查询*/
    @Override
    public List<Article> findByCondition(Article article, int page, int size) {
        String senderName = article.getSenderName();
        String title = article.getTitle();
        article.setSenderName(senderName.trim());
        article.setTitle(title.trim());
        PageHelper.startPage(page, size);
        return articleDao.findByCondition(article);

    }
}

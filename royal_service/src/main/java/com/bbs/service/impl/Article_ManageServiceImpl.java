package com.bbs.service.impl;

import com.bbs.dao.Article_ManageDao;
import com.bbs.domain.Article;
import com.bbs.service.Article_ManageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 帖子service
 */
@Service
@Transactional
public class Article_ManageServiceImpl implements Article_ManageService {
    @Autowired
    private Article_ManageDao articleManageDao;

    /**
     * 查找非屏蔽帖子列表
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Article> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page, size);
        return articleManageDao.findAll();
    }

    /*条件查询*/
    @Override
    public List<Article> findByCondition(int page, int size, Article article) throws Exception{
        PageHelper.startPage(page, size);
        List<Article> articles = articleManageDao.findBySearch(article);
        return  articles;

    }

    /**
     * 修改置顶状态
     * @param articleId
     */
    @Override
    public void changeStatus(int articleId) throws Exception{
        Article article = articleManageDao.findById(articleId);
        Integer isTop = article.getIsTop();
        if (isTop==0){
            article.setIsTop(1);
        }else if (isTop==1){
            article.setIsTop(0);
        }
        articleManageDao.changeStatus(article);
    }

    /**
     * 修改是否被举报
     * @param articleId
     */
    @Override
    public void changeIsReport(int articleId) throws Exception{
        Article article = articleManageDao.findById(articleId);
        Integer isReport = article.getIsReport();
        if (isReport==0){
            article.setIsReport(1);
        }else if (isReport==1){
            article.setIsReport(0);
        }
        articleManageDao.updateIsReport(article);
    }

    /**
     * 根据Id查找帖子
     * @param articleId
     * @return
     */
    @Override
    public Article findById(int articleId) throws Exception {
        return articleManageDao.findById(articleId);
    }


}

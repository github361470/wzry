package com.bbs.service.impl;

import com.bbs.dao.UpvoteDao;
import com.bbs.service.UpvoteService;
import org.aspectj.lang.annotation.AdviceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UpvoteServiceImpl implements UpvoteService {


    @Autowired
    private UpvoteDao upvoteDao;

    @Override
    public void changeUpvote(String upvoteUserName, String articleId) {
        //点击收藏
        upvoteDao.changeUpvote(upvoteUserName, articleId);
        Integer upvoteCount = upvoteDao.getUpvoteCount(Integer.parseInt(articleId));
        Integer integer = upvoteDao.SetUpvoteCount(upvoteCount, articleId);



    }

    @Override
    public void deleteUpvote(String upvoteUserName, String articleId) {
        //点击删除
        upvoteDao.deleteUpvote(upvoteUserName, articleId);
        Integer upvoteCount = upvoteDao.getUpvoteCount(Integer.parseInt(articleId));
        Integer integer = upvoteDao.SetUpvoteCount(upvoteCount, articleId);
    }
}

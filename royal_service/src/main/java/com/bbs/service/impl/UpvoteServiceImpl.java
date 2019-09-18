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
    public void changeUpvote(String upvoteUserName, String articleId ) {
        upvoteDao.changeUpvote(upvoteUserName,articleId);

    }

    @Override
    public void deleteUpvote(String upvoteUserName, String articleId) {
        upvoteDao.deleteUpvote(upvoteUserName,articleId);
    }
}

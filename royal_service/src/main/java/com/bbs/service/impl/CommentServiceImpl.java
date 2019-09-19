package com.bbs.service.impl;

import com.bbs.dao.CommentDao;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Override
    public Integer queryCommentCountByUserName(String userName) {

        return commentDao.queryCommentCountByUserName(userName);
    }
}

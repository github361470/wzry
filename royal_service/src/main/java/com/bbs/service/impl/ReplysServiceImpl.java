package com.bbs.service.impl;

import com.bbs.dao.ReplysDao;
import com.bbs.domain.Reply;
import com.bbs.service.ReplysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReplysServiceImpl implements ReplysService {
    @Autowired
    private ReplysDao replysDao;
    @Override
    public void saveReply(String replyContent, String username, String commentId) {
        Reply reply = new Reply();
        reply.setReplyContent(replyContent);
        reply.setReplyUserName(username);
        reply.setReplyTime(new Date());
        reply.setCommentId(Integer.parseInt(commentId));
        replysDao.saveReply(reply);
    }
}

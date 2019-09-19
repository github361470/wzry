package com.bbs.service.impl;

import com.bbs.dao.CommentsDao;
import com.bbs.domain.Comment;
import com.bbs.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    @Override
    public Integer saveComment(String commentContent, String username, String articleId) {
        Comment comment = new Comment();
        comment.setCommentContent(commentContent);
        comment.setCommentTime(new Date());
        comment.setCommentUserName(username);
        comment.setArticleId(Integer.parseInt(articleId));
        commentsDao.saveComment(comment);

        /**
         * 保存完评论需要修改总评论数
         */
        Integer replyCount = commentsDao.selectAllCommentsByarticleId(articleId);

        commentsDao.changeReplyComment(replyCount,articleId);

        /**
         * List<Article> list = getArticleDao.findDetailArticle(senderName);
         *         int size = list.size();
         *         Article article = list.get(size - 1);
         */

        System.out.println("用户名：" + username);
        List<Comment> list = commentsDao.getCommentId(username);
        System.out.println(list);
        int size = list.size();
        Comment newComment = list.get(size - 1);
        Integer commentId = newComment.getCommentId();
        return commentId;
    }
}

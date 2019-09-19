package com.bbs.service.impl;

import com.bbs.dao.GetArticleDao;
import com.bbs.domain.Article;
import com.bbs.domain.Comment;
import com.bbs.domain.Reply;
import com.bbs.service.GetArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetArticleServiceImpl implements GetArticleService {

    @Autowired
    private GetArticleDao getArticleDao;

    @Override
    public Article findDetailArticle(String senderName) {
        /**
         * 根据用户名会查出所有帖子，获取最新的帖子，也就是发的帖子,通过最大的索引
         */
        List<Article> list = getArticleDao.findDetailArticle(senderName);
        int size = list.size();
        Article article = list.get(size - 1);


        String content = article.getContent();

        String title = article.getTitle();
        List<Comment> comments = article.getComments();
        for (Comment comment : comments) {

            String commentContent = comment.getCommentContent();
            List<Reply> replies = comment.getReplies();
            for (Reply reply : replies) {

                Integer commentId = reply.getCommentId();
            }

        }

        return article;
    }


    /**
     * 通过帖子id帖子
     *
     * @param articleId
     * @return
     */
    @Override
    public Article findDetailArticleById(String articleId) {
        Article article = getArticleDao.findDetailArticleById(articleId);

        return article;

    }
}

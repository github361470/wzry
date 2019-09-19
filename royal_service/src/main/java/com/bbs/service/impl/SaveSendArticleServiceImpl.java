package com.bbs.service.impl;

import com.bbs.dao.SaveSendArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.SaveSendArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class SaveSendArticleServiceImpl implements SaveSendArticleService {

    @Autowired
    private SaveSendArticleDao saveSendArticleDao;


    @Override
    public void sendArticle(String title, String content, String zoneId, String senderName,String picUrl) {
        /*private Integer articleId;//帖子编号
        private String title;
        private String content;//内容
        private Date sendTime;//发送时间
        private String sendTimeStr;//发送时间字符串格式
        private String senderName;//发送人编号
        private Integer isTop;//是否置顶 如果是0，代表不置顶；如果是1，代表置顶；
        private Integer replyCount;//评论数
        private Integer upvoteCount;//点赞数
        private Integer browseCount;//浏览数
        private Integer zoneId;//所在交流区
        private Integer isReport;//举报状态*/
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setSendTime(new Date());
        article.setSenderName(senderName);
        article.setZoneId(Integer.parseInt(zoneId));


        saveSendArticleDao.sendArticle(article);
    }

}

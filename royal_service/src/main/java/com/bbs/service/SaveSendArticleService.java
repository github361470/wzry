package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface SaveSendArticleService {
    void sendArticle(String title, String content, String zoneId, String senderName);


}

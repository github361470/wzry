package com.bbs.service;

import com.bbs.domain.Article;

public interface GetArticleService {
    Article findDetailArticle(String senderName);

    Article findDetailArticleById(String articleId);
}

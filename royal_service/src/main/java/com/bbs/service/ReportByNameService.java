package com.bbs.service;

import com.bbs.domain.Article;

public interface ReportByNameService {
    void reportByName(String replyContent, String username, String articleId);
}

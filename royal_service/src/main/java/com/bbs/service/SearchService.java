package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface SearchService {
    List<Article> searchArticle(String title,String zoneId);

    String searchTalkStatus(String userName);
}

package com.bbs.service.impl;

import com.bbs.dao.SearchDao;
import com.bbs.domain.Article;
import com.bbs.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchDao searchDao;

    @Override
    public List<Article> searchArticle(String title,String zoneId) {
        return searchDao.searchArticle(title,zoneId);
    }
}

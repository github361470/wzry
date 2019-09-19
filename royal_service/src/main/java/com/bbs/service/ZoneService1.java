package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ZoneService1 {

    List<Article> findAllById(String zoneId);
}

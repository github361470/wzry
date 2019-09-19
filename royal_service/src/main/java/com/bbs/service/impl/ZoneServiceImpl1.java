package com.bbs.service.impl;

import com.bbs.dao.ZoneDao1;
import com.bbs.domain.Article;
import com.bbs.service.ZoneService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl1 implements ZoneService1 {


    @Autowired
    private ZoneDao1 zoneDao;
    @Override
    public List<Article> findAllById(String zoneId) {
        return zoneDao.findAllById(zoneId);
    }
}

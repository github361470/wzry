package com.bbs.service.impl;

import com.bbs.dao.VisitDao;
import com.bbs.domain.Article;
import com.bbs.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDao visitDao;

    @Override
    public String todayVisit() {
        Integer todayVisitNumber = 0;
        List<Article> list = visitDao.todayVisit();
        for (Article article : list) {
            Date sendTime = article.getSendTime();
            int year = sendTime.getYear();
            int nowYear = new Date().getYear();
            if (year == nowYear) {
                int month = sendTime.getMonth();
                int nowMonth = new Date().getMonth();
                if (month == nowMonth) {
                    int date = sendTime.getDate();
                    int nowDate = new Date().getDate();
                    if (date == nowDate) {
                        todayVisitNumber++;
                    }
                }
            }
        }
        return todayVisitNumber + "";
    }

    @Override
    public String totalVisit() {
        String totalVisiNumber = visitDao.totalVisit();
        return totalVisiNumber;
    }
}

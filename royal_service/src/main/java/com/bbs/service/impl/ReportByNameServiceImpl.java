package com.bbs.service.impl;


import com.bbs.dao.ReportByNameDao;
import com.bbs.domain.Article;
import com.bbs.domain.Report;
import com.bbs.service.ReportByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReportByNameServiceImpl implements ReportByNameService {

    @Autowired
    private ReportByNameDao reportByNameDao;
    @Override
    public void reportByName(String replyContent, String username,String articleId) {
        Report report = new Report();
        report.setReportContent(replyContent);
        report.setReportTime(new Date());
        report.setReportUserName(username);
        report.setReportStatus(1);
        report.setArticleId(Integer.parseInt(articleId));


        reportByNameDao.saveReport(report);


    }
}

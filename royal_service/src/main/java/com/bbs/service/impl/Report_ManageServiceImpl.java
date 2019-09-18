package com.bbs.service.impl;

import com.bbs.dao.Article_ManageDao;
import com.bbs.dao.Report_ManageDao;
import com.bbs.domain.Article;
import com.bbs.domain.Report;
import com.bbs.service.Report_ManageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 举报Service
 */
@Service
@Transactional
public class Report_ManageServiceImpl implements Report_ManageService {
    @Autowired
    private Report_ManageDao reportManageDao;
    @Autowired
    private Article_ManageDao articleManageDao;

    /**
     * 查找未处理举报的列表
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Report> findAll(int page,int size) throws Exception{
        PageHelper.startPage(page, size);
        return reportManageDao.findAll();
    }

    /**
     * 屏蔽举报贴
     * @param reportId
     * @param articleId
     */
    @Override
    public void verb(int reportId, int articleId) throws Exception{//屏蔽
        Report report = reportManageDao.findById(reportId);
        report.setReportStatus(0);//0已处理举报
        Article article = articleManageDao.findById(articleId);
        article.setIsReport(1);
        articleManageDao.updateIsReport(article);
        reportManageDao.verb(report);
    }

    /**
     * 驳回举报帖
     * @param reportId
     */
    @Override
    public void returnDo(int reportId) throws Exception{
        Report report = reportManageDao.findById(reportId);
        report.setReportStatus(0);//0已处理举报
        reportManageDao.verb(report);
    }

}

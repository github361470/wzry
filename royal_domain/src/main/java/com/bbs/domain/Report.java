package com.bbs.domain;

import com.bbs.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * bbs_report_table
 * @author 
 */
public class Report implements Serializable {
    private Integer reportId;
    /**
     * 举报内容
     */
    private String reportContent;
    /**
     * 举报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date reportTime;
    private String reportTimeStr;
    /**
     * 举报人
     */
    private String reportUserName;
    /**
     * 处理状态,0屏蔽，1显示
     */
    private Integer reportStatus;
    private String reportStatusStr;
    /**
     * 文章ID
     */
    private Article article;

    private static final long serialVersionUID = 1L;

    public String getReportTimeStr() {
        return  DateUtils.date2String(reportTime, "yyyy-MM-dd HH-mm-ss");

    }

    public void setReportTimeStr(String reportTimeStr) {
        this.reportTimeStr = reportTimeStr;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getReportStatusStr() {
        return reportStatusStr;
    }

    public void setReportStatusStr(String reportStatusStr) {
        this.reportStatusStr = reportStatusStr;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
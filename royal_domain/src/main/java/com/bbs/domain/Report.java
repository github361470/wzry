package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * bbs_report_table
 * @author 
 */
public class Report implements Serializable {
    private Integer reportid;

    /**
     * 举报内容
     */
    private String reportcontent;

    /**
     * 举报时间
     */
    private Date reporttime;

    /**
     * 举报人
     */
    private String reportusername;

    /**
     * 处理状态
     */
    private Integer reportstatus;

    /**
     * 文章ID
     */
    private Integer articleid;

    private static final long serialVersionUID = 1L;

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public String getReportcontent() {
        return reportcontent;
    }

    public void setReportcontent(String reportcontent) {
        this.reportcontent = reportcontent;
    }

    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public String getReportusername() {
        return reportusername;
    }

    public void setReportusername(String reportusername) {
        this.reportusername = reportusername;
    }

    public Integer getReportstatus() {
        return reportstatus;
    }

    public void setReportstatus(Integer reportstatus) {
        this.reportstatus = reportstatus;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Report other = (Report) that;
        return (this.getReportid() == null ? other.getReportid() == null : this.getReportid().equals(other.getReportid()))
            && (this.getReportcontent() == null ? other.getReportcontent() == null : this.getReportcontent().equals(other.getReportcontent()))
            && (this.getReporttime() == null ? other.getReporttime() == null : this.getReporttime().equals(other.getReporttime()))
            && (this.getReportusername() == null ? other.getReportusername() == null : this.getReportusername().equals(other.getReportusername()))
            && (this.getReportstatus() == null ? other.getReportstatus() == null : this.getReportstatus().equals(other.getReportstatus()))
            && (this.getArticleid() == null ? other.getArticleid() == null : this.getArticleid().equals(other.getArticleid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReportid() == null) ? 0 : getReportid().hashCode());
        result = prime * result + ((getReportcontent() == null) ? 0 : getReportcontent().hashCode());
        result = prime * result + ((getReporttime() == null) ? 0 : getReporttime().hashCode());
        result = prime * result + ((getReportusername() == null) ? 0 : getReportusername().hashCode());
        result = prime * result + ((getReportstatus() == null) ? 0 : getReportstatus().hashCode());
        result = prime * result + ((getArticleid() == null) ? 0 : getArticleid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reportid=").append(reportid);
        sb.append(", reportcontent=").append(reportcontent);
        sb.append(", reporttime=").append(reporttime);
        sb.append(", reportusername=").append(reportusername);
        sb.append(", reportstatus=").append(reportstatus);
        sb.append(", articleid=").append(articleid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
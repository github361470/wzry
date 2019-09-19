package com.bbs.dao;

import com.bbs.domain.Report;
import org.apache.ibatis.annotations.Insert;

public interface ReportByNameDao {


    @Insert("insert into bbs_report_table (reportContent,reportTime,reportUserName,reportStatus,articleId) values (#{reportContent},#{reportTime},#{reportUserName},#{reportStatus},#{articleId})")
    void saveReport(Report report);
}

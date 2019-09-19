package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.Report;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Report_ManageDao {
    /**
     * 查找未处理的举报列表
     * @return
     */
   // @Select("select * from bbs_report_table where reportStatus=1 and articleId not in (select articleId from bbs_article_table where isReport=1)")
    @Select("select * from bbs_report_table where reportStatus=1")
    @Results({
            @Result(id = true,column = "reportId",property = "reportId"),
            @Result(column = "reportContent",property = "reportContent"),
            @Result(column = "reportTime",property = "reportTime"),
            @Result(column = "reportUserName",property = "reportUserName"),
            @Result(column = "reportStatus",property = "reportStatus"),
            @Result(column = "articleId",property = "article",javaType = Article.class,
            one = @One(select = "com.bbs.dao.Article_ManageDao.findById")),
    })
    List<Report> findAll() throws Exception;

    /**
     * 根据reportId查找举报信息
     * @param id
     * @return
     */
    @Select("select * from bbs_report_table where reportId=#{id}")
    Report findById(int id) throws Exception;

    /**
     * 修该举报的处理状态
     * @param report
     */
    @Update("update bbs_report_table set reportStatus=#{report.reportStatus} where reportId=#{report.reportId}")
    void verb(@Param("report") Report report) throws Exception;
}

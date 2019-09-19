package com.bbs.service;

import com.bbs.domain.Report;

import java.util.List;

public interface Report_ManageService {

    List<Report> findAll(int page, int size) throws Exception;

    void verb(int reportId, int articleId) throws Exception;
    void returnDo(int reportId) throws Exception;
}

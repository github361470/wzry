package com.bbs.service;

import com.bbs.domain.User;

import java.util.List;


public interface User_ManageService {

    List<User> findAll(int page, int size, User user) throws Exception;

    void changeTalkStatus(int userId) throws Exception;

    void upGrade(int userId) throws Exception;
}

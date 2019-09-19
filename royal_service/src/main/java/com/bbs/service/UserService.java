package com.bbs.service;

import com.bbs.common.ResponseResult;
import com.bbs.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findByUserName(String username);

    ResponseResult userRegister(User user);

    User login(String userName, String userPass);

    void update(User user);

}

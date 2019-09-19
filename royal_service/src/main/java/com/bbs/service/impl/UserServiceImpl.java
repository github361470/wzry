package com.bbs.service.impl;

import com.bbs.common.CommonCode;

import com.bbs.common.ResponseResult;
import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUserName(String username) {
        User user=userDao.findByUserName(username);
        return user;
    }

    @Override
    public ResponseResult userRegister(User user) {
        try {
            userDao.userRegister(user);
            return new ResponseResult(CommonCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseResult(CommonCode.FAIL);
        }
    }

    @Override
    public User login(String userName, String userPass) {
        return userDao.login(userName,userPass);
    }

    @Override
    public void update(User user) {
        System.out.println(user);
        userDao.update(user);
    }
}

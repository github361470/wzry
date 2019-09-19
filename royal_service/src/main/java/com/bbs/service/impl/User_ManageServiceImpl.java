package com.bbs.service.impl;

import com.bbs.dao.User_ManageDao;
import com.bbs.domain.User;
import com.bbs.service.User_ManageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service
 */
@Service
@Transactional
public class User_ManageServiceImpl implements User_ManageService {


    @Autowired
    private User_ManageDao userManageDao;

    /**
     * 查找所有用户列表
     * @param page
     * @param size
     * @param user
     * @return
     */
    @Override
    public List<User> findAll(int page, int size, User user) throws Exception{
        PageHelper.startPage(page, size);
        return userManageDao.findAll(user);
    }

    /**
     * 修改用户的发言状态
     * @param userId
     */
    @Override
    public void changeTalkStatus(int userId) throws Exception{
        User user = userManageDao.findById(userId);
        if (user.getTalkStatus()==0){
            user.setTalkStatus(1);
        }else if (user.getTalkStatus()==1){
            user.setTalkStatus(0);
        }
        userManageDao.changeTalkStatus(user);
    }
    /**
     * 处理升级申请
     * @param userId
     * @throws Exception
     */
    @Override
    public void upGrade(int userId) throws Exception {
        userManageDao.changeGrade(userId);
    }



}

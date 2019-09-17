package com.bbs.service.impl;

import com.bbs.dao.OnlineNumberDao;
import com.bbs.domain.User;
import com.bbs.service.OnlineNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineNumberServiceImpl implements OnlineNumberService {
    @Autowired
    private OnlineNumberDao onlineNumberDao;

    @Override
    public List<User> findOnlineUser() {
        return onlineNumberDao.findOnlineUser();
    }
}

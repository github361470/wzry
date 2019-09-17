package com.bbs.service;

import com.bbs.domain.User;

import java.util.List;

public interface OnlineNumberService {
    List<User> findOnlineUser();
}

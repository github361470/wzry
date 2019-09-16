package com.bbs.service;

import com.bbs.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> findAll();
}

package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.OnlineNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/online")
public class OnlineNumberController {


    @Autowired
    private OnlineNumberService onlineNumberService;

    /**
     * 显示在线用户
     * @return
     */
    @RequestMapping("/findOnlineUser.do")
    public @ResponseBody List<User> findOnlineUser(){
       List<User> list = onlineNumberService.findOnlineUser();
       return  list;
    }
}

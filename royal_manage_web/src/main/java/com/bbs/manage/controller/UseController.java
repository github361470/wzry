package com.bbs.manage.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public String  findAll(){
      List<User> list =  userService.findAll();
        System.out.println(list);
        return "main";
    }
}

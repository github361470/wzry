package com.bbs.manage.controller;

import com.bbs.domain.User;
import com.bbs.service.User_ManageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user_manage")
public class UseController {

    @Autowired
    private User_ManageService userManageService;

    /**
     * 根据查询的信息查找用户列表
     * @param page
     * @param size
     * @param user
     * @return
     */
    @RequestMapping("/findByPage.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")int size,
                                User user) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<User> users = userManageService.findAll(page,size,user);

        PageInfo pageInfo=new PageInfo(users);
        mv.setViewName("UserPages");
        mv.addObject("usersMsgs", pageInfo);
        mv.addObject("searchUser", user);
        return mv;
    }

    /**
     * 改变用户的发言状态
     * @param userId
     * @param page
     * @return
     */
    @RequestMapping("/changeTalkStatus.do")
    public String changeTalkStatus(@RequestParam(name = "id",required = true)int userId,
                                   @RequestParam(name = "page",required = true,defaultValue = "1")int page) throws Exception{
        userManageService.changeTalkStatus(userId);
        return "redirect:findByPage.do?userName=&role=0&size=5&page="+page;

    @RequestMapping("/findAll.do")
    public String  findAll(){
      List<User> list =  userService.findAll();
        System.out.println(list);
        return "main";
    }
    @RequestMapping("/grade.do")
    public String changeGrade(@RequestParam(name = "id",required = true)int userId,
                                   @RequestParam(name = "page",required = true,defaultValue = "1")int page) throws Exception{
        userManageService.upGrade(userId);
        return "redirect:findByPage.do?userName=&role=0&size=5&page="+page;

    }

}

package com.bbs.controller;


import com.bbs.domain.Article;
import com.bbs.domain.User;
import com.bbs.service.SaveSendArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/send")
public class SaveSendArticleController {


    @Autowired
    private SaveSendArticleService sendArticleService;


    /**
     * 发送帖子，保存到数据库
     *
     * @param title
     * @param content
     * @param zoneId
     * @param senderName
     * @return
     */
    @RequestMapping("/sendArticle.do")
    public String sendArticle(@RequestParam(name = "title") String title,
                              @RequestParam(name = "content") String content,
                              @RequestParam(name = "zoneId") String zoneId,
                              @RequestParam(name = "username") String senderName) {
        sendArticleService.sendArticle(title, content, zoneId, senderName);
        //return "redirect:/zone/findAllById.do?zoneId="+ zoneId;


        return "redirect:/send/findDetailArticle.do?senderName=" + senderName;
    }


    /**
     * 携带article信息跳转到帖子页面
     *
     * @param senderName
     * @return
     */
    @RequestMapping("/findDetailArticle.do")
    public ModelAndView findDetailArticle(String senderName) {
        ModelAndView mv = new ModelAndView();
        Article article = sendArticleService.findDetailArticle(senderName);
        mv.addObject("article", article);
        mv.setViewName("getArticle");
        return mv;
    }
}

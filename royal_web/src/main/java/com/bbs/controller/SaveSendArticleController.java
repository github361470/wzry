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


        return "redirect:/getArticle/findDetailArticleBySenderName.do?senderName=" + senderName;
    }


}

package com.bbs.controller;


import com.bbs.service.ReplysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/replys")
public class ReplysController {

    @Autowired
    private ReplysService replysService;

    @RequestMapping("/saveReply.do")
    public String saveReply(
            @RequestParam(name = "replyContent") String replyContent,
            @RequestParam(name = "username") String username,
            @RequestParam(name = "commentId") String commentId,
            @RequestParam(name = "articleId") String articleId
            ) {
        replysService.saveReply(replyContent,username,commentId);
        return "redirect:/getArticle/findDetailArticleById.do?articleId=" + articleId;
    }


}

package com.bbs.controller;

import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/upvote")
public class UpvoteController {

    @Autowired
    private UpvoteService upvoteService;

    @RequestMapping("/saveUpvote.do")
    public String changeUpvote(@RequestParam(name = "upvoteUserName") String upvoteUserName,
                               @RequestParam(name = "articleId") String articleId) {
        upvoteService.changeUpvote(upvoteUserName, articleId);

        return null;
    }

    @RequestMapping("/deleteUpvote.do")
    public String deleteUpvote(@RequestParam(name = "upvoteUserName") String upvoteUserName,
                               @RequestParam(name = "articleId") String articleId) {
        upvoteService.deleteUpvote(upvoteUserName, articleId);

        return null;
    }

}

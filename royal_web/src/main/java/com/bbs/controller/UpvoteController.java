package com.bbs.controller;

import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/upvote")
public class UpvoteController {

    @Autowired
    private UpvoteService upvoteService;


    /**
     * 点击收藏
     * @param upvoteUserName
     * @param articleId
     * @return
     */
    @RequestMapping("/saveUpvote.do")
    public @ResponseBody String changeUpvote(@RequestParam(name = "upvoteUserName") String upvoteUserName,
                        @RequestParam(name = "articleId") String articleId) {
        upvoteService.changeUpvote(upvoteUserName, articleId);
        System.out.println(111);
        return null;
    }


    /**
     * 点击取消收藏
     * @param upvoteUserName
     * @param articleId
     * @return
     */
    @RequestMapping("/deleteUpvote.do")
    public @ResponseBody String deleteUpvote(@RequestParam(name = "upvoteUserName") String upvoteUserName,
                               @RequestParam(name = "articleId") String articleId) {
        upvoteService.deleteUpvote(upvoteUserName, articleId);
//        return "redirect:getArticle/findDetailArticleById.do?articleId="+ articleId;
        return null;
    }

}

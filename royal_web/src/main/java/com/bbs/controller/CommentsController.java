package com.bbs.controller;

import com.bbs.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/saveComment.do")
    public String saveComment(@RequestParam(name = "commentContent") String commentContent,
                              @RequestParam(name = "username") String username,
                              @RequestParam(name = "articleId") String articleId, HttpServletRequest request) {
        Integer commentId = commentsService.saveComment(commentContent, username, articleId);
        request.getSession().setAttribute("commentId",commentId);
        return "redirect:/getArticle/findDetailArticleById.do?articleId=" + articleId;

    }
}

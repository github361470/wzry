package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.GetArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("getArticle")
@SessionAttributes("article")
public class GetArticleController {

    @Autowired
    private GetArticleService getArticleService;


    /**
     * 携带article信息跳转到帖子页面(通过发帖人姓名)
     *
     * @param senderName
     * @return
     */
    @RequestMapping("/findDetailArticleBySenderName.do")
    public ModelAndView findDetailArticle(String senderName) {
        ModelAndView mv = new ModelAndView();
        Article article = getArticleService.findDetailArticle(senderName);
        mv.addObject("article", article);
        mv.setViewName("getArticle");
        return mv;
    }

    /**
     * 携带article信息跳转到帖子页面(通过发帖Id)
     *
     * @param articleId
     * @return
     */
    @RequestMapping("/findDetailArticleById.do")
    public ModelAndView findDetailArticleById(String articleId) {
        ModelAndView mv = new ModelAndView();
        Article article = getArticleService.findDetailArticleById(articleId);
        mv.addObject("article", article);
        mv.setViewName("getArticle");
        return mv;
    }




}

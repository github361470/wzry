package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findByPage.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")int size){
        ModelAndView mv=new ModelAndView();
        List<Article> articles = articleService.findAll(page,size);
        PageInfo<Article> pageInfo=new PageInfo(articles);
        mv.setViewName("ArticlePage");
        mv.addObject("articles", articles);
        mv.addObject("articleMsgs", pageInfo);

        return mv;
    }
}

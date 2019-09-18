package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleManageService;

    /**
     * 未屏蔽帖子列表
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findByPage.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")int size) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Article> articles = articleManageService.findAll(page,size);
        PageInfo<Article> pageInfo=new PageInfo(articles);
        mv.setViewName("ArticlePage");
        mv.addObject("articleMsgs", pageInfo);
        return mv;
    }

    /*条件查询*/
    @RequestMapping("/findByCondition.do")
    public String findByCondition( Article article, Model model,
                                  @RequestParam(name = "page",defaultValue = "1")int page,
                                  @RequestParam(name = "size",defaultValue = "5")int size){
        List<Article> list=articleManageService.findByCondition(article,page, size);
        PageInfo<Article> pageInfo=new PageInfo(list);
        model.addAttribute("articleMsgs",pageInfo);
        model.addAttribute("condition",article);
        return "ArticlePage";
    }

    /**
     * 屏蔽帖子
     * @param articleId
     * @param page
     * @return
     */
    @RequestMapping("/deleteArticle.do")
    public String deleteArticle(@RequestParam(name = "id")int articleId,
                                @RequestParam(name = "page")int page) throws Exception{
        articleManageService.changeIsReport(articleId);
        return "redirect:findByPage.do?size=5&page="+page;
    }

    /**
     * 改变帖子是否置顶的状态
     * @param articleId
     * @param page
     * @return
     */
    @RequestMapping("/changeStatus.do")
    public String changeStatus(@RequestParam(name = "id")int articleId,
                               @RequestParam(name = "page")int page) throws Exception{
        articleManageService.changeStatus(articleId);
        return "redirect:findByPage.do?size=5&page="+page;
    }

    /**
     * 根据帖子Id查看相关帖子
     * @param articleId
     * @return
     */
    @RequestMapping("/findById.do")
    @ResponseBody
    public Article findById(@RequestParam(name = "articleId",required = true)int articleId) throws Exception{
        Article article = articleManageService.findById(articleId);
        return article;
    }
}

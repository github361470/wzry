package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    SearchService searchService;


    /**
     * 关键词搜索帖子
     *
     * @param keywords
     * @param zoneId
     * @return
     */
    @RequestMapping("/searchArticle.do")
    public ModelAndView searchArticle(@RequestParam(name = "keywords") String keywords, @RequestParam(name = "zoneId") String zoneId) {
        ModelAndView mv = new ModelAndView();
        //关键词回显
        mv.addObject("keywords", keywords);
        keywords = "%" + keywords + "%";
        List<Article> list = searchService.searchArticle(keywords, zoneId);

        mv.addObject("list", list);

        //页面上还需要zoneId这个数据，确定所在区域
        mv.addObject("zoneId", zoneId);
        mv.setViewName("index");
        return mv;
    }
}

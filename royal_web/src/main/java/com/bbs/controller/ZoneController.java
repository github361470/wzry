package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.ZoneService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    /**
     * 单击区域：切换访问区域
     *
     * @param zoneId
     * @return
     */
    @RequestMapping("/findAllById.do")
    public ModelAndView findAllById(@RequestParam(name = "zoneId") String zoneId) {
        ModelAndView mv = new ModelAndView();
        List<Article> list = zoneService.findAllById(zoneId);
        mv.addObject("list", list);
        mv.addObject("zoneId",zoneId);
        mv.setViewName("index");
        return  mv;
    }
}

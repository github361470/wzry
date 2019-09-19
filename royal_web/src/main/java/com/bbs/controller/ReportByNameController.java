package com.bbs.controller;


import com.bbs.domain.Article;
import com.bbs.service.ReportByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report")
public class ReportByNameController {


    @Autowired
    private  ReportByNameService reportByNameService;

    @RequestMapping("/reportByName.do")
    public String reportByName(@RequestParam(name = "replyContent") String replyContent,
                               @RequestParam(name = "username") String username,
                               @RequestParam(name = "articleId") String articleId
                            ) {

        reportByNameService.reportByName(replyContent,username,articleId);

        return "redirect:/zone/findAllById.do?zoneId=1";
    }
}

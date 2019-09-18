package com.bbs.manage.controller;

import com.bbs.domain.Report;
import com.bbs.service.Report_ManageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * 处理举报Controller
 */
@Controller
@RequestMapping("/report_manage")
public class ReportController {
    @Autowired
    private Report_ManageService reportManageService;

    /**
     * 查看未处理的举报列表
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                                   @RequestParam(name = "size",defaultValue = "5",required = true)int size) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Report> reports= reportManageService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(reports);
        mv.addObject("reportMsgs", pageInfo);
        mv.setViewName("ReportPage");
        return mv;
    }
    //屏蔽帖子

    /**
     * 屏蔽举报贴
     * @param reportId
     * @param articleId
     * @param page
     * @return
     */
    @RequestMapping("/verb.do")
    public String noun(@RequestParam(name = "reportId",defaultValue = "1",required = true)int reportId,
                       @RequestParam(name = "articleId",defaultValue = "5",required = true)int articleId,
                       @RequestParam(name = "page",defaultValue = "1",required = true)int page) throws Exception{

        reportManageService.verb(reportId,articleId);
        return "redirect:findByPage.do?size=5&page="+page;
    }

    /**
     * 驳回举报贴
     * @param reportId
     * @param page
     * @return
     */
    @RequestMapping("/return.do")
    public String returnDo(@RequestParam(name = "reportId",defaultValue = "1",required = true)int reportId,
                           @RequestParam(name = "page",defaultValue = "1",required = true)int page) throws Exception{
        reportManageService.returnDo(reportId);
        return "redirect:findByPage.do?size=5&page="+page;
    }
}

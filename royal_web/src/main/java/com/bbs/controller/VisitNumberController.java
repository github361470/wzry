package com.bbs.controller;


import com.bbs.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/visit")
public class VisitNumberController {


    @Autowired
    private VisitService visitService;

    /**
     * 接收前端页面使用ajax发送的请求 查看今天帖子数
     * @return
     */
    @RequestMapping("/todayVisit.do")
    public @ResponseBody String todayVisit() {
        String todayVisitNumber = visitService.todayVisit();
        return todayVisitNumber;
    }

    /**
     * 接收前端页面使用ajax发送的请求查看总贴
     * @return
     */
    @RequestMapping("/totalVisit.do")
    public @ResponseBody String totalVisit(){
        String  totalVisiNumber = visitService.totalVisit();
        return totalVisiNumber;
    }
}

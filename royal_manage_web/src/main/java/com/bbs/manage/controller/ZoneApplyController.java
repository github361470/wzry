package com.bbs.manage.controller;

import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneApply_ManageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/zoneApply_manage")
public class ZoneApplyController {
    @Autowired
    private ZoneApply_ManageService z_mService;
    /**
     * 查看版块申请列表
     * @return
     */
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                                   @RequestParam(name = "size",required = true,defaultValue = "5")int size) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Zoneapply> zoneapplies = z_mService.findByPage(page, size);
        PageInfo<Zoneapply> pageInfo=new PageInfo(zoneapplies);
        mv.addObject("zoneApplyMsgs",pageInfo);
        mv.setViewName("ZoneApplyPage");
        return mv;
    }
    /**
     * 通过申请版块
     * @return
     */
    @RequestMapping("/pass.do")
    public String pass(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                       @RequestParam(name = "id",required = true)int id) throws Exception{
        z_mService.passZone(id);
        return "redirect:findByPage.do?size=5&page="+page;
    }

    /**
     * 驳回申请版块
     * @return
     */
    @RequestMapping("/reject.do")
    public String reject(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                         @RequestParam(name = "id",required = true)int id) throws Exception{
        z_mService.changeStatus(id);
        return "redirect:findByPage.do?size=5&page="+page;
    }

    @RequestMapping("/findAllZone.do")
    @ResponseBody
    public List<Zone> findAllZone() throws Exception{
        List<Zone> zones=z_mService.findAllZone();
        return zones;
    }

}

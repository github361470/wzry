package com.bbs.controller;

import com.bbs.common.CommonCode;
import com.bbs.common.ResponseResult;

import com.bbs.domain.User;
import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.CommentService;
import com.bbs.service.UserService;
import com.bbs.service.ZoneApplyService;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin2.main.client.MozillaServiceDelegate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ZoneApplyService zoneApplyService;

    @Autowired
    private ZoneService zoneService;


    //进入板块申请信息页面
    @RequestMapping("/applyInfo")
    public String applyInfo(HttpServletRequest res,Model model){
        User user = (User)res.getSession().getAttribute("user");
        List<Zoneapply> zoneapplys = zoneApplyService.findAllZoneapplyByUserName(user.getUserName());
        model.addAttribute("zoneapplys",zoneapplys);
        return "applyInfo";
    }
    //进入开辟新板块页面
    @RequestMapping("/newSection")
    public String newSection(Model model){
        Zoneapply zoneapply = new Zoneapply();
        zoneapply.setStatus(-1);
        model.addAttribute("zoneapply",zoneapply);
        return "newSection";
    }
    //发送开辟新板块的请求
    @RequestMapping("/requestNewSection")
    public String requestNewSection(Zoneapply zoneapply,Model model){
        ResponseResult responseResult=zoneApplyService.requestNewSection(zoneapply);
        model.addAttribute("result",responseResult);
         /*  zoneapply.setStatus(0);
        model.addAttribute("zoneapply",zoneapply);
        System.out.println(zoneapply);*/
        return "newSection";
    }



    //进入用户权限申请页面
    @RequestMapping("/accessControl.do")
    public String accessControl(HttpServletRequest request,Model model){
        User user = (User)request.getSession().getAttribute("user");
        Integer count=commentService.queryCommentCountByUserName(user.getUserName());
        request.getSession().setAttribute("commentCount",count);
        model.addAttribute("result" ,new ResponseResult(CommonCode.FAIL));
        return "accessControl";
    }
    //进行用户的权限申请
    @RequestMapping("/requestControl.do")
    public String requestControl(HttpServletRequest request,Model model){
        User user = (User)request.getSession().getAttribute("user");
        user.setIsupdating(1);
        userService.update(user);
        model.addAttribute("result" ,new ResponseResult(CommonCode.SUCCESS));
        return "accessControl";
    }

    //进入用户注册页面
    @RequestMapping("/register.do")
    public String register(){
//       model.addAttribute("result" ,new ResponseResult(CommonCode.FAIL));
        return "register";
    }
    //进行用户注册
    @RequestMapping("/registerValidate1.do")
    public String registerValidate1(User user, HttpServletRequest res,Model model){
        System.out.println("用户名"+user.getUserName().matches("^\\w+$"));
        System.out.println("密码"+ user.getUserPass().matches("^\\w{6,10}$"));
        if (!user.getUserName().matches("^\\w+$")||
            !user.getUserPass().matches("^\\w{6,10}$")||
            !user.getEmail().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
        ){
            System.out.println("错误");
            model.addAttribute("result",new ResponseResult(CommonCode.FAIL));
            return "register";
        }


        User _user=userService.findByUserName(user.getUserName());
        if(_user!=null){
            return "register";
        }else {
            user.setLoginStatus(1);
            user.setPicUrl("\\images\\default.png");
            user.setRole(1);
            ResponseResult result=userService.userRegister(user);
            if (result.isSuccess()){
                res.getSession().setAttribute("user",user);
                return "success";
            }else{
            //若注册失败则
            return "fail";
            }
        }
    }
    //发送ajax验证用户名是否已被占用
    @RequestMapping(value = "registerValidate.do",produces="text/html;charset=utf-8")
    public @ResponseBody String registerValidate(@RequestParam String userName){
        User _user=userService.findByUserName(userName);
        if(_user!=null){
            return "该用户名已被注册";
        }else {
            return "success";
        }
    }

    //进入用户信息页面
    @RequestMapping("userInfo.do")
    public String userInfo(){
        return "userInfo";
    }
    //进入用户修改密码页面
    @RequestMapping("userPwd.do")
    public String userPwd(Model model){
         //model.addAttribute("result" ,new ResponseResult(CommonCode.FAIL));
        return "userPwd";
    }


    //登录
    @RequestMapping("login.do")
    @ResponseBody
    public ResponseResult login(@RequestBody User user, HttpServletRequest res) {
        User _user = userService.login(user.getUserName(), user.getUserPass());
        System.out.println(_user);
        if (_user != null) {
            //修改用户为登录状态1
            _user.setLoginStatus(1);
            System.out.println("用户角色为："+_user.getRole());
            userService.update(_user);
            res.getSession().setAttribute("user", _user);
            return new ResponseResult(CommonCode.SUCCESS);
        } else {
            System.out.println(user.getUserName()+"-----"+user.getUserPass());
            return new ResponseResult(CommonCode.LOGINFAIL);
        }
    }


    //退出登录
    @RequestMapping("logout.do")
    public String logout(HttpServletRequest res) {
        //修改用户登录状态为0
        User user = (User)res.getSession().getAttribute("user");
        res.getSession().removeAttribute("user");
        System.out.println(user);
        user.setLoginStatus(0);
        user.setLastLoginTime(new Date(System.currentTimeMillis()));
        userService.update(user);
        return "redirect:/zone/findAllById.do?zoneId=1";
    }

    //修改用户信息(包括头像和邮箱)
    @RequestMapping("/userInfoUpdate.do")
    public String userInfoUpdate (String email, MultipartFile picUrl, HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        //本地路径
        String realPath = request.getSession().getServletContext().getRealPath("/images/");
        //项目路径
        System.out.println(realPath);
        String uuid=UUID.randomUUID().toString().replace("-", "");
        try {
            picUrl.transferTo(new File(realPath,uuid+"_"+picUrl.getOriginalFilename()));
        }  catch (Exception e) {
            e.printStackTrace();
        }
        //修改用户信息存入数据库和session中
        user.setEmail(email);
        user.setPicUrl("/images/"+ uuid+"_"+picUrl.getOriginalFilename());
        userService.update(user);
        request.getSession().setAttribute("user",user);
        model.addAttribute("result",new ResponseResult(CommonCode.SUCCESS));
        return "/userInfo";
    }
    //修改用户密码
    @RequestMapping("/updatePassword.do")
    public String updatePassword (String oldPassword,String newPassword,HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        System.out.println("旧密码为"+oldPassword);
        System.out.println("新密码为"+newPassword);
        if (!user.getUserPass().equals(oldPassword)){
            model.addAttribute("result",new ResponseResult(CommonCode.FAIL));
            return "userPwd";
        }
        //修改用户密码后重新存入session中
        user.setUserPass(newPassword);
        request.setAttribute("user",user);
        //修改数据库中用户信息
        userService.update(user);
        model.addAttribute("result",new ResponseResult(CommonCode.SUCCESS));
        return "userPwd";
    }

}

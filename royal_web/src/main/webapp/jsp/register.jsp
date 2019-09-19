<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛注册页</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>







<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="/images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=1">首页</a><span>></span>注册页面
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="reg-box">
            <h2>用户注册<span>（红色型号代表必填）</span></h2>
            <div class="reg-info">
                <form action="${pageContext.request.contextPath}/user/registerValidate1.do" method="post">
                    <ul>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 用户名：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="userName" name="userName" class="txt" value=""/>
                            </div>
                            <span class="tips" id="tip1">用户名必须是由英文、数字、下划线组成</span>
                        </li>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 密&nbsp;&nbsp;&nbsp;码：
                            </div>
                            <div class="reg-c">
                                <input type="password" id="userPass" name="userPass" class="txt" value=""/>
                            </div>
                            <span class="tips" id="tip2">密码长度必须6~10位的英文或数字</span>
                        </li>
                        <li class="no-tips">
                            <div class="reg-l">&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱：</div>
                            <div class="reg-c">
                                <input type="text" id="email" name="email" class="txt" value=""/>
                            </div>
                        </li>
                        <li>
                            <div class="reg-l"></div>
                            <div class="reg-c">
                                <input type="submit" class="submit-btn" value="注册"/><br/>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>




<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>
<script type="text/javascript">


   $(function () {
       $("#userName").blur(function () {
           var userName = $("#userName").val();
           var userNamereg = /^\w+$/;
           if(!userNamereg.test(userName)){
               $("#tip1").html("用户名必须是由英文、数字、下划线组成");
               $("#tip1").css("color","red");
               return;
           }else{
               $("#tip1").html("用户名必须是由英文、数字、下划线组成");
               $("#tip1").css("color","black");
           }
           var url="${pageContext.request.contextPath}/user/registerValidate.do";
           var args={userName:userName};
           $.post(url,args,function (data) {
               if(data=="success"){
                   $("#tip1").html("用户名可用");
                   $("#tip1").css("color","green");
               }else{
                   $("#tip1").html(data);
                   $("#tip1").css("color","red");
               }
           })
       })
       $("#userPass").blur(function () {
           var password=$("#userPass").val();
           var passwordreg = /^\w{6,10}$/;
           if(!passwordreg.test(password)){
               $("#tip2").css("color","red");
           }else{
               $("#tip2").css("color","green");
           }
       })




   })
</script>

</body>
</html>
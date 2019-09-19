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


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="${pageContext.request.contextPath}/images/logo.png" height="64" width="168" alt=""/></a>
            </h1>

        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=1">首页</a><span>></span>注册页面
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
        <div class="hm-inner"> 
            <div class="reg-box" style="text-align:center;height:200px;padding-top:100px;">
                <h2>注册失败！</h2>
                <%--自动跳转--%>
                <div><h1><span id="time">5</span>秒后自动跳转....</h1></div>
            </div>
        </div>
    </div>

<script>
    var second = 5;

    function gettime() {
        if (second <= 0) {
            location.href = "${pageContext.request.contextPath}/zone/findAllById.do?zoneId=1";
        }
        var time = document.getElementById("time");
        time.innerHTML = second;
        second--;
    };

    setInterval(gettime, 1000);


</script>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>


</body>
</html>
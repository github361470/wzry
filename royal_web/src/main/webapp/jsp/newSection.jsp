<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_info.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
    <style type="text/css">
        .hm-header-b {
            border-bottom: 1px solid #d9d9d9;
        }
    </style>
</head>
<body>


<jsp:include page="common/header.jsp"/>


<!--头部信息-->

<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="/images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
            <%-- <div class="search-box l">
                 <form action="javascript:;">
                     <input type="text" class="txt l" placeholder="请输入关键字">
                     <input type="button" value="搜索" class="btn l"/>
                 </form>
             </div>--%>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="/index.jsp">首页</a><span>></span>个人信息
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>

            <!--左侧用户名，头像-->
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img src="${pageContext.request.contextPath}${user.picUrl}"/>
                    <%--                    <div class="userName">${user.userName}</div>--%>
                </div>
                <ul class="user-info-l-b">
                    <li><i class="userName"></i>${user.userName}</li>
                    <li><i class="info-icon"></i>我的资料</li>
                    <%--info-icon--%>
                    <li><i class="safe-icon"></i>修改密码</li>
                    <li class="cur"><i class="safe-icon"></i> <c:choose>
                        <c:when test="${user.role eq 1}">
                            申请高级用户
                        </c:when>
                        <c:otherwise>
                            开辟新版块
                        </c:otherwise>
                    </c:choose></li>
                </ul>
            </div>


            <!--右侧用户信息-->
            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li><a href="${pageContext.request.contextPath}/user/userInfo.do">个人信息</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/userPwd.do">修改密码</a></li>

                        <c:choose>
                            <c:when test="${user.role eq 1}">
                    <li class="cur">     <a href="${pageContext.request.contextPath}/user/accessControl.do">申请高级用户</a> </li>
                            </c:when>
                            <c:otherwise>
                    <li class="cur">  <a href="${pageContext.request.contextPath}/user/newSection.do"> 开辟新版块</a> </li>
                    <li>  <a href="${pageContext.request.contextPath}/user/applyInfo.do"> 版块申请信息</a> </li>
                            </c:otherwise>
                        </c:choose>

                </ul>
                <!-- 判断是否已经做了新版块申请 -->
              <c:if test="${zoneapply.status eq -1}">
                    <form id="form"  action="${pageContext.request.contextPath}/user/requestNewSection.do" method="post">
                        <ul class="bd">
                            <li class="clearfix">
                                <div class="info-l">版块名称</div>
                                <div class="info-r">
                                    <input type="text" id="zoneName" name="zoneName" class="txt"/>
                                    <input type="hidden" name="userName" value="${user.userName}" class="txt"/>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="info-l">申请理由</div>
                                <div class="info-r"><input type="text"  style="height: 85px;padding: 1px;margin: 1px" name="reason" id="reason" placeholder="在此输入理由" class="txt"/></div>
                            </li>
                            <li class="clearfix">
                                <div class="info-l"></div>
                                <div class="info-r">
                                    <input type="button" class="btn" value="申请" onclick="sub();"/>
                                    <span id="msg" style="display: none"></span>
                                </div>
                            </li>
                        </ul>
                    </form>
                </c:if>

               <c:if test="${not empty result}">
                    <ul class="bd">
                        <li class="clearfix">
                            <div class="info-l red" style="">申请结果：</div>
                            <div class="info-l " style="text-align: center">
                                <c:if test="${result.success}">申请成功,等待管理员审核</c:if>
                                <c:if test="${!result.success}">申请失败</c:if>
                            </div>
                        </li>
                    </ul>
                </c:if>


            </div>


        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>
<script type="text/javascript">

    function sub() {
        $("#form").click(function () {
            if ($("#zoneName").val()=="") {
                alert("版块名称不能未空")
                return;
            }
            if ($("#reason").val()=="") {
                alert("申请理由不能为空")
                return;
            }
            var form = $("#form");
            form.submit();
        })
    }


</script>
</body>
</html>
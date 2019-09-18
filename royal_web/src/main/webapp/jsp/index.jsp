<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index-new.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>

</head>
<body>

<!-- 头部 -->
<jsp:include page="common/header.jsp"/>


<!-- 主体部分 -->
<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="hm-banner"></div>


        <!--头部，帖子统计，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix"><h2 class="l">王者荣耀</h2></div>
                <p>
                    <span>今日帖子<strong id="visit1"></strong></span>
                    <span>全部帖子<strong id="visit2"></strong></span>
                </p>
            </div>
            <div class="search-box l">
                <form action="${pageContext.request.contextPath}/search/searchArticle.do" method="post">
                    <%--返回页面时需要zoneId--%>
                    <input type="hidden" name="zoneId" value="${zoneId}">
                    <input type="text" class="txt l" placeholder="请输入关键字" name="keywords" value="${keywords}">
                    <input type="submit" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>


        <!-- 导航 -->
        <ul class="hm-bbs-nav border-lrb clearfix">
            <c:if test="${zoneId==1}">
            <li class="current">
                </c:if>
                <c:if test="${zoneId!=1}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=1"><em></em>综合交流区</a>
            </li>


                <c:if test="${zoneId==2}">
                <li class="current">
                    </c:if>
                    <c:if test="${zoneId!=2}">
                <li>
                    </c:if>
                <a href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=2"><em></em>BUG反馈区</a>
            </li>

                <c:if test="${zoneId==3}">
                <li class="current">
                    </c:if>
                    <c:if test="${zoneId!=3}">
                <li>
                    </c:if>
                <a href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=3"><em></em>新闻公告区</a>
            </li>

                <c:if test="${zoneId==4}">
                <li class="current">
                    </c:if>
                    <c:if test="${zoneId!=4}">
                <li>
                    </c:if>
                <a href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=4"><em></em>活动专区</a>
            </li>
        </ul>


        <!-- 主体部分 -->
        <div class="hm-bbs-main border-lrb clearfix">
            <!-- 左侧列表 -->
            <div class="list-view l">
                <ul>
                    <%--
                    <li class="clearfix ding">
                        <div class="hm-index-title">
                            <i class="set-to-top">顶</i> <a href="getArticle.do">求官方出艾琳英雄活动</a>
                        </div>
                        <div class="hm-index-con">本人玩得迟，所以看到别人用艾琳的时候，特别羡慕，现贵族6了，很想要一个艾琳，我身边很多朋友也想要，求</div>
                        <div class="hm-index-info l">
                            <span class="article-username">晨曦初露</span>
                            <span class="post-time">2017-05-24 08:00:05</span>
                        </div>
                        <div class="hm-index-fun r">
                            <span class="icon-like"><i></i>1</span>
                            <span class="icon-talk"><i></i>0</span>
                        </div>
                    </li>
                    --%>

                    <%--使用c:forEach遍历该区域的所有的article--%>
                    <c:forEach items="${list}" var="article">
                        <c:if test="${article.isTop==0}">
                            <li class="clearfix ">
                        </c:if>
                        <c:if test="${article.isTop==1}">
                            <li class="clearfix ding ">
                        </c:if>
                        <div class="hm-index-title">
                            <i class="set-to-top">顶</i> <a href="${pageContext.request.contextPath}/getArticle/findDetailArticleById.do?articleId=${article.articleId}">${article.title}</a>
                        </div>
                        <div class="hm-index-con">${article.content}</div>
                        <div class="hm-index-info l">
                            <span class="article-username">${article.senderName}</span><span
                                class="post-time">${article.sendTimeStr}</span>
                        </div>
                        <div class="hm-index-fun r">
                            <span class="icon-like"><i></i>${article.upvoteCount}</span>
                            <span class="icon-talk"><i></i>${article.replyCount}</span>
                        </div>
                        </li>


                    </c:forEach>


                </ul>
            </div>


            <!-- 右侧侧边栏,在线用户 -->
            <div class="aside l">
                <div class="aside-box">
                    <h3 class="t">
                        <a id="onlineNumbers" href="javascript:;"></a>
                    </h3>
                    <ul class="b clearfix" id="onlineUser">

                    </ul>
                </div>
            </div>


        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>


<!-- 右边发帖，回顶部 -->
<div class="fixedBar" id="j_fixedBar">
    <a id="newTopicBtn" href="javascript:;"  class="newTopic"><span></span>发帖</a>

    <a href="#" class="goTop"><i> </i><span>返回<br/>顶部</span></a>
</div>


<!-- 发帖弹出框 -->
<form action="${pageContext.request.contextPath}/send/sendArticle.do" method="post">
    <div class="pop-box ft-box">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">主题帖</h4><span class="close r">&times;</span>
            </div>
            <%--需要zoneId提交到对应的区域--%>
            <input type="hidden" name="zoneId" value="${zoneId}">
            <%--伪代码 需要用户名--%>
            <input type="hidden" name="username" value="xiaobao">
            <div class="win_bd">
                <div class="win_bd_t">
                    <input type="text" id="title" name="title" placeholder="帖子标题"/>
                </div>
                <div class="win_bd_b">
                    <textarea id="content" name="content" placeholder="正文"></textarea>
                </div>
            </div>
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="submit" class="btn" value="发表"/>
                </div>
            </div>
        </div>
    </div>
</form>


<script>

    <%-- 获取今日访问人数--%>
    $(function () {
        $(function () {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/visit/todayVisit.do",
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                success: function (data) {
                    $("#visit1").html(data);
                }
            });
        })
    });

    <%-- 获取总访问人数--%>
    $(function () {
        $(function () {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/visit/totalVisit.do",
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                success: function (data) {
                    $("#visit2").html(data);
                }
            });
        })
    });

    <%--显示在线用户--%>
    $(function () {
        $(function () {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/online/findOnlineUser.do",
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                success: function (data) {
                    var onLine = data;
                    $("#onlineNumbers").html("在线用户" + "(" + onLine.length + ")");
                    var res = "";
                    for (var i = 0; i < onLine.length; i++) {
                        res += "<li>" + "<img" + " " + "src=" + "${pageContext.request.contextPath}" + onLine[i]["picUrl"] + " " + "height =" + "55" + "/>" + "<p>" + onLine[i]["userName"] + "</p>" + "</li>";
                    }
                    $("#onlineUser").append(res);
                }
            });
        })
    });


    <%--发帖先判断是否有用户--%>
$(".btn").click(function () {
    
    if (false){
        alert("请先登录");
        location.href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=1";
    }
})





</script>


</body>
</html>
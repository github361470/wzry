<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛详情页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/detail.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/getArticle.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>

    <style>
        .floor-con .icon-report i {
            background-position: -64px -16px;
        }

        .floor-con .icon-like0 i {
            background-position: 0px 0px;
        }

        .floor-con .icon-feedback1 i {
            background-position: -112px -32px;
        }

        .floor-con .icon-comment, .floor-con .icon-feedback, .floor-con .icon-report, .floor-con .icon-feedback1 {
            position: absolute;
            right: 10px;
            bottom: 10px;
        }

    </style>

</head>


<body>





<!-- 头部 -->
<jsp:include page="common/header.jsp"/>


<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">

        <!--帖子标题，点赞数，回复数，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix">
                    <h2 class="l">${article.title}</h2>
                    <div class="hm-detail-fun l">
					     <span class="icon-like">
					         <a href="javaScript:;" id="getUpvoteCount"><i></i>${article.upvoteCount}</a>
					     </span>
                        <span class="icon-talk" id="replyCount">
						     <i></i>${article.replyCount}
						</span>
                    </div>
                </div>
            </div>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>


        <!--导航，回首页，帖子标题，排序-->
        <div class="detail-page-box clearfix">
            <a href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=1">
                <i class="hm-ico-home"></i>首页
            </a>
            <span>></span>
            <a href="#">${article.title}</a>
            <a class="new-to-old r" href="" style="font-size:12px;float: right;">
                <i></i>从新到旧查看
            </a>
        </div>


        <div class="detail-box">
            <ul class="detail-floors">

                <!--原帖楼-->
                <li class="floor clearfix">
                    <div class="floorer-info l">
                        <div class="floorer-photo"><img src="${pageContext.request.contextPath}${article.user.picUrl}"/>
                        </div>
                        <div class="floorer-name">楼主:${article.senderName}</div>
                    </div>
                    <div class="floor-con l">
                        <div class="floor-info clearfix">
                            <div class="floor-time l">发帖时间：${article.sendTimeStr}</div>
                            <div class="r">${article.browseCount}次查看</div>
                        </div>
                        <div class="floor-art-ans">
                            <div class="floor-art">
                                <p>${article.content}</p>
                            </div>
                            <div class="floor-ans"></div>
                        </div>

                        <%--  style="right: 100px"--%>
                        <%--<span class="icon-like0" style="right: 100px">
                                <a href="javaScript:void(0);" id="collect"> <i></i> 点赞</a>
                            </span>
                        <span class="icon-comment"><a href="#comment"> <i></i> 评论</a></span>--%>

                        <span id="myUpVote" class="icon-feedback" style="right: 150px"><a
                                href="javascript:void(0)" id="collect"> <i></i> 点赞</a></span>
                        <span class="icon-report"><a href="javascript:;"  onclick="showDialog2()"> <i></i> 举报</a></span>
                        <span class="icon-comment" style="right: 80px"><a
                                href="#comment" id="newTopic"> <i></i> 评论</a></span>


                    </div>
                </li>


`
                <c:forEach items="${article.comments}" var="comment" varStatus="s">
                <!-- 评论部分,一楼及以后 -->
                <li class="floor clearfix">

                    <div class="floorer-info l">
                        <div class="floorer-photo"><img
                                src="${pageContext.request.contextPath}${comment.user.picUrl}"/></div>
                        <div class="floorer-name">${comment.user.userName}</div>
                    </div>
                    <div class="floor-con l">
                        <div class="floor-info clearfix">
                            <div class="floor-time l">回贴时间：${comment.commentTimeStr}</div>
                            <div class="r">${s.count}楼</div>
                        </div>
                        <div class="floor-art-ans">
                            <div class="floor-art">
                                <p>${comment.commentContent}</p>
                            </div>


                            <div class="floor-ans">

                                <ul>
                                <!-- 回复部分,楼中楼 -->
                                    <c:forEach items="${comment.replies}" var="reply">

                                        <li class="clearfix">
                                            <div class="floor-ans-pho l"><img src="${reply.user.picUrl}"/></div>
                                            <div class="floor-ans-con l">
                                                <span class="name">${reply.replyUserName}</span>：${reply.replyContent}
                                                <span class="ans-time">${reply.replyTimeStr}</span>
                                            </div>
                                        </li>

                                    </c:forEach>



                                </ul>
                            </div>


                            <span class="icon-comment">
                                <a href="javascript:;" onclick="showDialog(${s.count},${commentId})"> <i></i> 回复</a>
                            </span>
                        </div>
                    </div>
                </li>
                </c:forEach>

                <%--评论判断--%>
                <c:if test="${ not empty user}">
                <!--发表评论-->
                <div class="detail-to-comment">
                    <div class="tit"><a name="comment">发表评论</a></div>
                    <!-- 未登录时候显示 <div class="con">您没有登录论坛，请登录后再进行回复</div>-->

                    <!-- 登录后显示评论输入框-->
                    <form action="${pageContext.request.contextPath}/comments/saveComment.do" method="post" onsubmit="return checkReport();" >
                        <div class="con con-loged">
                            <div class="con-t">
                                <textarea id="content" name="commentContent" placeholder="请在此输入您要回复的信息"></textarea>
                            </div>
                            <input type="hidden" name="username" value="${user.userName}">
                            <input type="hidden" name="articleId" value="${article.articleId}">
                            <div class="con-b">
                                <input type="submit" class="btn"/>
                                <span class="num">不能超过5000字</span>
                            </div>
                        </div>
                    </form>
                </div>
                </c:if>
        </div>
    </div>


    <!-- 底部 -->
    <jsp:include page="common/footer.jsp"/>




    <!-- 回复弹出框 -->
    <form action="${pageContext.request.contextPath}/replys/saveReply.do" method="post" onsubmit="return check();">
        <div class="pop-box ft-box" id="huifu">
            <div class="mask"></div>
            <div class="win">
                <div class="win_hd">
                    <h4 class="l">回复<span id="floorSpan"></span>楼</h4>
                    <span class="close r">&times;</span>
                </div>
                <div class="win_bd">
                    <div class="win_bd_b">
                        <textarea id="replyContent" name="replyContent" placeholder="回复内容限于40字以内"></textarea>
                    </div>
                </div>
                <div class="win_ft">
                    <div class="win_ft_in">
                        <input type="submit" class="btn" value="回复"/>
                        <input type="hidden" id="commentId" name="commentId"/>
                        <input type="hidden" name="username" value="${user.userName}">
                        <input type="hidden" name="articleId" value="${article.articleId}">
                    </div>
                </div>
            </div>
        </div>
    </form>


    <!-- 举报帖子弹出框 -->
    <form action="${pageContext.request.contextPath}/report/reportByName.do" method="post" onsubmit="return inspect();">
        <div class="pop-box ft-box" id="jubaopinglun">
            <div class="mask"></div>
            <div class="win">
                <div class="win_hd">
                    <h4 class="l">举报该贴</h4>
                    <span class="close r">&times;</span>
                </div>
                <div class="win_bd">
                    <div class="win_bd_b">
                        <textarea id="replyContent4" name="replyContent" placeholder="举报内容限于40字以内"></textarea>
                    </div>
                </div>
                <div class="win_ft">
                    <div class="win_ft_in">
                        <input type="submit" class="btn" value="举报"/>
                        <input type="hidden" id="commentId2" name="commentId"/>
                        <input type="hidden" name="username" value="${user.userName}">
                        <input type="hidden" name="articleId" value="${article.articleId}">
                    </div>
                </div>
            </div>
        </div>
    </form>





    <div class="fixedBar" id="j_fixedBar">
        <a href="#comment" class="newTopic"><span></span>评论</a>
        <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
    </div>


</body>

<script type="text/javascript">

    //弹出回复框
    function showDialog(num, commentId) {
        //判断用户是否登录
        var loginUser = "${user}";
        if (!loginUser) {
            alert("您没有登录论坛，请登录后再进行回复");
            return;
        }
        $("#commentId").val(commentId);
        $("#huifu").css('display', 'block');
        $("#floorSpan").html(num);
    }




    //弹出举报帖子框
    function showDialog2(num, commentId) {
        //判断用户是否登录
        var loginUser = "${user}";
        if (!loginUser) {
            alert("您没有登录论坛，不能进行举报!");
            return;
        }
        $("#commentId2").val(commentId);
        $("#jubaopinglun").css('display', 'block');
    }




    //点击收藏，发送ajax

    $("#collect").click(
        function () {
            var attr = $("#collect").parent().attr("class");
            if (${empty user}) {
                alert("您没有登录论坛，请登录后再进行收藏");
                return false;
            }



            //icon-feedback  icon-111
        else
            if (attr == 'icon-feedback') {
                $("#collect").parent().attr("class", 'icon-feedback1');

                alert('icon-feedback');

                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/upvote/saveUpvote.do?articleId=" + ${article.articleId} +"&upvoteUserName=xiaobao",
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                        location.reload();

                    }
                });

            } else if (attr == 'icon-feedback1') {
                $("#collect").parent().attr("class", 'icon-feedback');
                alert('icon-feedback1');

                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/upvote/deleteUpvote.do?articleId=" + ${article.articleId} +"&upvoteUserName=xiaobao",
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                        location.reload();
                    }
                });

            }


        }
    )



    <%--评论先判断是否有用户--%>
    $(".newTopic").click(function () {

        if (${empty user}) {
            alert("您没有登录论坛，请登录后再进行评论");
            return false;
        }
        if (${user.talkStatus == 1}){
            alert("您已被禁言，不能进行评论");
            return false;
        }
    });

    $("#newTopic").click(function () {

        if (${empty user}) {
            alert("您没有登录论坛，请登录后再进行评论");
            return false;
        }
        if (${user.talkStatus == 1}){
            alert("您已被禁言，不能进行评论");
            return false;
        }
    });




    <%--评论前先判断是否，禁言，数据--%>
   function  checkReport(){


       var content = $("#content").val();
       if (content == "" || content.length == 0 ) {
           alert("评论内容不能为空");
           return false;
       }
       if (content.length >=30) {
           alert("评论内容过长");
           return false;
       }
   }




    <%--回复先判断是否有数据--%>
    function check() {
        var content = $("#replyContent").val();
        if (content == "" || content.length == 0 ) {
            alert("回复内容不能为空");
            return false;
        }
        if (content.length >=30) {
            alert("回复内容过长");
            return false;
        }
    }


    //举报功能
    function inspect() {
     /*   $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/report/reportByName.do?userName=${user.userName}",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (data) {
                alert("举报已提交!")
            }
        });*/
    }




</script>
</html>
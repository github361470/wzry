<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>敏感词汇管理页面</title>

</head>
<style type="text/css">
    html, body {
        overflow: auto;
        height: 100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }


</style>
<script>

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="../../jsp/commom/head.jsp" %>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="../../jsp/commom/leftsidebar.jsp" %>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div>
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">敏感词汇管理</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <button class="btn btn-primary" data-toggle="modal" data-target="#word_detail"
                                onclick="article_Detail('${report.article.articleId}')">
                            新增敏感词
                        </button>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>敏感词</th>
                        <th>是否启用</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${wordsPage.list}" var="word">
                        <tr id="tr_${word.wordId}">
                            <td width="15%" id="id">${word.wordId}</td>
                            <td width="30%" class="line-limit-length">${word.word} </td>
                            <td width="15%" class="line-limit-length" id="statusStr_${word.wordId}">${word.statusStr}</td>
                            <td width="15%">
                                <c:if test="${word.status==1}">
                                    <a href="javaScript:on('${word.wordId}','${wordsPage.pageNum}')" role="button" id="top_${word.wordId}" class="btn btn-primary">停用</a>
                                    <a href="javaScript:off('${word.wordId}','${wordsPage.pageNum}')" role="button" id="notop_${word.wordId}"class="btn btn-danger" style="display:none;">启用</a>
                                </c:if>
                                <c:if test="${word.status==0}">
                                    <a href="javaScript:on('${word.wordId}','${wordsPage.pageNum}')" role="button" id="top_${word.wordId}" class="btn btn-primary" style="display:none;">停用</a>
                                 <a href="javaScript:off('${word.wordId}','${wordsPage.pageNum}')" role="button" id="notop_${word.wordId}" class="btn btn-danger">启用</a>
                                </c:if>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${wordsPage.pageNum} 页.总共 ${wordsPage.pages} 页.一共 ${wordsPage.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <a href="#" onclick="searchArticle('${wordsPage.pageNum-1}')" aria-label="Previous">
                                    <span aria-hidden="true">«</span>
                                </a>
                            </li>
                            <c:forEach items="${wordsPage.navigatepageNums}" var="page_num">
                                <li><a href="#" onclick="searchArticle('${page_num}')">${page_num}</a></li>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <a href="javascript:void(0)" onclick="searchArticle('${wordsPage.pageNum+1}')"
                                   aria-label="Next">
                                    <span aria-hidden="true">»</span>
                                </a>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${wordsPage.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp" %>
    </div><!-- /.hrms_dept_body -->
    <%@include file="WordUpdate.jsp"%>

</div><!-- /.hrms_dept_container -->
<script>

    function on(articleId,page) {
        $.ajax({
            url:"${pageContext.request.contextPath}/word/Word_On.do",
            type:"POST" , //请求方式
            data:{"id":articleId,
                "page":page},
            success:function (data) {
                if (data){
                   $("#top_"+articleId).hide();
                   $("#notop_"+articleId).show();

                    $("#statusStr_"+articleId).text("禁用")
                }
            },//响应成功后的回调函数
            error:function () {
                alert("出错啦...")
            },//表示如果请求响应出现错误，会执行的回调函数
            dataType:"json",//设置接受到的响应数据的格式
        })
    }
    function off(articleId,page) {
        $.ajax({
            url:"${pageContext.request.contextPath}/word/Word_Off.do",
            type:"POST" , //请求方式
            data:{"id":articleId,
                "page":page},
            success:function (data) {
                if (data){
                    $("#notop_"+articleId).hide();
                    $("#top_"+articleId).show();
                    $("#statusStr_"+articleId).text("使用中")

                }
            },//响应成功后的回调函数
            error:function () {
                alert("出错啦...")
            },//表示如果请求响应出现错误，会执行的回调函数
            dataType:"json",//设置接受到的响应数据的格式
        })
    }

    function searchArticle(e) {
        location.href = "${pageContext.request.contextPath}/word/findByPage.do?size=5&page=" + e;
    }


</script>
</body>
</html>

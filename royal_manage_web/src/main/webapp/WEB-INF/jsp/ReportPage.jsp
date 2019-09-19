<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审批举报页面</title>

</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
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
    <%@ include file="../../jsp/commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="../../jsp/commom/leftsidebar.jsp"%>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div >
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">审批举报</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->

                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>帖子ID</th>
                        <th>举报内容</th>
                        <th>举报人</th>
                        <th>举报时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${reportMsgs.list.size()==0}">
                        <tr>
                            <td colspan="6">
                                <strong style="margin-left: 45%">暂无举报信息</strong>
                            </td>
                        </tr>
                    </c:if>
                        <c:forEach items="${reportMsgs.list}" var="report">
                            <tr id="tr_${report.reportId}">
                                <td width="5%">${report.article.articleId}</td>
                                <td width="30%" class="line-limit-length">
                                   ${report.reportContent}
                                </td>
                                <td width="10%" class="line-limit-length">${report.reportUserName}</td>
                                <td width="15%" class="line-limit-length">
                                   ${report.reportTimeStr}
                                </td>
                                <td width="15%">
                                     <!-- 按钮触发模态框 -->
                                    <button class="btn btn-primary" data-toggle="modal" data-target="#article_detail"
                                            onclick="article_Detail('${report.article.articleId}')">
                                        相关帖子
                                    </button>

                                    <a href="${pageContext.request.contextPath}/report_manage/verb.do?reportId=${report.reportId}&page=${reportMsgs.pageNum}&articleId=${report.article.articleId}" role="button" class="btn btn-danger">屏蔽</a>

                                    <a href="${pageContext.request.contextPath}/report_manage/return.do?reportId=${report.reportId}&page=${reportMsgs.pageNum}&articleId=${report.article.articleId}" role="button" class="btn btn-info">驳回</a>
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
                    当前第 ${reportMsgs.pageNum} 页.总共 ${reportMsgs.pages} 页.一共 ${reportMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${reportMsgs.hasPreviousPage}">
                                        <a href="#" onclick="searchArticle('${reportMsgs.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <c:forEach items="${reportMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == reportMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != reportMsgs.pageNum}">
                                    <li><a href="#" onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${reportMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchArticle('${reportMsgs.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${reportMsgs.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%@ include file="ArticleUpdate.jsp"%>
    <script>
        function pass(id,page,articleId) {
            $.ajax({
                url:"${pageContext.request.contextPath}/report_manage/verb.do",
                type:"POST" , //请求方式
                data:{"reportId":id,
                    "page":page,
                    "articleId":articleId},
                success:function (data) {
                    if (data){
                        $("#tr_"+id).remove();
                    }
                },//响应成功后的回调函数
                error:function () {
                    alert("出错啦...")
                },//表示如果请求响应出现错误，会执行的回调函数
                dataType:"json",//设置接受到的响应数据的格式
            })
        }
        function reject(id,page) {
            $.ajax({
                url:"${pageContext.request.contextPath}/report_manage/return.do",
                type:"POST" , //请求方式
                data:{"reportId":id,
                    "page":page},
                success:function (data) {
                    if (data){
                        $("#tr_"+id).remove();
                    }
                },//响应成功后的回调函数
                error:function () {
                    alert("出错啦...")
                },//表示如果请求响应出现错误，会执行的回调函数
                dataType:"json",//设置接受到的响应数据的格式
            })
        }
     function article_Detail(id) {
         $.ajax({
             url:"${pageContext.request.contextPath}/article_manage/findById.do",
             type:"POST" , //请求方式
             data:{"articleId":id},
             success:function (data) {
                 $("#detail_content").val(data.content);
                 $("#detail_title").val(data.title);
             },//响应成功后的回调函数
             error:function () {
                 alert("出错啦...")
             },//表示如果请求响应出现错误，会执行的回调函数
             dataType:"json",//设置接受到的响应数据的格式
             traditional: true//传递数组时需要设定的属性
         })
     }
     function searchArticle(e) {
         location.href="${pageContext.request.contextPath}/report_manage/findByPage.do?size=5&page="+e;
     }

    </script>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        帖子信息详情
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal article_detail_form">
                        <div class="form-group">
                            <label for="detail_title" class="col-sm-2 control-label">标题</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" rows="3" name="title" id="detail_title" disabled></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="detail_content" class="col-sm-2 control-label">内容</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" rows="3" name="content" id="detail_content" disabled></textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</body>
</html>

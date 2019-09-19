<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖信息管理页面</title>

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
                        <li><a href="#">用户管理</a></li>
                        <li class="active">板块审核</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <input type="button" id="preButton" data-toggle="modal" data-target="#article_detail" value="当前版块" class="form-control btn-primary">
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>用户名</th>
                        <th>申请版块</th>
                        <th>申请原因</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${zoneApplyMsgs.list.size()==0}">
                        <tr >
                            <td colspan="6">
                                <strong style="margin-left: 45%"> 暂无版块审核</strong>
                            </td>
                        </tr>
                    </c:if>
                    <c:forEach items="${zoneApplyMsgs.list}" var="zoneApply">
                        
                            <tr id="tr_${zoneApply.applyZoneId}">
                                <td width="10%">${zoneApply.applyZoneId}</td>
                                <td width="10%" class="line-limit-length">${zoneApply.userName}</td>
                                <td width="25%" class="line-limit-length">${zoneApply.zoneName}</td>
                                <td width="30%" class="line-limit-length">${zoneApply.reason}</td>
                                <td width="15%">

                                   <%-- <a href="javaScript:pass('${zoneApply.applyZoneId}','${zoneApplyMsgs.pageNum}')" role="button" class="btn btn-primary">通过</a>

                                    <a href="javaScript:reject('${zoneApply.applyZoneId}','${zoneApplyMsgs.pageNum}')" role="button" class="btn btn-danger" >驳回</a>
                              --%>
                                       <a href="${pageContext.request.contextPath}/zoneApply_manage/pass.do?id=${zoneApply.applyZoneId}&page=${zoneApplyMsgs.pageNum}" role="button" class="btn btn-primary">通过</a>

                                       <a href="${pageContext.request.contextPath}/zoneApply_manage/reject.do?id=${zoneApply.applyZoneId}&page=${zoneApplyMsgs.pageNum}" role="button" class="btn btn-danger" >驳回</a>

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
                    当前第 ${zoneApplyMsgs.pageNum} 页.总共 ${zoneApplyMsgs.pages} 页.一共 ${zoneApplyMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchzoneApply(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${zoneApplyMsgs.hasPreviousPage}">
                                        <a href="#" onclick="searchzoneApply('${zoneApplyMsgs.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <c:forEach items="${zoneApplyMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == zoneApplyMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != zoneApplyMsgs.pageNum}">
                                    <li><a href="#" onclick="searchzoneApply('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${zoneApplyMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchzoneApply('${zoneApplyMsgs.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchzoneApply('${zoneApplyMsgs.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="zoneApplyAdd.jsp"%>--%>
<%@ include file="ZoneApplyUpdate.jsp"%>
<script>
    function pass(id,page) {
        $.ajax({
            url:"${pageContext.request.contextPath}/zoneApply_manage/pass.do",
            type:"POST" , //请求方式
            data:{"id":id,
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

    function reject(id,page) {
        $.ajax({
            url:"${pageContext.request.contextPath}/zoneApply_manage/reject.do",
            type:"POST" , //请求方式
            data:{"id":id,
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
    function searchzoneApply(e) {
        location.href="${pageContext.request.contextPath}/zoneApply_manage/findByPage.do?size=5&page="+e;
    }
    $("#preButton").click(function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/zoneApply_manage/findAllZone.do",
            type:"POST" , //请求方式
            success:function (data) {
                for (var i=0;i<data.length;i++){
                    $("#zoneForm").append(' <div class="form-group">\n' +
                        '                        <label for="detail_title" class="col-sm-2 control-label"></label>\n' +
                        '                        <div class="col-sm-8">\n' +
                        '                            <textarea class="form-control" rows="2" name="title" id="detail_title" disabled>\n' +data[i].zoneName+
                        '                        </textarea></div>\n' +
                        '                    </div>')
                }
            },//响应成功后的回调函数
            error:function () {
                alert("出错啦...")
            },//表示如果请求响应出现错误，会执行的回调函数
            dataType:"json",//设置接受到的响应数据的格式
            traditional: true//传递数组时需要设定的属性
        })
    })
</script>
</body>
</html>

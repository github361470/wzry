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
                        <li class="active">用户信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="get" id="userSearchForm" action="${pageContext.request.contextPath}/user_manage/findByPage.do">
                            <table>
                                <tr>
                                    <th>
                                        <label for="userName" class="control-label">用户名:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="userName" class="form-control"
                                               name="userName" value="${searchUser.userName}">
                                    </th>
                                    <th>
                                        <label for="role" class="control-label">用户组:</label>
                                    </th>
                                    <th>

                                        <select class="form-control" id="role" name="role">
                                            <option value="0"></option>
                                            <option value="1">普通用户</option>
                                            <option value="2">高级用户</option>
                                            <option value="3">超级管理员</option>
                                        </select>
                                    </th>
                                    <th colspan="2">
                                        <input type="submit" value="查询" class="form-control btn-primary">
                                    </th>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">

                    <thead>

                        <tr>
                            <th>用户名</th>
                            <th>用户组</th>
                            <th>邮箱</th>
                            <th>是否禁言</th>
                            <th>最近登陆时间</th>
                            <th>操作</th>
                        </tr>


                    </thead>
                    <tbody>

                       <c:if test="${usersMsgs.list.size()==0}">
                       <tr>
                           <td colspan="6">
                            <strong style="margin-left: 45%"> 无搜索记录</strong>
                           </td>
                       </tr>
                       </c:if>

                    <c:forEach items="${usersMsgs.list}" var="user">
                            <tr id="tr_${user.userId}">
                                <td width="10%">${user.userName}</td>
                                <td width="10%" class="line-limit-length">${user.roleStr}</td>
                                <td width="15%" class="line-limit-length">${user.email}</td>
                                <td width="10%" class="line-limit-length" id="talk_${user.userId}">${user.talkStatusStr}</td>
                                <td width="30%">${user.lastLoginTimeStr}</td>
                                <td width="15%">
                                    <c:if test="${user.role==1 and user.isupdating==1 and user.updateStatus==0}">
                                        <a href="/user_manage/grade.do?id=${user.userId}&page=${usersMsgs.pageNum}" role="button" class="btn btn-primary">升级</a>
                                    </c:if>
                                    <c:if test="${user.role==2 or user.role==3}">
                                        <a href="#" role="button" class="btn btn-primary" disabled="disabled">升级</a>
                                    </c:if>
                                  <%-- <c:if test="${user.talkStatus==0}">
                                        <a href="/user_manage/changeTalkStatus.do?id=${user.userId}&page=${usersMsgs.pageNum}" role="button" class="btn btn-danger">禁言</a>
                                    </c:if>
                                    <c:if test="${user.talkStatus==1}">
                                        <a href="/user_manage/changeTalkStatus.do?id=${user.userId}&page=${usersMsgs.pageNum}" role="button" class="btn btn-info" >恢复</a>
                                    </c:if>--%>
                                    <c:if test="${user.talkStatus==0}">
                                        <a href="javaScript:changeStatus('${user.userId}','${usersMsgs.pageNum}',1)" role="button" id="top_${user.userId}" class="btn btn-danger">禁言</a>
                                        <a href="javaScript:changeStatus('${user.userId}','${usersMsgs.pageNum}',2)" role="button" id="notop_${user.userId}" class="btn btn-info" style="display:none;" >恢复</a>
                                    </c:if>
                                    <c:if test="${user.talkStatus==1}">
                                        <a href="javaScript:changeStatus('${user.userId}','${usersMsgs.pageNum}',1)" role="button" id="top_${user.userId}" class="btn btn-danger" style="display:none;" >禁言</a>
                                        <a href="javaScript:changeStatus('${user.userId}','${usersMsgs.pageNum}',2)" role="button" id="notop_${user.userId}" class="btn btn-info" >恢复</a>
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
                    当前第 ${usersMsgs.pageNum} 页.总共 ${usersMsgs.pages} 页.一共 ${usersMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchuser(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${usersMsgs.hasPreviousPage}">
                                        <a href="#" onclick="searchuser('${usersMsgs.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <c:forEach items="${usersMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == usersMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != usersMsgs.pageNum}">
                                    <li><a href="#" onclick="searchuser('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${usersMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchuser('${usersMsgs.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchuser('${usersMsgs.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="userAdd.jsp"%>--%>
<%--<%@ include file="userUpdate.jsp"%>--%>

<script>

    $(function () {
        if ($.isEmptyObject(${searchUser.role}) != true) {
           $('#role').append('<option value="${searchUser.role}" selected="selected">${searchUser.roleStr}</option>');
        }
    })
    function searchuser(e) {
        location.href="${pageContext.request.contextPath}/user_manage/findByPage.do?&userName=&role=0&size=5&page="+e;
    }

    function changeStatus(articleId,page,id) {
        $.ajax({
            url:"${pageContext.request.contextPath}/user_manage/changeTalkStatus.do",
            type:"POST" , //请求方式
            data:{"id":articleId,
                "page":page},
            success:function (data) {
                if (data){
                    if (id==1){
                        $("#top_"+articleId).hide();
                        $("#notop_"+articleId).show();
                        $("#talk_"+articleId).text("是")
                    }else if (id==2){
                        $("#notop_"+articleId).hide();
                        $("#top_"+articleId).show();
                        $("#talk_"+articleId).text("否")
                    }
                }
            },//响应成功后的回调函数
            error:function () {
                alert("出错啦...")
            },//表示如果请求响应出现错误，会执行的回调函数
            dataType:"json",//设置接受到的响应数据的格式
        })
    }
</script>
</body>
</html>

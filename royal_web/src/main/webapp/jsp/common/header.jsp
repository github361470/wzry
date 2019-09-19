<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<div class="hm-top-nav">
    <div class="hm-inner clearfix">
        <div class="hm-inner-l l"></div>
        <div class="hm-inner-r r">
            <div class="box">
                <c:if test="${empty user}">
                <a href="javascript:;" id="login" class="to-login">游客登录</a>
                <a href="<c:url value="${pageContext.request.contextPath}/user/register.do"/>">【新用户注册】</a>
                <div id="dialogBg"></div>
                <div id="dialog" class="animated">
                    <img class="dialogIco" width="50" height="40" src="/images/ico.png"/>
                    <div class="dialogTop" style="height:25px;">
                        <a href="javascript:;" class="closeDialogBtn">关闭</a>
                    </div>
                    <form id="loginform">

                        <ul class="editInfos">
                            <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/></li>
                            <span id="msg" STYLE="color:red;"></span>
                            <li><input type="button" value="登录" class="submitBtn"/></li>
                        </ul>
                    </form>
                </div>
                </c:if>

                <c:if test="${not empty user}">
                    欢迎您&nbsp;
                    <c:choose>
                        <c:when test="${user.role eq 1}">
                            普通用户:
                         </c:when>
                        <c:otherwise>
                            高级用户:
                        </c:otherwise>
                    </c:choose>
                    ${user.userName}&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/userInfo.do">个人中心</a>&nbsp;
                    <a href="${pageContext.request.contextPath}/user/logout.do">注销</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
  $(function () {
      //显示弹框
      $('.box #login').click(function () {
          var className = $(this).attr('class');
          $('#dialogBg').fadeIn(300);
          $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
          $('#userName').focus();
          $("#j_fixedBar").hide();
      });

      //关闭弹窗
      $('.closeDialogBtn').click(function () {
          $('#dialogBg').fadeOut(300, function () {
              $('#dialog').addClass('bounceOutUp').fadeOut();
              $("#j_fixedBar").show();
          });
      });
     
  });
  //进行用户登录的验证
  $(".submitBtn").click(function () {
      var formObject = {}
      var data = $("#loginform").serializeArray()
      $.each(data,function(i,item){
          formObject[item.name] = item.value
      });

      if ($("[name='userName']").val() && $("[name='userPass']").val()) {
          $.ajax({
              type:"post",
              url:"/user/login.do",
              contentType : "application/json" ,
              dataType : "json",
              data:  JSON.stringify(formObject),
              success:function (data) {
                  console.log(formObject)
                  if (data.success) {
                      location.href="${pageContext.request.contextPath}/zone/findAllById.do?zoneId=1";
                  }else{
                      $("#msg").html(data.message);
                  }
              }
          } )
      }
  })

      
</script>
</html>


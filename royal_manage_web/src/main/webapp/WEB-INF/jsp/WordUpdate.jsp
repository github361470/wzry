<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加敏感词汇</title>
</head>
<body>

<!-- /.帖子详情页 -->
<div class="modal fade article-detail-modal" id="word_detail" tabindex="-1" role="dialog" aria-labelledby="article-detail-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">添加敏感词汇</h4>
            </div>
            <div class="modal-body">
                <form method="post" class="form-horizontal article_detail_form" id="from" action="${pageContext.request.contextPath}/word/addNewWord.do" >
                    <div class="form-group">
                        <label for="word" class="col-sm-2 control-label">敏感词</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="word" name="word" oninput="change1()">
                            <label id="recur"></label>
                            <input type="hidden" name="status" value=0>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="save" disabled="disabled">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>

    function change1() {
        $.ajax({
            url:"${pageContext.request.contextPath}/word/findRecur.do",
            type:"POST" , //请求方式
            data:{"word":$("#word").val()},
            success:function (data) {
                if (data==true) {
                    $("#save").attr("disabled","disabled");
                    $("#recur").text("该敏感词已存在");
                }else{
                    $("#recur").text("");
                    $("#save").removeAttr("disabled");
                }
            },//响应成功后的回调函数
            error:function () {
                alert("出错啦...")
            },//表示如果请求响应出现错误，会执行的回调函数
            dataType:"json",//设置接受到的响应数据的格式
            traditional: true//传递数组时需要设定的属性
        })
    }
    function trim(str){ //删除左右两端的空格
       　　     return str.replace(/(^\s*)|(\s*$)/g, "");
    　 }
    $("#save").click(function () {
        $("#from").submit();
    })
</script>
</body>
</html>

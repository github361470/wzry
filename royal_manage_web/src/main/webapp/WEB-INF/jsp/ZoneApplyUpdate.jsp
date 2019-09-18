<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>当前模块详细页面</title>
</head>
<body>

<!-- /.当前模块详情页 -->
<div class="modal fade article-detail-modal" id="article_detail" tabindex="-1" role="dialog" aria-labelledby="article-detail-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">当前模块</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal article_detail_form" id="zoneForm">

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</body>
</html>

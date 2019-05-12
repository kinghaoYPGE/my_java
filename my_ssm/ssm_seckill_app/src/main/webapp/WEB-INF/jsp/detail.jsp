<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/header.jsp"%>
    <title>秒杀详情页</title>
</head>
<body>
<div class=""container>
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h1>${seckill.name}</h1>
        </div>
        <div class="panel-body text-center">
            <h2 class="text-danger">
                <span class="glyphicon glyphicon-time"></span>
                <!--倒计时-->
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>
<!--手机注册-->
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone">秒杀电话</span>
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey"
                               placeholder="请填写手机号码" class="form-control">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success btn-sm">
                    <span class="glyphicon glyphicon-phone">提交</span>
                </button>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>
<!--bootstrap CDN cookie插件-->
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!--bootstrap CDN countdown插件-->
<script src="https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>
<script src="/resources/script/seckill.js"></script>
<script type="text/javascript">
    $(function () {
        seckill.detail.init({
            seckillId : ${seckill.seckillId},
            startTime: ${seckill.startTime.time},
            endTime: ${seckill.endTime.time},
            number : ${seckill.number}
        });
    });
</script>
</body>
</html>

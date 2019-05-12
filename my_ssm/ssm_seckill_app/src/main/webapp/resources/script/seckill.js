var seckill = {
    // 封装前端异步请求地址
    URL : {
        now : function () {
            return '/seckill/now';
        },
        exposer : function (seckillId) {
            return '/seckill/' + seckillId + '/exposer';
        },
        execution : function (seckillId, md5) {
            return '/seckill/' + seckillId + '/' + md5 + '/execution';
        }
    },
    validatePhone : function(phone) {
      if(phone  && phone.length == 11 && !isNaN(phone)) {
          return true;
      }else{
          return false;
      }
    },
    handleSeckill : function (seckillId, node) {
        // 生成秒杀按钮并隐藏
        node.hide().html('<button class="btn btn-primary" id="killBtn">开始秒杀</button>');
        // 获取秒杀地址
        $.post(seckill.URL.exposer(seckillId), {}, function (result) {
            var exposer = result['data'];
            if(exposer && result['success']){
                var md5 = exposer['md5'];
                // 秒杀url
                var killUrl = seckill.URL.execution(seckillId, md5);
                // 给秒杀按钮绑定click事件，为了防止重复刷新，这里我们使用一次绑定
                $('#killBtn').one('click', function () {
                    // 1. 禁用按钮
                    $(this).addClass("disabled");
                    // 2. 发送秒杀请求
                    $.post(killUrl, {}, function (result) {
                        var killResult = result['data'];
                        var state = killResult['state'];
                        var stateInfo = killResult['stateInfo'];
                        // 3. 显示秒杀结果
                        node.html('<span class="label label-success">'+stateInfo+'</span>');
                    });
                });
                // 显示结果
                node.show();
            }else{
                var now = exposer['now'];
                var start = exposer['start'];
                var end = exposer['end'];
                seckill.countdown(seckillId, now, start, end);
            }
        });

    },
    countdown : function (seckillId, now, startTime, endTime) {
        var seckillBox = $("#seckill-box");
        if(now > endTime) {
            // 秒杀结束
            seckillBox.html('秒杀结束');
        }else if(now < startTime) {
            // 秒杀未开始, 进行计时
            var killTime = new Date(startTime + 1000); // 设置1秒延迟
            seckillBox.countdown(killTime, function (event) {
                var format = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
                seckillBox.html(format);
            }).on('finish.countdown', function () {
                // 执行秒杀
                seckill.handleSeckill(seckillId, seckillBox);
            });
        } else {
            // 执行秒杀
            seckill.handleSeckill(seckillId, seckillBox);
        }
    },

    // 秒杀详情页逻辑
    detail : {
        init : function(params) {
            // 判断用户手机是否登陆，和计时相关逻辑
            var killPhone = $.cookie('killPhone');
            if(!seckill.validatePhone(killPhone)){
                //绑定手机号码
                var killPhoneModal = $("#killPhoneModal");
                killPhoneModal.modal({
                    show : true,  // 显示手机弹框
                    backdrop : 'static', // 禁用位置关闭
                    keyboard : false // 关闭键盘事件
                });
                $("#killPhoneBtn").click(function () {
                    var inputPhone = $("#killPhoneKey").val();
                    if(seckill.validatePhone(inputPhone)) {
                        // 将手机号码存入cookie
                        // 此cookie只用于seckill模块
                        $.cookie('killPhone', inputPhone, {expires:7, path:'/seckill'});
                        // 刷新页面
                        window.location.reload();
                    } else {
                        // 手机号码错误提示
                        $("#killPhoneMessage").hide()
                            .html('<label class="label label-danger">手机号码错误</label>').show(300);
                    }
                });
            } else {
                // 进行计时
                $.get(seckill.URL.now(), {}, function (result) {
                    var startTime = params['startTime'];
                    var endTime = params['endTime'];
                    var seckillId = params['seckillId'];
                    var number = params['number'];
                    if(result && result['success']) {
                        var now = result['data'];
                        seckill.countdown(seckillId, now, startTime, endTime, number);
                    }else{
                        console.log("result: "+result);
                    }
                });
            }
        }
    }
};
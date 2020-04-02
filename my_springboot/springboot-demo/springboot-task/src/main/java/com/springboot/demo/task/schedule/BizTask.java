package com.springboot.demo.task.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BizTask {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(cron = "5/3 * * * * ? ")  /* cron生成网址：http://cron.qqe2.com/ */
    public void printTime() {
        System.out.println("当前时间：" + sdf.format(new Date()));
    }

}

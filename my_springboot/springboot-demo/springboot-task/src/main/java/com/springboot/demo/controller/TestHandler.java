package com.springboot.demo.controller;

import com.springboot.demo.task.async.AsyncBizTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/test")
public class TestHandler {

    @Autowired
    private AsyncBizTask asyncBizTask;

    @GetMapping("/async")
    public String asyncTask() throws Exception {
        long start = System.currentTimeMillis();
        Future<Boolean> t1 = asyncBizTask.doTask1();
        Future<Boolean> t2 = asyncBizTask.doTask2();
        Future<Boolean> t3 = asyncBizTask.doTask3();
        Future<Boolean> t4 = asyncBizTask.doTask4();
        t1.get();
        t2.get();
        t3.get();
        t4.get();
        long end = System.currentTimeMillis();
        String times = "任务完成，总耗时：" + (end-start)/1000 + "秒";
        return times;
    }

}

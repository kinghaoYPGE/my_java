package com.springboot.demo.task.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncBizTask {

    @Async
    public Future<Boolean> doTask1() throws Exception {
        return getBooleanFuture();
    }

    @Async
    public Future<Boolean> doTask2() throws Exception {
        return getBooleanFuture();
    }
    @Async
    public Future<Boolean> doTask3() throws Exception {
        return getBooleanFuture();
    }
    @Async
    public Future<Boolean> doTask4() throws Exception {
        return getBooleanFuture();
    }

    private Future<Boolean> getBooleanFuture() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " 任务耗时：" + (end-start));
        return new AsyncResult<>(true);
    }

}

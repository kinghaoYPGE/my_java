package com.springboot.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void fun1() {
        System.out.println("执行：com.springboot.demo.service.MyService.fun1");
    }

    public void fun2() {
        System.out.println("执行：com.springboot.demo.service.MyService.fun2");
    }

    public String fun3() {
        String message = "执行：com.springboot.demo.service.MyService.fun3";
        System.out.println(message);
        return message;
    }

    public void fun4() {
        System.out.println("执行：com.springboot.demo.service.MyService.fun4");
        int i = 1 / 0;
    }

}

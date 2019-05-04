package com.myspringboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class HelloController {
    // 读取自定义配置属性
    @Value("${demo.springboot}")
    private String demoSpringboot;

    @RequestMapping("hello")
    public String hello() {
        return "hello springboot!";
    }
    
    @RequestMapping("demo_springboot")
    public String demoSpringboot() {
        return demoSpringboot;
    }

}
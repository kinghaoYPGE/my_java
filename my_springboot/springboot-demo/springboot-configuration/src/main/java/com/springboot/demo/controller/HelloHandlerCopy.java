package com.springboot.demo.controller;

import com.springboot.demo.factory.config.MyConfig;
import com.springboot.demo.factory.config.MyConfigCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")
public class HelloHandlerCopy {

    @Autowired
    MyConfig myConfig;

    @Autowired
    MyConfigCopy myConfigCopy;

    @GetMapping("/config/way")
    public String way() {
        return "SpringBoot 当前使用的配置方式是：" + myConfig + " -> copy: " + myConfigCopy;
    }

}



package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloHandler {

    @Value("${config.way}")
    private String configWay;
    @Value("${config.name}")
    private String configName;
    @Value("${config.env}")
    private String configEnv;
    @Value("${my.way}")
    private String myConfigWay;
    @Value("${my.name}")
    private String myConfigName;

    @GetMapping("/config/way")
    public String way() {
        return "SpringBoot 当前使用的配置方式是：" + configWay + " -> " + configName + " -> " + configEnv +
                "; SpringBoot 当前使用的自定义配置是：" + myConfigWay + " -> " + myConfigName;
    }

}

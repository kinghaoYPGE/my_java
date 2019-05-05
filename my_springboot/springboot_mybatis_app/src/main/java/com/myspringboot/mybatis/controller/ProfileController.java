package com.myspringboot.mybatis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${env_name}")
    private String envName;


    @RequestMapping("profile")
    public String profile() {
        return envName;
    }
}
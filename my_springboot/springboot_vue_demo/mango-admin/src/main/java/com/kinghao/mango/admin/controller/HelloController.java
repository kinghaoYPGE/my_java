package com.kinghao.mango.admin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "This is SpringBoot Application Hello demo!";
    }

}

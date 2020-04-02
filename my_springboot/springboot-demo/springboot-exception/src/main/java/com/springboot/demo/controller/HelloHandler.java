package com.springboot.demo.controller;

import com.springboot.demo.exception.BizException;
import com.springboot.demo.util.ResultBody;
import com.springboot.demo.util.ResultEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloHandler {

    @GetMapping("/test")
    public String test() {
        int i = 1 / 0; // 制造异常
        return "hello";
    }

    @GetMapping("/test2")
    public String test2() {
        throw new BizException(ResultEnum.BODY_NOT_MATCH); // 制造异常
    }

    @GetMapping("/test3")
    public ResultBody test3() {
        return ResultBody.success("com.springboot.demo.controller.HelloHandler#test3");
    }

}

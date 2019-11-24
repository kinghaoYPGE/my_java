package com.myspringboot.ajax.controller;

import com.myspringboot.ajax.controller.entity.User;
import com.myspringboot.ajax.dto.ResultBean;
import org.springframework.web.bind.annotation.*;

/**
 * 前后端分离：后端应用
 *  目的：测试ajax请求跨域问题
 */
@RestController
@RequestMapping("/ajax")
//@CrossOrigin
public class TestController {

    @GetMapping("/get1")
    public ResultBean get1 () {
        System.out.println("TestController.get1()");
        return new ResultBean(200, "ok");
    }

    @PostMapping("/postJson")
    public ResultBean postJson(@RequestBody User user) {
        System.out.println("TestController.postJson()");
        return new ResultBean(200, user.getName());
    }

    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue("cookie1") String cookie1) {
        System.out.println("TestController.getCookie()");
        return new ResultBean(200, cookie1);
    }

    @GetMapping("/getHeader")
    public ResultBean getHeader(@RequestHeader("x-header1") String header1,
                                @RequestHeader("x-header2") String header2) {
        System.out.println("TestController.getHeader()");
        return new ResultBean(200, header1 + " " + header2);
    }

}

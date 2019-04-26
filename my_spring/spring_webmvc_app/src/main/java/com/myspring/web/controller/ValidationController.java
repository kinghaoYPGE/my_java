package com.myspring.web.controller;


import com.myspring.web.entity.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ValidationController {

    // 进入注册页面
    /*@RequestMapping(value = "/registerform")
    public String registerform(Model model) {
      model.addAttribute("customer", new Customer());
      return "register";
    }*/

    // 注册请求的响应方法
    @RequestMapping(value = "/register", method={RequestMethod.GET, RequestMethod.POST})
    public String register(@ModelAttribute("customer") Customer customer, Model model) {
      model.addAttribute("customer", customer);
      return "register";
    }
}
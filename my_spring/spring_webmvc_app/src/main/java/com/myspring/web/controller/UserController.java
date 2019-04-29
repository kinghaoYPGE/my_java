package com.myspring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.myspring.web.entity.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
  @RequestMapping(value="/register")
  //@RequestMapping(value="/register", method=RequestMethod.POST, consumes="application/json")
  /*public String register(User user, Model model) {
    model.addAttribute("user", user);
    return "success";
  }*/
  public ModelAndView register(User user, ModelAndView mv) {
    // 这里user可以直接绑定的原因是RequestHandler，前提是user的属性名要和请求数据名一致
    mv.addObject("user", user);
    mv.setViewName("success");
    return mv;
  }

  @RequestMapping(value="/index")
  public String login(/*@RequestParam("username")*/ String username, Model model) {
    model.addAttribute("username", username);
    return "index";
  }

  @RequestMapping(value="/get_username")
  @ResponseBody
  public String getUsername(String username) {
    return username;
  }

  @RequestMapping(value="/get_user/{userId}")
  @ResponseBody
  public String getUser(@PathVariable Integer userId) {
    return "current user id is " + (userId + 100);
  }

  @RequestMapping(value="/header")
  @ResponseBody
  public String header(@RequestHeader("Accept-Encoding") String encoding) {
    return "request header's encoding is " + encoding;
  }

  @RequestMapping(value="/cookie_test")
  @ResponseBody
  public String cookieTest(@CookieValue("JSESSIONID") String cookie) {
    return "the JSESSIONID is " + cookie;
  }

  // @SessionAttributes 用法

  // @ModelAttribute 用法

}
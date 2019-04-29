package com.myspring.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    // 登录
    @RequestMapping(value = "/login")
    public String login(HttpSession session, String username, String password,
            Model model) {
        // 判断用户名和密码是否正确
        if (username.equals("admin") && password.equals("123456")) {
            session.setAttribute("username", username);
            // 重定向到 test 请求
            return "redirect:index";
        } else {
            model.addAttribute("message", "wrong user name or password!");
            return "loginform";
        }
    }

    // 登出
    @RequestMapping(value = "/logout")
    public String loginout(HttpSession session) throws Exception {
        session.invalidate();
        return "loginform";
    }

    @RequestMapping(value = "/index")
    public String index() {
      return "success";
    }
}
package com.sso.a.controller;

import com.sso.a.constant.AppConstant;
import com.sso.a.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "/logout", produces = "application/json;charset=utf-8")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // 获取ticket
        String ticket = CookieUtil.getCookie(request, "ticket");
        // 请求sso-server登出
        boolean isLogout = restTemplate.getForObject(AppConstant.SSO_URL +
                "logout?ticket=" + ticket, Boolean.class);
        if (isLogout) {
            // 登出成功后，清除cookie
            CookieUtil.setCookie(response,"ticket","",0);
            return "用户已退出";
        }
        return "退出失败，请稍后再试";
    }
}

package com.springboot.demo.interceptor;

import com.springboot.demo.constant.AppConstant;
import com.springboot.demo.util.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @SuppressWarnings("Duplicates")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        String uuid = CookieUtil.getCookie(request, "uuid");
        // jessionid设置为初始uuid
        if (StringUtils.isEmpty(uuid)) {
            uuid = session.getId();
            CookieUtil.setCookie(response, "uuid", uuid, 3600);
        }
        // 1. cookie中获取ticket
        String ticket = CookieUtil.getCookie(request, "ticket");
        if (StringUtils.isEmpty(ticket)) {
            ticket = request.getParameter("ticket");
        }
        if (StringUtils.isEmpty(ticket)) {
            logger.debug("重定向到登陆页面");
            response.sendRedirect(AppConstant.SSO_URL + "loginPage?originUrl=" +
                    request.getRequestURL() + "&uuid=" + uuid);
            return false;
        }
        //2. 去sso服务器check获取到的ticket，这里可以用httpClient，我们采用restTemplate
        RestTemplate restTemplate = new RestTemplate();
        String t = restTemplate.getForObject(AppConstant.SSO_URL +
                "checkTicket?ticket=" + ticket + "&uuid" + uuid, String.class);
        if (null != t) {
            // ticket合法，获取到用户信息
            Map userInfo = restTemplate.getForObject(AppConstant.SSO_URL +
                    "getUserInfo?ticket=" + t, Map.class);
            logger.debug("ticket校验通过,当前用户为:" + userInfo);
            // 将userInfo存入session
            session.setAttribute("userInfo", userInfo);
            // 更新ticket
            CookieUtil.setCookie(response, "ticket", t, 60);
        } else {
            // ticket非法，重定向到登陆页面
            logger.debug("非法ticket, 重定向到登陆页面");
            response.sendRedirect(AppConstant.SSO_URL + "loginPage?originUrl=" +
                    request.getRequestURL() + "&uuid=" + uuid);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

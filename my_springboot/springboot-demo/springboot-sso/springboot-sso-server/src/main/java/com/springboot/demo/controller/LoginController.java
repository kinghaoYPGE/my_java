package com.springboot.demo.controller;

import com.springboot.demo.constant.AppConstant;
import com.springboot.demo.service.LoginService;
import com.springboot.demo.util.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final RedisTemplate<String, String> redisTemplate;
    private final LoginService loginService;

    /**
     * 使用构造器方式将redis和service自动注入
     * @param redisTemplate
     * @param loginService
     */
    @Autowired
    public LoginController(RedisTemplate<String, String> redisTemplate, LoginService loginService) {
        this.redisTemplate = redisTemplate;
        this.loginService = loginService;
    }

    /**
     * 跳转到登陆页面
     * @param originUrl:跳转之前的原url
     * @param uuid:客户端唯一标识
     * @param response
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage(String originUrl, String uuid, HttpServletResponse response) {
        CookieUtil.setCookie(response, "originUrl",
                originUrl, AppConstant.REDIS_TICKET_ACTIVE_SECONDS);
        logger.debug("originUrl:", originUrl);
        CookieUtil.setCookie(response, "uuid",
                uuid, AppConstant.REDIS_TICKET_ACTIVE_SECONDS);
        return "login";
    }

    /**
     * 登陆成功后，创建ticket
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public boolean login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        boolean loginSuccess = loginService.login(username, password);
        if (loginSuccess) {
            // 如果登陆成功，创建ticket存到redis并重定向到原url
            //1. 获取客户端uuid
            String uuid = CookieUtil.getCookie(request, "uuid");
            //2. 创建ticket
            String ticket = loginService.createTicket(uuid);
            //3. 将ticket作为键存入到redis，值为用户名，过期时间为60s
            redisTemplate.opsForValue().set(AppConstant.REDIS_TICKET_PREFIX+ticket, username,
                    AppConstant.REDIS_TICKET_ACTIVE_SECONDS, TimeUnit.SECONDS);
            //4. 重定向到原url并附加登陆凭证ticket
            String orginUrl = CookieUtil.getCookie(request, "originUrl")
                    + "?ticket=" + ticket;
            try {
                response.sendRedirect(orginUrl);
            } catch (IOException e) {
                logger.error(e.toString());
                throw new RuntimeException(e);
            }
        }
        return loginSuccess;
    }

    /**
     * 校验ticket是否合法
     * @param ticket
     * @param uuid
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkTicket")
    public String checkTicket(String ticket, String uuid) {
        //1. 获取存入redis的ticket值
        String oldTicketValue = redisTemplate.opsForValue().get(AppConstant.REDIS_TICKET_PREFIX + ticket);
        if (null != ticket && null != oldTicketValue) {
            if (AppConstant.ENABLE_DISPOSALBLE_TICKET) {
                // 重新生成ticket
                //1. 删除原来的ticket
                redisTemplate.delete(AppConstant.REDIS_TICKET_PREFIX + ticket);
                //2. 生成新的ticket
                String newTicket = loginService.createTicket(uuid);
                //3. 重新存入redis
                redisTemplate.opsForValue().set(AppConstant.REDIS_TICKET_PREFIX + ticket,
                        oldTicketValue, AppConstant.REDIS_TICKET_ACTIVE_SECONDS, TimeUnit.SECONDS);
                return newTicket;
            } else {
                return ticket;
            }

        } else {
            // ticket非法
            return null;
        }
    }

    /**
     * 通过ticket获取用户信息，这里简单使用map，一般采用pojo
     * @param ticket
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Map<String, String> getUserInfo(String ticket) {
        String username = redisTemplate.opsForValue().get(AppConstant.REDIS_TICKET_PREFIX + ticket);
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", username);
        userInfo.put("ticket", ticket);
        return userInfo;
    }

    @ResponseBody
    @RequestMapping("/logout")
    public boolean logout(String ticket) {
        redisTemplate.delete(AppConstant.REDIS_TICKET_PREFIX + ticket);
        return true;
    }


}

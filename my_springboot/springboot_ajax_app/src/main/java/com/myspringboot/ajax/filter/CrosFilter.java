package com.myspringboot.ajax.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过filter实现被调用方允许跨域
 * 如果使用spring框架，可以使用spring自带的@CrossOrigin注解
 */
public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String origin = req.getHeader("Origin");
        // 通过设置返回头信息允许跨域
        if (!StringUtils.isEmpty(origin)) {
            res.addHeader("Access-Control-Allow-Origin", origin);
        }
        res.addHeader("Access-Control-Allow-Methods", "*");
        // 解决非简单请求，如: application/json post请求, 带自定义头信息的请求等
//        res.addHeader("Access-Control-Allow-Headers", "Content-Type");
        String headers = req.getHeader("Access-Control-Request-Headers");
        if (!StringUtils.isEmpty(headers)) {
            res.addHeader("Access-Control-Allow-Headers", headers);
        }
        // 设置options请求缓存
        res.addHeader("Access-Control-Max-Age", "3600");
        // 解决调用方请求携带cookie
        res.addHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

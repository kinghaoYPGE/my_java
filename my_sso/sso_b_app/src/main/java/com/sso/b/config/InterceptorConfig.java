package com.sso.b.config;

import com.sso.b.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置登陆拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }
}

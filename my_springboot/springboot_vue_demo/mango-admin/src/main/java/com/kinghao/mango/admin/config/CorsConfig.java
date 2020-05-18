package com.kinghao.mango.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 先允许任意请求
        .allowedOrigins("*").allowedMethods("*")
                .maxAge(168000) // 预检查间隔时间
        .allowedHeaders("*").allowCredentials(true); // 允许发送cookie
    }
}

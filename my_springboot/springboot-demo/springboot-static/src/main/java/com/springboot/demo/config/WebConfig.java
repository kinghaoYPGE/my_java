package com.springboot.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 映射自定义静态资源访问路径 */
        registry.addResourceHandler(
                "/**",
                "/static/**"
        ).addResourceLocations(
                        "classpath:/static/",
                        "classpath:/upload/"
                );
    }
}

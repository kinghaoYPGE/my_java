package com.myspringboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@SpringBootApplication注解相当于同时使用@EnableAutoConfiguration、@ComponentScan、@Configurations三个注解  
//@EnableAutoConfiguration用于打开SpringBoot自动配置，而其余注解为Spring注解，这里不再赘述
@SpringBootApplication
public class SpringbootApplication {

    /*@Configuration
    static class WebConfig implements WebMvcConfigurer {

        //重写addResourceHandlers方法
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //设置静态资源映射路径为/**，资源位置为类路径下的upload
            registry.addResourceHandler("/**").addResourceLocations("classpath:/upload/");
        }
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.springboot.demo.web.servlet")
public class SpringBootDemo2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo2Application.class, args);
    }
}

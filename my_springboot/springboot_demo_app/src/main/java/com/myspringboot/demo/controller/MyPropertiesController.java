package com.myspringboot.demo.controller;

import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
@PropertySource(value="classpath:my.properties")
public class MyPropertiesController {
  @Value("${author}")
  private String author;

  @Value("${app_name}")
  private String appName;

  @RequestMapping("my_properties")
  public String MyProperties() {
    return appName + " created by " + author;
  }
}
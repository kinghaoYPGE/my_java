package com.myspring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean(name="animal")
  public IAnimal getAnimal() {
    return new Dog();
  }
}
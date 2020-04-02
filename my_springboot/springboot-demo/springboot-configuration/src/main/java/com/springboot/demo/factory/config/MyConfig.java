package com.springboot.demo.factory.config;

import com.springboot.demo.factory.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:my-config.yml"},
        factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "my")
public class MyConfig/* implements InitializingBean */{
    private String way;
    private String name;

}
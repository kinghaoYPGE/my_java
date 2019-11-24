package com.myspringboot.ajax;

import com.myspringboot.ajax.filter.CrosFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringbootApplication {
    public static void main( String[] args ) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

//    @Bean
//    public FilterRegistrationBean registerFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.addUrlPatterns("/*");
//        bean.setFilter(new CrosFilter());
//        return bean;
//    }
}

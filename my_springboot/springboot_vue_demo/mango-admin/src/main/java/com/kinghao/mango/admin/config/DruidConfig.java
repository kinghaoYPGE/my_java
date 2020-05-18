package com.kinghao.mango.admin.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {

    /**
     * druid页面登录页面
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        registrationBean.addInitParameter("allow", "192.168.0.103");// IP白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("deny", "");// IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "admin");
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }

}

package com.springboot.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    /* 主数据源 */
    @Bean
    @ConfigurationProperties(prefix = "app.datasource.first")
    @Primary
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Primary
    @Bean
    public DataSource firstDataSource() {
        return firstDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    /* 其他数据源 */
    @Bean
    @ConfigurationProperties(prefix = "app.datasource.other")
    public DataSourceProperties otherDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    public DataSource otherDataSource() {
        return otherDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}

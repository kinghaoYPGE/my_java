package com.kinghao.mango.admin.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * ORM映射配置
 */
@Configuration
@MapperScan(basePackages = {"com.kinghao.mango.**.dao"})
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sessionFactoryBean.setDataSource(dataSource);
        // 设置别名路径
        sessionFactoryBean.setTypeAliasesPackage("com.kinghao.mango.**.model");
        // 设置映射文件路径
        PathMatchingResourcePatternResolver resolver =
                new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setMapperLocations(
                resolver.getResources("classpath*:**/sqlmap/*.xml"));
        return sessionFactoryBean.getObject();

    }

}

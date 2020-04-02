package com.springboot.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.springboot.demo.repository.first"},
        entityManagerFactoryRef = "entityManagerFactoryFirst",
        transactionManagerRef = "transactionManagerFirst"
)
public class FirstDataSourceConfig {

    private final DataSource firstDataSource;

    @Autowired
    public FirstDataSourceConfig(@Qualifier("firstDataSource") DataSource firstDataSource) {
        this.firstDataSource = firstDataSource;
    }

    /**
     * 配置entityManager工厂
     */
    @Primary
    @Bean(name = "entityManagerFactoryFirst")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFirst(EntityManagerFactoryBuilder builder) {
        return builder
                //设置数据源
                .dataSource(firstDataSource)
                //设置entity的包路径
                .packages("com.springboot.demo.entity.first")
                .build();
    }

    /**
     * 配置事务管理器
     */
    @Primary
    @Bean(name = "transactionManagerFirst")
    public PlatformTransactionManager transactionManagerFirst(EntityManagerFactoryBuilder builder) {
        //返回jpa事务管理器
        return new JpaTransactionManager(entityManagerFactoryFirst(builder).getObject());
    }

}

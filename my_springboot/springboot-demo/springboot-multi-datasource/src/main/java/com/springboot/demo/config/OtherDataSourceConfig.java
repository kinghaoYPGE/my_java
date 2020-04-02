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
        basePackages = {"com.springboot.demo.repository.other"},
        entityManagerFactoryRef = "entityManagerFactoryOther",
        transactionManagerRef = "transactionManagerOther"
)
public class OtherDataSourceConfig {

    private final DataSource otherDataSource;

    @Autowired
    public OtherDataSourceConfig(@Qualifier("otherDataSource") DataSource otherDataSource) {
        this.otherDataSource = otherDataSource;
    }

    /**
     * 配置entityManager工厂
     */
    @Bean(name = "entityManagerFactoryOther")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOther(EntityManagerFactoryBuilder builder) {
        return builder
                //设置数据源
                .dataSource(otherDataSource)
                //设置entity的包路径
                .packages("com.springboot.demo.entity.other")
                .build();
    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManagerOther")
    public PlatformTransactionManager transactionManagerOther(EntityManagerFactoryBuilder builder) {
        //返回jpa事务管理器
        return new JpaTransactionManager(entityManagerFactoryOther(builder).getObject());
    }

}

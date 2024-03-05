package com.example.encoreSpring.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
/* 
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/*
@Component : 객체생성과 라이프사이클 관리를 spring container에 위임
Inversion Of Control (IOC) : 제어의 역행
-- IOC (Dependency Injection(DI), Dependency Lookup(DL)
-- @Controller
-- @Service
-- @Repository
-- @Bean
환경설정에 관련된 객체
-- @Configuration

Dependency Injection 관련 어노테이션
spring container(ApplicationContext) 관리하는 객체를 가지다 쓸 수 있다.
-- Autowired
-- Injection
-- Resource
-- Qualified
*/

@PropertySource("classpath:/application.properties")
@Configuration
public class MariadbConfig {


    @Autowired
    private ApplicationContext context;

    @Bean   
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        return config;
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource());
        // Mapper 관련 추가작업 필요
        factory.setMapperLocations(context.getResources("classpath:/mapper/BoardMapper.xml"));
        factory.setConfiguration(myconfiguration());
        return factory.getObject();
    }

    @Bean("encore")
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration myconfiguration(){
        return new org.apache.ibatis.session.Configuration();
    }
}
package com.example.framework.repository;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ExampleMybatisRepository {
	
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariConfig hikariConfig() {

        return new HikariConfig();
    }

	@Bean(name = "mybatisDataSource")
    public DataSource dataSource() throws Exception {
        DataSource dataSource = new HikariDataSource(hikariConfig());
        return dataSource;
    }
	
	@Bean(name="mybatisSqlSessionFactory")
	public SqlSessionFactory mybatisSqlSessionFactory(@Qualifier("mybatisDataSource") DataSource mybatisDataSource, ApplicationContext applicationContext) throws Exception{

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(mybatisDataSource);
		
		sqlSessionFactoryBean.setTypeAliasesPackage("com.example.cyo.domain"); 
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/mybatis/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="mybatisSqlSessionTemplate")
	public SqlSessionTemplate mybatisSqlSessionTemplate(SqlSessionFactory mybatisSqlSessionFactory) throws Exception{
		return new SqlSessionTemplate(mybatisSqlSessionFactory);
	}

}

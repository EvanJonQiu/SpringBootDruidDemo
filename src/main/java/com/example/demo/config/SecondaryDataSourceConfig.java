package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
public class SecondaryDataSourceConfig {

	@Bean(name = "secondaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.secondary")
	public DataSource dataSource(){
	    return DruidDataSourceBuilder.create().build();
	}
	
	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}

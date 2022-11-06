package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
public class PrimaryDataSourceConfig {

	@Primary
	@Bean(name = "primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.primary")
	public DataSource dataSource(){
	    return DruidDataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name = "primaryJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}

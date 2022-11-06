package com.example.demo.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = SecondaryJpaConfig.REPOSITORY_PACKAGE,
		entityManagerFactoryRef = "secondaryEntityManagerFactory",
		transactionManagerRef = "secondaryTransactionManager")
public class SecondaryJpaConfig {

	public static final String REPOSITORY_PACKAGE = "com.example.demo.repository.secondary";
	private static final String ENTITY_PACKAGE = "com.example.demo.model.secondary";
	
	@Bean(name = "secondaryJpaProperties")
	@ConfigurationProperties(prefix = "spring.jpa.secondary")
	public JpaProperties jpaProperties() {
		return new JpaProperties();
	}
	
	@Bean(name = "secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
			@Qualifier("secondaryDataSource") DataSource primaryDataSource,
			@Qualifier("secondaryJpaProperties") JpaProperties jpaProperties,
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(primaryDataSource)
				.properties(jpaProperties.getProperties())
				.packages(ENTITY_PACKAGE)
				.persistenceUnit("secondaryPersistenceUnit").build();
	}
	
	@Bean(name = "secondaryEntityManager")
	public EntityManager entityManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory factory) {
		return factory.createEntityManager();
	}
	
	@Bean(name = "secondaryTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}

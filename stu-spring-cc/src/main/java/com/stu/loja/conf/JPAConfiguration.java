package com.stu.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@EnableTransactionManagement
public class JPAConfiguration {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		factoryBean.setJpaVendorAdapter(vendorAdapter);

		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("casalafite2013");
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/loja");

		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.use_sql_comments", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		properties.setProperty("hibernate.connection.provider_class", "com.zaxxer.hikari.hibernate.HikariConnectionProvider");
		properties.setProperty("hibernate.hikari.minimumIdle", "5");
		properties.setProperty("hibernate.hikari.maximumPoolSize", "10");
		properties.setProperty("hibernate.hikari.idleTimeout", "30000");

		properties.setProperty("hibernate.hikari.dataSourceClassName", "org.postgresql.Driver");
		properties.setProperty("hibernate.hikari.dataSource.url", "jdbc:postgresql://localhost:5432/loja");
		properties.setProperty("hibernate.hikari.dataSource.user", "postgres");
		properties.setProperty("hibernate.hikari.dataSource.password", "casalafite2013");
		properties.setProperty("hibernate.hikari.HikariConfig", "DEBUG");
		properties.setProperty("hibernate.hikari.dataSource.password", "TRACE");

		dataSource.setDataSourceProperties(properties);
		/*
		 * properties.setProperty("hibernate.connection.provider_class",
		 * "org.hibernate.c3p0.internal.C3P0ConnectionProvider");
		 * properties.setProperty("hibernate.c3p0.idle_test_period", "30");
		 * properties.setProperty("hibernate.c3p0.maxIdleTime", "30");
		 * properties.setProperty("hibernate.c3p0.idleConnectionTestPeriod", "10");
		 * properties.setProperty("hibernate.c3p0.acquireRetryAttempts", "5");
		 * properties.setProperty("hibernate.c3p0.acquireRetryDelay", "10");
		 * properties.setProperty("hibernate.c3p0.acquireIncrement", "1");
		 * properties.setProperty("hibernate.c3p0.maxIdleTime", "10");
		 * 
		 * properties.setProperty("hibernate.c3p0.initialPoolSize", "5");
		 * properties.setProperty("hibernate.c3p0.minPoolSize", "1");
		 * properties.setProperty("hibernate.c3p0.maxPoolSize", "20");
		 * properties.setProperty("hibernate.c3p0.checkoutTimeout", "30000");
		 * properties.setProperty("hibernate.c3p0.idleConnectionTestPeriod", "30");
		 */
		factoryBean.setJpaProperties(properties);
		factoryBean.setPackagesToScan("com.stu.loja.model");
		factoryBean.setDataSource(dataSource);
		return factoryBean;

	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);

	}
}

package com.stu.loja.conf;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@EnableTransactionManagement
public class JpaConfig extends HikariConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		HikariConfig config = new HikariConfig("/hikari/hikari.properties");

		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.use_sql_comments", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.connection.provider_class", "com.zaxxer.hikari.hibernate.HikariConnectionProvider");
		config.setJdbcUrl("jdbc:postgresql://localhost:5432/loja");

		config.setDataSourceProperties(properties);
		// factoryBean.setJpaProperties(properties);

		HikariDataSource dataSource = new HikariDataSource(config);
		factoryBean.setPackagesToScan("com.stu.loja.model");
		factoryBean.setDataSource(dataSource);
		return factoryBean;
	}
}

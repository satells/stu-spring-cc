package com.stu.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//SELECT * FROM pg_stat_activity;

@EnableTransactionManagement
public class JPAConfiguration {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		HikariConfig configHikari = new HikariConfig();
		configHikari.setUsername("postgres");
		configHikari.setPassword("casalafite2013");
		configHikari.setJdbcUrl("jdbc:postgresql://localhost:5432/loja");
		configHikari.setDriverClassName("org.postgresql.Driver");
		configHikari.addDataSourceProperty("cachePrepStmts", "true");
		configHikari.addDataSourceProperty("prepStmtCacheSize", "250");
		configHikari.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		configHikari.addDataSourceProperty("autoCommit", "false");

		HikariDataSource dataSource = new HikariDataSource(configHikari);

		factoryBean.setJpaVendorAdapter(vendorAdapter);

		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		properties.setProperty("hibernate.generate_statistics ", "true");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "false");
		properties.setProperty("hibernate.use_sql_comments", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		factoryBean.setPackagesToScan("com.stu.loja.model");
		factoryBean.setJpaProperties(properties);
		factoryBean.setDataSource(dataSource);

		return factoryBean;

	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);

	}
}

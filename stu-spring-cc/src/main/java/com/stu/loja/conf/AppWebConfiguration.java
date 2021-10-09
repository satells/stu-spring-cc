package com.stu.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.stu.loja.controllers.HomeController;
import com.stu.loja.dao.ProdutoDao;

@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDao.class })
public class AppWebConfiguration {
	@Bean
	public InternalResourceViewResolver InternalResourceViewResolver() {
		org.springframework.web.servlet.view.InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;

	}

}

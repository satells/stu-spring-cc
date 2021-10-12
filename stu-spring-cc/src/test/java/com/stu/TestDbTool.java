package com.stu;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import com.stu.loja.conf.JPAConfiguration;
import com.stu.loja.conf.SevletSpringMVC;
import com.stu.loja.model.Produto;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { JPAConfiguration.class, SevletSpringMVC.class })

public class TestDbTool {

	@PersistenceContext
	private EntityManager manager;

	private static final int MAX_ITERATIONS = 1000;
	private ConsoleReporter logReporter;
	private Timer timer;

	@Before
	public void init() {
		MetricRegistry metricRegistry = new MetricRegistry();
		this.logReporter = ConsoleReporter.forRegistry(metricRegistry).build();
		logReporter.start(1, TimeUnit.MINUTES);
		timer = metricRegistry.timer("connection");
	}

	@Test
	@Transactional
	public void testOpenCloseConnections() throws SQLException {
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			Context context = timer.time();

			Produto produto = new Produto();
			produto.setDescricao("fdasfd");
			produto.setTitulo("fdasfd");
			produto.setPaginas("150");

			manager.persist(produto);

			context.stop();
		}
		logReporter.report();
	}
}

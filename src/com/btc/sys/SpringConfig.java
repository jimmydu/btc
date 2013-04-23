package com.btc.sys;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

/**
 * 
 * @author jimmy.du Mar 31, 2013
 */

@Configuration
public class SpringConfig {

	@Bean(name = "sessionFactory")
	public SessionFactory configSessionFactory() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.connection.datasource",
				"java:/comp/env/db/mysql");
		// hibernateProperties.setProperty("", "");

		org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
		cfg.setProperties(hibernateProperties);
		cfg.addAnnotatedClass(com.btc.trade.entity.Trade.class);
		cfg.addAnnotatedClass(com.btc.trade.entity.User.class);
		return cfg.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager configTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(configSessionFactory());
		return hibernateTransactionManager;
	}

}

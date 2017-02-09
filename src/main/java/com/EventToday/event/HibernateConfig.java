package com.EventToday.event;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


@Configuration
//@EnableJpaRepositories(basePackages = "com.EventTodays.events.dao")
public class HibernateConfig {

	    @Bean
	    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
	         HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
	         factory.setEntityManagerFactory(emf);
	         return factory;
	    }
		
		
}

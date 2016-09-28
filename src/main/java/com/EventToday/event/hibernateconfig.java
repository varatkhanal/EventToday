package com.EventToday.event;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.EventToday.event" })
@PropertySource(value = { "classpath:application.properties" })
public class hibernateconfig {

	    @Autowired
	    private Environment environment;

	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.EventToday.event.model" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
		
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
	        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
	        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
	        return dataSource;
	    }
	    
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("spring.jpa.properties.hibernate.dialect", environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
	        properties.put("spring.jpa.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));
	        properties.put("spring.jpa.properties.hibernate.format_sql", environment.getRequiredProperty("spring.jpa.properties.hibernate.format_sql"));
	        return properties;        
	    }
	    
		@Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }
		
		
}

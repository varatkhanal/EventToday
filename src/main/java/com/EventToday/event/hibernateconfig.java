package com.EventToday.event;


import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.EventToday.event.repository")
@ComponentScan({ "com.EventToday.event" })
@PropertySource(value = { "classpath:application.properties" })
public class hibernateconfig {

	    @Autowired
	    private Environment environment;

	    @Bean
	    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
	    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        vendorAdapter.setDatabase(Database.MYSQL);
	        //vendorAdapter.setGenerateDdl(generateDDL);
	        vendorAdapter.setShowSql(true);
	        
	    	LocalContainerEntityManagerFactoryBean beanFactory = new LocalContainerEntityManagerFactoryBean();
	    	beanFactory.setJpaVendorAdapter(vendorAdapter);

	    	beanFactory.setPackagesToScan("com.EventToday.event.model");

	    	beanFactory.setDataSource(dataSource());

	    	//beanFactory.afterPropertiesSet();
	        beanFactory.setJpaProperties(hibernateProperties());
	    	
	        return beanFactory;
	     }
	    
	    /*@Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.EventToday.event.model" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }*/
		
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
	        dataSource.setSchema(environment.getRequiredProperty("spring.datasource.schema"));
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
	    public EntityManagerFactory entityManagerFactory(){
	        return localContainerEntityManagerFactoryBean().getObject();
	    }


		@Bean
	    public EntityManager entityManager(){
	        return entityManagerFactory().createEntityManager();
	    }

	    @Bean
	    PlatformTransactionManager transactionManager(){
	        JpaTransactionManager manager = new JpaTransactionManager();
	        manager.setEntityManagerFactory(entityManagerFactory());
	        return manager;
	    }

	    @Bean
	    public HibernateExceptionTranslator hibernateExceptionTranslator(){
	        return  new HibernateExceptionTranslator();
	    }
	    
	    /*@Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }*/
		
		
}

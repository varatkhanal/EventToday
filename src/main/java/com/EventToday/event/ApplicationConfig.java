package com.EventToday.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;  

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext; 
    }
    		
		    @Bean
		    public ViewResolver getViewResolver() {
		        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		        resolver.setPrefix("/WEB-INF/pages/");
		        resolver.setSuffix(".jsp");
		        return resolver;
		    }
			
			@Override
	        public void addResourceHandlers(ResourceHandlerRegistry registry) {
	                registry.addResourceHandler("/resources/**")
	                        .addResourceLocations("/resources/");
	        }

		     
		    
			@Bean
			public MessageSource messageSource() {
			    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			    messageSource.setBasename("messages");
			    return messageSource;
			}
			
			@Bean
			public javax.validation.Validator localValidatorFactoryBean() {
			   return new LocalValidatorFactoryBean();
			}
			
}

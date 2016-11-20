package com.EventToday.event;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.EventToday.event")
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig extends WebMvcConfigurerAdapter{
	
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
		
		    @Override
		    public void configureDefaultServletHandling(
		            DefaultServletHandlerConfigurer configurer) {
		        	configurer.enable();
		    } 
			
			@Bean
			public MessageSource messageSource() {
			    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			    messageSource.setBasename("messages");
			    return messageSource;
			}
			
}

package com.trungtamjava.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.trungtamjava.model.Order;
import com.trungtamjava.model.Person;

//@Configuration Đây là class cấu hình, tương đương với file spring-servlet.xml
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.trungtamjava")
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter{
	//Tạo Bean
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean(name="personA")
	public Person getPersonA() {
		return new Person();
	}
	
	@Bean(name="personB")
	public Person getPersonB() {
		Person p = new Person();
		p.setAge(24);
		return p;
	}
	
	@Bean
	public Order getOrder() {

		Order order = new Order();
		order.setCustomer(getPersonB());
		return order;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("rs/**").addResourceLocations("/static/");
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames("classpath:message-vi", "classpath:message-en");
		resourceBundleMessageSource.setDefaultEncoding("UTF-8");
		return resourceBundleMessageSource;
	}
}

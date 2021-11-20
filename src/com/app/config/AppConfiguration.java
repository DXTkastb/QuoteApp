package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(value="com.app")
public class AppConfiguration implements WebMvcConfigurer{
	
	
	@Bean
	public ViewResolver viewresolverbean() {
		
		UrlBasedViewResolver urlbasedviewresolver=new UrlBasedViewResolver();
		
		
		urlbasedviewresolver.setViewClass(JstlView.class);
		urlbasedviewresolver.setPrefix("WEB-INF/views");
		urlbasedviewresolver.setSuffix(".jsp");
				
		return urlbasedviewresolver;
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("homepage");
	}
	
	
	
	

}

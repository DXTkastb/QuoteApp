package com.app.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.app.config.AppConfiguration;

public class WebInit implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext context) throws ServletException{
		
		
		
		
		AnnotationConfigWebApplicationContext appcontext=new AnnotationConfigWebApplicationContext();
		appcontext.register(AppConfiguration.class);
		
		ServletRegistration.Dynamic dynamic=context.addServlet("dispatcher",new DispatcherServlet(appcontext));
	
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
		
		
		
	}

}

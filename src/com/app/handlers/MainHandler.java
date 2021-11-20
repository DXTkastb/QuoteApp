package com.app.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import java.net.*;

@RequestMapping("/")
@Controller
public class MainHandler {
	
	
	@Autowired
	private RestTemplate restemplate;
	
	public static final URI uRI;
	public static final String PHOTO_APIKEY="563492ad6f917000010000013e5ebb7c91fa4c36a68477a4627c35c0";
	public static final String FONT_API="AIzaSyCHg0vrZ4OVk8YT6QQHtz4xuphUjW8ZhOY";
	
	
	static
	{ 
		
		URI u=null;
		
		try{
			u=new URI("https://animechan.vercel.app/api/random");;
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		uRI=u;
		
	}
	
	
	@GetMapping(value="/getquote")
	public ModelAndView handlerMethod1() {
		
		ModelAndView modelview=new ModelAndView();
		
		ResponseEntity<String> response=getQuote();
		modelview.setStatus(response.getStatusCode());
				
		if(response.getStatusCode().compareTo(HttpStatus.OK)==0) {
			modelview.setViewName("quote");
			modelview.addObject("quote_string",response.getBody());
		}
		else
			modelview.setViewName("noquote");
			
			return modelview;
		
	}
	
	private ResponseEntity<String> getQuote() {
		ResponseEntity<String> response=null;
	
		response=restemplate.getForEntity(uRI,String.class);

		return response;
	}
	
	
	

	
	
	
}

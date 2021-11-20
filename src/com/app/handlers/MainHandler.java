package com.app.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.app.quote.Quote;

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
		
		ResponseEntity<Quote> response=getQuote();
		
		
		if(response.getStatusCode().compareTo(HttpStatus.OK)==0) {
			modelview.setStatus(response.getStatusCode());
			modelview.setViewName("quote");
			modelview.addObject("quote_string",response.getBody().getQuote());
			modelview.addObject("quote_character",response.getBody().getCharacter());

		}
		else
			modelview.setViewName("noquote");
			
			return modelview;
		
	}
	
	private ResponseEntity<Quote> getQuote() {
		ResponseEntity<Quote> response=null;
	
		
		try
		{
		response=restemplate.getForEntity(uRI,Quote.class);
		
		
		}
		catch(Exception e) {
			
			response=new ResponseEntity(HttpStatus.NOT_FOUND);
			
		}
		return response;
	}
	
	
	

	
	
	
}

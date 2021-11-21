package com.app.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.app.quote.Quote;

import java.net.*;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/")
@Controller
public class MainHandler {
	
	@Autowired
	private RestTemplate restemplate;
	
	public static final int[] ary= {1,2,3,4,5};
	public static final URI uRI;
	
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
	public ModelAndView handlerMethod1(HttpServletRequest request) {
		
		ModelAndView modelview=new ModelAndView();
		
		ResponseEntity<Quote> response = getQuote();
		
		int x = new Random().nextInt(ary.length);
		String moreLink= request.getContextPath()+"/resources/p"+x+".jpg";


		if (response.getStatusCode().compareTo(HttpStatus.OK) == 0) {
			modelview.setStatus(response.getStatusCode());
			modelview.setViewName("quote");
			modelview.addObject("quote_string", response.getBody().getQuote());
			modelview.addObject("quote_character", response.getBody().getCharacter());
			modelview.addObject("getmore_link",moreLink);
		} else
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

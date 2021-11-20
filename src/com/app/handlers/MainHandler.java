package com.app.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class MainHandler {
	

	
	@GetMapping(value="getquote")
	public ModelAndView handlerMethod1() {
		
		ModelAndView modelview=new ModelAndView();
		
		modelview.setViewName("qoute");
		
		
		
		return modelview;
		
		
	}
	
	

}

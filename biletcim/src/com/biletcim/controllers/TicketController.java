package com.biletcim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TicketController {

	
	@RequestMapping(value = ("/bilet"),method=RequestMethod.GET)
	public ModelAndView TicketPage(ModelAndView  model) {
		
		model.setViewName("TicketPage");
        return model;
		
	}
	
}

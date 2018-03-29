package com.biletcim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.entities.Company;
import com.biletcim.entities.Ticket;

@RequestMapping(value={"/BuyTicket", "/Buy","/Buyticket"})

@Controller
public class BuyTicketController {

	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getTickets(
			ModelAndView  model,
			Model modelVM) {
		Ticket bilet = new Ticket(
				10,
				"a5253",
				"03:00",
				"04:15",
				"1 Saat 0 Dakika",
				"HP2025",
				"big",
				"Ýstanbul SAW",
				"Ankara ESB",
				76.99,
				new Company(1, "Türk Hava Yollarý", "turkhavayollarilogo.png"));
		
		model.addObject("biletim",bilet);
				model.setViewName("BuyTicket");
				return model;
		
	
	}
}

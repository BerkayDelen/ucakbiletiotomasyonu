package com.biletcim.controllers;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.configs.Config;
import com.biletcim.entities.Login_User;
import com.biletcim.entities.Port;
import com.biletcim.entities.Ticket;
import com.biletcim.helpers.WebUtils;
import com.biletcim.services.PortService;
import com.biletcim.services.TicketService;



@RequestMapping(value={"/", "/AnaSayfa"})
@Controller
public class HomeController {
	
	@Autowired
	private PortService portService;
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value = (""),method=RequestMethod.GET)
	public ModelAndView Index(ModelAndView  model) {
		 System.out.println("Index Page");
		
		List<Port> Ports = new ArrayList<Port>();
		List<Ticket> Tickets = new ArrayList<Ticket>();

		Tickets = ticketService.getMostPopularTicket();
		System.out.println("TicketSize:->"+Tickets.size());
		Ports=portService.getPorts();
		model.addObject("Ports", Ports);
		model.addObject("Tickets", Tickets);
		model.addObject("trys", "deneme");
        model.setViewName("mainPage");
		return model;
				
				
		
	}
}

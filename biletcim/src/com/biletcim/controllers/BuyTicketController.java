package com.biletcim.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Company;
import com.biletcim.entities.Login_User;
import com.biletcim.entities.Ticket;
import com.biletcim.helpers.WebUtils;
import com.biletcim.services.TicketService;

@RequestMapping(value={"/BuyTicket", "/Buy","/Buyticket"})

@Controller
public class BuyTicketController {
	
	@Autowired
	private TicketService ticketService;

	
	@RequestMapping(value = ("/{ticketNumber}"),method=RequestMethod.GET)
	public ModelAndView getTickets(
			@PathVariable(value="ticketNumber") String ticketNumber,
			ModelAndView  model,
			Model modelVM) {
		System.out.println("Bilet Numarasý : "+ticketNumber);
		
		
		
		Ticket bilet = ticketService.getLastTicketByTicketNumber(ticketNumber);
		
		/*Ticket bilet = new Ticket(
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
		*/
	    
	   
		model.addObject("biletim",bilet);
				model.setViewName("BuyTicket");
				return model;
		
	
	}
	
	@RequestMapping(value = ("/{ticketNumber}"),method=RequestMethod.POST)
	public ModelAndView buyTicket(
			@PathVariable(value="ticketNumber") String ticketNumber,
			ModelAndView  model,
			Model modelVM,
			HttpServletRequest request) {
		
		Ticket bilet = ticketService.getLastTicketByTicketNumber(ticketNumber);
		
		/*Ticket bilet = new Ticket(
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
				new Company(1, "Türk Hava Yollarý", "turkhavayollarilogo.png"));*/
		
		
		System.out.println("POST: ticketNumber "+ ticketNumber);
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String tcNo = request.getParameter("tcNo");
		String bdate = request.getParameter("bdate");
		String Email = request.getParameter("Email");
		String optradio = request.getParameter("optradio");
		String Cinsiyet = request.getParameter("optradio");
		
		String Cardnumber = request.getParameter("Cardnumber");
		String Cardname = request.getParameter("Cardname");
		String Cardexpiry = request.getParameter("Cardexpiry");
		String Cardcvc = request.getParameter("Cardcvc");
		
		
		
		System.out.println("name : "+name);
		System.out.println("surname : "+surname);
		System.out.println("tcNo : "+tcNo);
		System.out.println("bdate : "+bdate);
		System.out.println("Email : "+Email);
		System.out.println("optradio : "+optradio);
		System.out.println("Cardnumber : "+Cardnumber);
		System.out.println("Cardname : "+Cardname);
		System.out.println("Cardexpiry : "+Cardexpiry);
		System.out.println("Cardcvc : "+Cardcvc);
		System.out.println("Cinsiyet : "+Cinsiyet);
		
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd"); 
		  Date date1 = null;
		try {
			date1 = formatter1.parse(bdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	    
		BuyTicket buyTicket = new BuyTicket();
		buyTicket.setAmount(bilet.getFiyat());
		buyTicket.setTicket_id(bilet.getTicketID());
		buyTicket.setUser_ticket_Name(name);
		buyTicket.setUser_ticket_Surname(surname);
		buyTicket.setUser_isLogin(true);
		
		buyTicket.setUser_ticket_Birthday(date1);
		buyTicket.setUser_ticket_Email(Email);
		
		buyTicket.setUser_ticket_gender(true);//düzenlt
		buyTicket.setUser_ticket_TC(tcNo);
		
		ticketService.AddBuyTicket(buyTicket);
		
		WebUtils utils = new WebUtils();
		  utils.MailSender(bilet,"Berkay Delen",Email);
		
		model.addObject("biletim",bilet);
				model.setViewName("BuyTicket");
				return model;
		
	
	}
	
	
	
	@RequestMapping(value = ("/test"),method=RequestMethod.GET)
	public ModelAndView saveBuyTicket(
			ModelAndView  model,
			Model modelVM) {
		
			BuyTicket buyTicket = new BuyTicket();
	    
	  
	    modelVM.addAttribute("buyTicket", buyTicket);
	    Login_User login = new Login_User();
		model.addObject("login", buyTicket);
		model.setViewName("api");
		 return model;
	
	}
	
	
}

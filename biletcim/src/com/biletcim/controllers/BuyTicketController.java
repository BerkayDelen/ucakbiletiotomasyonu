package com.biletcim.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.configs.Config;
import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Company;
import com.biletcim.entities.Login_User;
import com.biletcim.entities.Ticket;
import com.biletcim.entities.User;
import com.biletcim.helpers.WebUtils;
import com.biletcim.services.TicketService;
import com.biletcim.services.UserService;

@RequestMapping(value={"/BuyTicket", "/Buy","/Buyticket"})

@Controller
public class BuyTicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;

	
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
			HttpServletRequest request,
			HttpSession session) {
		
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
		WebUtils utils = new WebUtils();
		
		User user = null;
		String contextPath = request.getContextPath();
	    String Cookie_ID = "";
	     
	     Cookie[] cookies = request.getCookies();
			
			for (Cookie c : cookies) {
				//Cookie_ID = c.getValue();
				System.out.println(c.getName() + "=" + c.getValue());
				/*if(c.getName().equals("Login_ID")){
					Cookie_ID = c.getValue();
					System.out.println(c.getName() + "=" + c.getValue());
					break;
				}*/
				
				}
			
			if(!Cookie_ID.equals("")){
				String getCookies = "Select count(*) as count from users  Inner JOIN logincookies  ON users.Id = logincookies.loginCookie_User_ID where loginCookie_Key = ?";
				
				try {
					Config.OpenDB(getCookies);
				
					Config.stmt.setString(1,Cookie_ID);
				ResultSet rs =	Config.stmt.executeQuery();
					while(rs.next()){
						int action  = rs.getInt("count");
						try{
							if(action >= 1){
		    			    	//islogin
								
								user =  userService.User(session.getAttribute("Login_Session").toString());
		    			    	System.out.println("User Id ->"+user.getId());
		    			    	System.out.println("User Id ->"+user.getName());
		    			    	System.out.println("User Id ->"+user.getSurname());
		    			    	System.out.println("User Id ->"+user.getEmail());
		    			    	System.out.println("User Id ->"+user.getUniqID());
		    			    	
								System.out.println("Kullanýcý Login Olmuþ ve var ");
								
		    			     }else{
		    					//nlogin
		    			    	 System.out.println("USer Not FOund ");
		    				}
			    			    		
			    		}
			    		catch (Exception e){
			    			System.err.println("HATA:"+e.getMessage());
			    		}
		   
					}
					rs.close();
			
					Config.CloseDB();




				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
			}else if(session.getAttribute("Login_Session") !=null){
				
				String getSession = "Select count(*) as count from users  where User_UniqID = ?";
				
				try {
					
	        			//out.println(session.getAttribute("Login_Session"));
					Config.OpenDB(getSession);
				
					Config.stmt.setString(1,session.getAttribute("Login_Session").toString());
				ResultSet rs =	Config.stmt.executeQuery();
					while(rs.next()){
						int action  = rs.getInt("count");
						try{
			    			     if(action >= 1){
			    			    	 
			    			    	user =  userService.User(session.getAttribute("Login_Session").toString());
			    			    	System.out.println("User Id ->"+user.getId());
			    			    	System.out.println("User Id ->"+user.getName());
			    			    	System.out.println("User Id ->"+user.getSurname());
			    			    	System.out.println("User Id ->"+user.getEmail());
			    			    	System.out.println("User Id ->"+user.getUniqID());
			    			    	
			    			    	 System.out.println("UserVar");
			    			     }else{
			    			    	 System.out.println("UserYok");
			    				}
			    			    		
			    		}
			    		catch (Exception e){
			    			System.err.println("HATA Session in:"+e.getMessage());
			    		}
		   
					}
					rs.close();
			
					Config.CloseDB();




				} catch (SQLException e) {
					
					System.err.println("HATA Session:"+e.getMessage());
					
				}
				
				
			}else{
				
			//Hiç Yoksa
				System.out.println("Hiç Yok");
			}
		
	    
		BuyTicket buyTicket = new BuyTicket();
		buyTicket.setAmount(bilet.getFiyat());
		buyTicket.setTicket_id(bilet.getTicketID());
		buyTicket.setUser_ticket_Name(name);
		buyTicket.setUser_ticket_Surname(surname);
		if(user != null) {
			buyTicket.setSales_user_id(user.getId());
			buyTicket.setUser_isLogin(true);
		}else {
			
			buyTicket.setUser_isLogin(false);
		}
		
		
		String UniqId = utils.getSaltString();
		buyTicket.setSales_uuid(utils.MD5E(bilet.getTicketID()+name.toString()+surname.toString()+UniqId));
		buyTicket.setSales_salt(UniqId);
		buyTicket.setUser_ticket_Birthday(date1);
		buyTicket.setUser_ticket_Email(Email);
		//TODO - Düzelt
		if(Cinsiyet != null) {
			if(Cinsiyet == "1")
				buyTicket.setUser_ticket_gender(true);
			else if(Cinsiyet == "0")
				buyTicket.setUser_ticket_gender(false);
		}else {
			buyTicket.setUser_ticket_gender(false);//düzenlt
		}
		
		buyTicket.setUser_ticket_TC(tcNo);
		
		ticketService.AddBuyTicket(buyTicket);
		bilet.setSales_salt(UniqId);
		
		  utils.MailSender(bilet,name,surname,Email);
		
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

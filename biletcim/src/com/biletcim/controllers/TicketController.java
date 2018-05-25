package com.biletcim.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.configs.Config;
import com.biletcim.entities.Data_Sale;
import com.biletcim.entities.Data_Seat;
import com.biletcim.entities.User;
import com.biletcim.services.TicketService;
import com.biletcim.services.UserService;


@Controller
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = ("/biletlerim"),method=RequestMethod.GET)
	public ModelAndView MyTicketList(
			ModelAndView  model,
			HttpServletRequest request,
			HttpSession session) {
		
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
			
			
			if(user != null) {
				Map<String,Object> allObjectsMap = new HashMap<String,Object>();
				
				
				List<Data_Seat> data = ticketService.getTicketByUser(user.getId()+"");
			    allObjectsMap.put("TicketsList", data);
			    
			    model.addAllObjects(allObjectsMap);
			    
				model.setViewName("MyTicketList");
		        return model;
				
				
			}else {
				//notlogining
				//buyTicket.setUser_isLogin(false);
				
				return new ModelAndView("redirect:/Login");
			}
		
		
		
		
	}
	
	@RequestMapping(value = ("/bilet"),method=RequestMethod.GET)
	public ModelAndView TicketPage(ModelAndView  model) {
		
		model.setViewName("TicketPage");
        return model;
		
	}
	
	@RequestMapping(value = ("/biletSorgula"),method=RequestMethod.GET)
	public ModelAndView SearchTicket(ModelAndView  model) {
		
		model.setViewName("SearchTicket");
        return model;
		
	}
	
	@RequestMapping(value = ("/biletSorgula"),method=RequestMethod.POST)
	public ModelAndView SearchTicket(
			ModelAndView  model,
			Model modelv,
			HttpServletRequest request) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String ticketNumber = request.getParameter("ticketNumber");
		
		
		System.out.println("Name:"+name+"\n surname : "+surname+"\n ticketNumber:"+ticketNumber);
		
		Data_Sale  sale =  ticketService.getTicketByNumberANDFullName(ticketNumber,name,surname);
		if(sale.getUser() == null) {
			model.setViewName("SearchTicket");
			model.addObject("Error","Girilen Bilgiler Yanlýþ , Lütfen Bilgileri Kontrol Edip Tekrar Deneyiniz!");
			
			return model;
		}else {
			return new ModelAndView("redirect:/plane/check-in/ticket?Key="+sale.getUser().getSales_uuid());
		}
		
		//model.setViewName("SearchTicket");
       // return model;
		
	}
	
}

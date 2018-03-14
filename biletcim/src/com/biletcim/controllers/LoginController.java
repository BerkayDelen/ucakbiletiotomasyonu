package com.biletcim.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.configs.Config;
import com.biletcim.entities.Login_User;
import com.biletcim.entities.User;
import com.biletcim.helpers.WebUtils;

//import com.biletcim.entities.Login;

/*
 * 
 * package com.biletcim.entities;



 * */
import com.biletcim.services.UserService;
import javax.servlet.http.HttpServletRequest;




@RequestMapping(value={"/login", "/Login"})

@Controller
public class LoginController {
	
	
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private WebUtils webUtils;
	
	@GetMapping()
	public ModelAndView login(ModelAndView  model) {
		
		Login_User login = new Login_User();
		model.addObject("login", login);
        model.setViewName("LoginPage");
		return model;
		
	}
	
	@RequestMapping(value = "",method=RequestMethod.POST)
	public ModelAndView someMethod(@ModelAttribute Login_User user,
			ModelAndView model,
			HttpServletResponse httpServletResponse,
			HttpSession session,
			HttpServletRequest request) {
		
		System.out.println(user.getEmail()+" "+user.getPassword()+" "+user.getRememberMe()+"");
		
		
		Boolean call = userService.login(user);
		
        if (call) {
        	System.out.println("Login Baþarýlý.");
        	
        		String getSession = "Select count(*) as count ,User_UniqID as myUniqId from users  where User_Email = ?";
			
			try {
				
        			
				Config.OpenDB(getSession);
			
				Config.stmt.setString(1,user.getEmail());
			ResultSet rs =	Config.stmt.executeQuery();
				while(rs.next()){
					int action  = rs.getInt("count");
					String myUniqId  = rs.getString("myUniqId");
					try{
		    			     if(action >= 1){
		    			    	 System.out.println("myUniqId:"+myUniqId);
		    			    	 session.setAttribute("Login_Session", myUniqId);
		    			     }
		    			    		
		    		}
		    		catch (Exception e){
		    			System.out.println("HATA Session Create Read Data in:"+e.getMessage());
		    		}
	   
				}
				rs.close();
		
				Config.CloseDB();




			} catch (SQLException e) {
				
				System.out.println("HATA  Session Create Read Data in:"+e.getMessage());
				
			}
        	 
        	//httpServletResponse.setHeader("Location", "http://localhost:8080/biletcim/");
        	 			String uniqueID = UUID.randomUUID().toString();
        	 
        	 
     		
     					
     					
        	 if(user.getRememberMe() != null) {
        		 if(user.getRememberMe() == false) {
            		 Cookie cookie = new Cookie("Login_ID", uniqueID);
                	 cookie.setMaxAge(1000);
                	 httpServletResponse.addCookie(cookie);
                	 
                	 URL url;
        			try {
        				url = new URL("http://checkip.amazonaws.com/");
        			
        				BufferedReader br;
        			
        				br = new BufferedReader(new InputStreamReader(url.openStream()));
        			String Myip=br.readLine();
                	 System.out.println("Myip : "+Myip);
                	 
                	 /*Cookie Ekleme*/
                	 
                	 String sql_Cookie_add = "INSERT INTO `dbbiletcim`.`logincookies` (`loginCookie_Key`, `loginCookie_User_ID`, `loginCookie_IP`) Select ?,  Id ,? from users where User_Email = ?";
              		
  					try {
  						
  						int rs = 0;
  						Config.OpenDB(sql_Cookie_add);
  						
  							
  							Config.stmt.setString(1,uniqueID);
  							Config.stmt.setString(2,Myip);
  							Config.stmt.setString(3,user.getEmail());
  							
  							
  							
  							rs =	Config.stmt.executeUpdate();
  							System.out.println(rs+" UserUniqId Eklendi.");

  							Config.CloseDB();
  					} catch (SQLException e) {
  						System.out.println("Hata: (After Login W Cookie)"+e.getMessage());	
  					}
                	 
                	 /*Cookie Ekleme SOn*/
                	 
                	 
        			} catch (MalformedURLException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (IOException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} 
            	 }
        	 }
        	
        	 
        	 
        	 
        	 return new ModelAndView("redirect:/");
           
        	
        }else if (call == null) {
        	
        	Login_User login = new Login_User();
    		model.addObject("login", login);
    		System.out.println("LOG: Hata (Login Baþarýsýz.)");
            model.setViewName("LoginPage");
            session.setAttribute("Login", "false");
            return model;
            
        }
        else {
        	
        	Login_User login = new Login_User();
    		model.addObject("login", login);
    		System.out.println("Login Baþarýsýz!");
            model.setViewName("LoginPage");
            session.setAttribute("Login", "false");
            return model;
        	
        }
        
		
	}
	
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (null != ip && !"".equals(ip.trim())
		&& !"unknown".equalsIgnoreCase(ip)) {
		return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (null != ip && !"".equals(ip.trim())
		&& !"unknown".equalsIgnoreCase(ip)) {
		// get first ip from proxy ip
		int index = ip.indexOf(',');
		if (index != -1) {
		return ip.substring(0, index);
		} else {
		return ip;
		}
		}
		return request.getRemoteAddr();
		}
	/*
	@PostMapping()
    public ModelAndView register(@ModelAttribute User user) {
		System.out.println(user.getEmail());
		
		/*
        if (userService.login(user)) {
        	
        	System.out.println("Login Baþarýlý.");
        	return new ModelAndView("redirect:/");
        }else {
        	System.out.println("Login Baþarýsýz!");
        	return new ModelAndView("LoginPage");
        }
        --
		return new ModelAndView("LoginPage");
        
    }
    */

}

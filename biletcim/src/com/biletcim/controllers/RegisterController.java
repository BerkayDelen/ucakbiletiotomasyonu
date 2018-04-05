package com.biletcim.controllers;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.configs.Config;
import com.biletcim.entities.User;
import com.biletcim.services.UserService;



@Controller
@RequestMapping(value= {"/register","/Register"})
public class RegisterController {
	
	
	
	@Autowired
    private UserService userService;
	
	@GetMapping()
	public ModelAndView register(ModelAndView  model,
			HttpServletRequest request) {
		
			String Cookie_ID = "";
	     
	    
		Cookie[] cookies = request.getCookies();
			
			for (Cookie c : cookies) {
				if(c.getName().equals("Login_ID")){
					Cookie_ID = c.getValue();
					System.out.println(c.getName() + "=" + c.getValue());
					break;
				}
				
				}
			if(!Cookie_ID.isEmpty()) {
				return new ModelAndView("redirect:/");
			}
		
		
		User user = new User();
		model.addObject("user", user);
        model.setViewName("RegisterPage");
		return model;
		
	}
	
	
	
	@PostMapping()
    public ModelAndView register(@ModelAttribute User user,Model modelV,HttpServletRequest request) {
		if(!request.getParameter("rePassword").equals(user.getPassword())){
			modelV.addAttribute("RegisterError"," Þifreler Birbiri ile uyuþmamaktadýr. ");
	    	 return new ModelAndView("RegisterPage");
		}
        if (user.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
        	
	String getSession = "Select count(*) as count  from users  where User_Email = ?";
			
			try {
				
        			
				Config.OpenDB(getSession);
			
				Config.stmt.setString(1,user.getEmail());
			ResultSet rs =	Config.stmt.executeQuery();
				while(rs.next()){
					int action  = rs.getInt("count");
					
					try{
		    			     if(action >= 1){
		    			    	 modelV.addAttribute("RegisterError",user.getEmail()+" Email ile Daha önceden Üye olunmuþ.");
		    			    	 return new ModelAndView("RegisterPage");
		    			     }else {
		    			    	  String uniqueID = UUID.randomUUID().toString();
		    			        	user.setUniqID(uniqueID);
		    			        	userService.addUser(user);
		    			        	System.out.println("Yeni Kullanýcý Eklendi.");
		    			        	return new ModelAndView("redirect:/Login");
		    			     }
		    			    		
		    		}
		    		catch (Exception e){
		    			modelV.addAttribute("RegisterError"," Hata Lütfen Daha Sonra Tekrar Deneyin ");
				    	 return new ModelAndView("RegisterPage");
		    		}
	   
				}
				rs.close();
		
				Config.CloseDB();




			} catch (SQLException e) {
				
				
				 modelV.addAttribute("RegisterError"," Hata Lütfen Daha Sonra Tekrar Deneyin ");
		    	 return new ModelAndView("RegisterPage");
				
			}
        	
        	
        	
        	
        }
        
        return new ModelAndView("redirect:/");
    }

}

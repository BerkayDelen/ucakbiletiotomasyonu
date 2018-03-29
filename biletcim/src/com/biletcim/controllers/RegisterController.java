package com.biletcim.controllers;


import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView register(@ModelAttribute User user) {
        if (user.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
        	String uniqueID = UUID.randomUUID().toString();
        	user.setUniqID(uniqueID);
        	userService.addUser(user);
        	System.out.println("Yeni Kullanýcý Eklendi.");
        	
        }
        
        return new ModelAndView("redirect:/");
    }

}

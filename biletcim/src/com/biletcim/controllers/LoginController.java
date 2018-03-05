package com.biletcim.controllers;

import java.sql.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.entities.Login_User;
import com.biletcim.entities.User;

//import com.biletcim.entities.Login;

/*
 * 
 * package com.biletcim.entities;



 * */
import com.biletcim.services.UserService;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	
	
	@Autowired
    private UserService userService;
	
	@GetMapping()
	public ModelAndView login(ModelAndView  model) {
		
		
		
		
		Login_User login = new Login_User();
		model.addObject("login", login);
        model.setViewName("LoginPage");
		return model;
		
	}
	
	@RequestMapping(value = "",method=RequestMethod.POST)
	public ModelAndView someMethod(@ModelAttribute Login_User user,ModelAndView model,HttpServletResponse httpServletResponse) {
		
		System.out.println(user.getEmail()+" "+user.getPassword()+" "+user.getRememberMe()+"");
		
		
		Boolean call = userService.login(user);
		
        if (call) {
        	System.out.println("Login Baþarýlý.");
        	httpServletResponse.setHeader("Location", "http://localhost:8080/biletcim/");
        	
        }else if (call == null) {
        	
        	Login_User login = new Login_User();
    		model.addObject("login", login);
    		System.out.println("LOG: Hata (Login Baþarýsýz.)");
            model.setViewName("LoginPage");
            return model;
            
        }
        else {
        	
        	Login_User login = new Login_User();
    		model.addObject("login", login);
    		System.out.println("Login Baþarýsýz!");
            model.setViewName("LoginPage");
            return model;
        	
        }
        return model;
		
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

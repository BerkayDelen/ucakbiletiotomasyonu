package com.biletcim.controllers;


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
@RequestMapping("/register")
public class RegisterController {
	
	
	
	@Autowired
    private UserService userService;
	
	@GetMapping()
	public ModelAndView register(ModelAndView  model) {
		User user = new User();
		model.addObject("user", user);
        model.setViewName("RegisterPage");
		return model;
		
	}
	
	
	
	@PostMapping()
    public ModelAndView register(@ModelAttribute User user) {
        if (user.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
        	userService.addUser(user);
        	System.out.println("Yeni Kullanýcý Eklendi.");
        }
        
        return new ModelAndView("redirect:/");
    }

}

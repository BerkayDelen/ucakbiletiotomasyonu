package com.biletcim.controllers;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.configs.Config;
import com.biletcim.entities.Login_User;

@RequestMapping("/Logout")
@Controller
public class LogOutController {
	
	@GetMapping()
	public ModelAndView LogOut(
			ModelAndView  model,
			HttpSession session,
			HttpServletRequest request) {
		
		if (session.getAttribute("Login_Session") != null) {
		    session.invalidate();
		    System.out.println("Sessions Destroyed.");
		}
		
		String Cookie_ID = "";
	     
	     Cookie[] cookies = request.getCookies();
			
			for (Cookie c : cookies) {
				if(c.getName().equals("Login_ID")){
					Cookie_ID = c.getValue();
					System.out.println(c.getName() + "=" + c.getValue());
					
					String sql = "DELETE FROM dbbiletcim.logincookies where loginCookie_Key = ?;";
		     		
 					try {
 						
 						int rs = 0;
 						Config.OpenDB(sql);
 						
 							
 							Config.stmt.setString(1,Cookie_ID);
 							
 							
 							
 							
 							rs =	Config.stmt.executeUpdate();
 							System.out.println(rs+" UserUniqId Cookie Silindi.");

 							Config.CloseDB();
 					} catch (SQLException e) {
 						System.out.println("Hata: (After Login)"+e.getMessage());	
 					}
 					
					break;
				}
				
				}
			
			
			
		    
        return new ModelAndView("redirect:/");
		
	}

}

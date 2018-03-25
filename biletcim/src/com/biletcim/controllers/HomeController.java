package com.biletcim.controllers;

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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.configs.Config;
import com.biletcim.entities.Login_User;
import com.biletcim.entities.Port;



@RequestMapping(value={"/", "/AnaSayfa"})
@Controller
public class HomeController {
	
	@RequestMapping()
	public ModelAndView Index(ModelAndView  model) {
		 System.out.println("Index Page");
		
		List<Port> Ports = new ArrayList<Port>();
		
		

		
		String sql = "SELECT * from ports where portName <>''  order by PortName ASC";
		
					try {
						Config.OpenDB(sql);
					
					
					ResultSet rs =	Config.stmt.executeQuery();
			   while(rs.next()){
			      
			      String portName = "";
			      String code = "";
			      String city = "";
			      String country = "";
			      double coordinateLatitude = 0;
			      double coordinateLongitude= 0;
			      
			      portName = rs.getString("PortName");
			      code = rs.getString("Code");
			      city = rs.getString("City");
			      country = rs.getString("Country");
			      
			      
			      coordinateLatitude = Double.parseDouble(rs.getString("coordinateLatitude"));
			      coordinateLongitude = Double.parseDouble(rs.getString("coordinateLongitude"));
			      Port port = new Port(portName, code, city, country, coordinateLatitude, coordinateLongitude);
			      Ports.add(port);
			      
			   }
			   rs.close();
				
			   Config.CloseDB();
			  
			   
			   
			   
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
		
					
		
					
		model.addObject("Ports", Ports);
		model.addObject("trys", "deneme");
        model.setViewName("mainPage");
		return model;
				
				
		
	}
}

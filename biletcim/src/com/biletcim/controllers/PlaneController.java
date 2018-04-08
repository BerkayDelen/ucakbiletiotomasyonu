package com.biletcim.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Data_Sale;
import com.biletcim.entities.Seat;
import com.biletcim.helpers.WebUtils;
import com.biletcim.services.TicketService;


@RequestMapping(value={"/plane", "/Plane"})
@Controller
public class PlaneController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private WebUtils webUtils;
	
	String resim = "";
	
	@RequestMapping(value = ("/check-in/control"),method=RequestMethod.GET)
	public ModelAndView checkIn(
			ModelAndView  model,
			Model modelv,
			HttpServletRequest request) {
		
		
		
		model.setViewName("CheckInOne");
		 return model;
		
		
	}
	
	@RequestMapping(value = ("/check-in"),method=RequestMethod.POST)
	public ModelAndView checkInPlane(
			ModelAndView  model,
			Model modelv,
			HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String ticketNumber = request.getParameter("ticketNumber");
		
		
		System.out.println("Name:"+name+"\n surname : "+surname+"\n ticketNumber:"+ticketNumber);
		
		Data_Sale  sale =  ticketService.getTicketByNumberANDFullName(ticketNumber,name,surname);
		System.out.println("0Name:"+sale.getUser().getSales_user_Name()+"\n surname : "+sale.getUser().getSales_user_Surname()+"\n ticketNumber:"+sale.getTicket().getTicketNumber());
		
		
		model.addObject("sale",sale);
		
		 
		 
		 
		 
		 
		 
		 
		 try {
				List<Seat> seats = new ArrayList<Seat>();
				
				Document doc =Jsoup.connect(webUtils.PlaneGetImgUrl(sale.getTicket().getUcakModelName(), sale.getTicket().getUcakModelType())).get();
				
				Elements plane = doc.select(".plane");
				Elements el_seatMap = doc.select("#seatmap");
				
				System.out.println("Size:"+ el_seatMap.size());
				int  ks = 0;
				for (Element element : el_seatMap) {
					
					System.out.println("size :"+element.select("area").size());
					
					for (Element item : element.select("area")) {
						System.out.println("--------------------------------");
						ks++;
						System.out.println("id :"+ks);
						
						System.out.println("item title :"+item.attr("title"));
						
						JSONObject obj = new JSONObject(item.attr("title"));
						
						
						
						/*System.out.println("item id :"+obj.getString("id"));
						System.out.println("item seats :"+obj.getString("seats"));
						System.out.println("item coords :"+obj.getString("coords"));
						System.out.println("item description :"+obj.getString("description"));*/
						System.out.println();
						//JSONObject obj_class = new JSONObject();
						//System.out.println("item class :"+obj_class.getString("class"));
						
						int item_id = Integer.parseInt(obj.getString("id"));
						String[] item_seats = obj.getString("seats").split(" ");
						String item_seats_number = item_seats[0];
						String item_seats_character = item_seats[1];
						String item_coords = obj.getString("coords");
						String item_description = obj.getString("description");
						item_description = item_description.replaceAll("\\{SEATS\\}", item_seats_number+item_seats_character);
						String item_class = obj.getJSONObject("class").getString("class");
						
						System.out.println("--------------------------------");
						Seat seat = new Seat(ks,item_id,item_seats_character,item_seats_number,item_coords,item_description,item_class);
						seats.add(seat);
						
					}
					
				}
				
				
				
				
				
				System.out.println();
				
				resim = plane.get(0).attr("src");
				
			
			
			System.out.println("Size L:"+seats.size());
			Map<String,Object> allObjectsMap = new HashMap<String,Object>();
		    allObjectsMap.put("SeatsList", seats);
		    BuyTicket buyTicket = new BuyTicket();
		    
		    allObjectsMap.put("buyTicket", buyTicket);
		    
		    model.addAllObjects(allObjectsMap);
		    
		    
		    
			modelv.addAttribute("data",resim);
			model.setViewName("PlaneGet");
			 return model;
			}catch (Exception e) {
				System.out.println("Hata: "+e.getMessage());
				model.setViewName("api");
				 return model;
				// TODO: handle exception
			}
			
	       
		
		
	}
	
	@RequestMapping(value = ("/get"),method=RequestMethod.GET)
	public ModelAndView getPlane(ModelAndView  model,Model modelv) {
		
		try {
			List<Seat> seats = new ArrayList<Seat>();
			
			Document doc =Jsoup.connect("https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Airbus_A330-300.php").get();
			
			Elements plane = doc.select(".plane");
			Elements el_seatMap = doc.select("#seatmap");
			
			System.out.println("Size:"+ el_seatMap.size());
			int  ks = 0;
			for (Element element : el_seatMap) {
				
				System.out.println("size :"+element.select("area").size());
				
				for (Element item : element.select("area")) {
					System.out.println("--------------------------------");
					ks++;
					System.out.println("id :"+ks);
					
					System.out.println("item title :"+item.attr("title"));
					
					JSONObject obj = new JSONObject(item.attr("title"));
					
					
					
					/*System.out.println("item id :"+obj.getString("id"));
					System.out.println("item seats :"+obj.getString("seats"));
					System.out.println("item coords :"+obj.getString("coords"));
					System.out.println("item description :"+obj.getString("description"));*/
					System.out.println();
					//JSONObject obj_class = new JSONObject();
					//System.out.println("item class :"+obj_class.getString("class"));
					
					int item_id = Integer.parseInt(obj.getString("id"));
					String[] item_seats = obj.getString("seats").split(" ");
					String item_seats_number = item_seats[0];
					String item_seats_character = item_seats[1];
					String item_coords = obj.getString("coords");
					String item_description = obj.getString("description");
					item_description = item_description.replaceAll("\\{SEATS\\}", item_seats_number+item_seats_character);
					String item_class = obj.getJSONObject("class").getString("class");
					
					System.out.println("--------------------------------");
					Seat seat = new Seat(ks,item_id,item_seats_character,item_seats_number,item_coords,item_description,item_class);
					seats.add(seat);
					
				}
				
			}
			
			
			
			
			
			System.out.println();
			
			resim = plane.get(0).attr("src");
			
		
		
		System.out.println("Size L:"+seats.size());
		Map<String,Object> allObjectsMap = new HashMap<String,Object>();
	    allObjectsMap.put("SeatsList", seats);
	    BuyTicket buyTicket = new BuyTicket();
	    
	    allObjectsMap.put("buyTicket", buyTicket);
	    
	    model.addAllObjects(allObjectsMap);
	    
	    
	    
		modelv.addAttribute("data",resim);
		model.setViewName("PlaneGet");
		 return model;
		}catch (Exception e) {
			System.out.println("Hata: "+e.getMessage());
			model.setViewName("api");
			 return model;
			// TODO: handle exception
		}
		
       
		
	}

}

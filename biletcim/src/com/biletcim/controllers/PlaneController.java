package com.biletcim.controllers;

import java.nio.charset.StandardCharsets;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Data_Sale;
import com.biletcim.entities.Data_Seat;
import com.biletcim.entities.Seat;
import com.biletcim.entities.json.OriginDestinationOption;
import com.biletcim.entities.json.PTC_FareBreakdowns;
import com.biletcim.entities.json.Status;
import com.biletcim.helpers.OriginDestinationOptionDeserializer;
import com.biletcim.helpers.PTC_FareBreakdownsDeserializer;
import com.biletcim.helpers.WebUtils;
import com.biletcim.services.TicketService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


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
	
	@RequestMapping(value = ("/check-in/"),method=RequestMethod.GET)
	public ModelAndView checkInC(
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
		
		byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
		name = new String(bytes, StandardCharsets.UTF_8);
		
		byte[] bytes2 = surname.getBytes(StandardCharsets.ISO_8859_1);
		surname = new String(bytes2, StandardCharsets.UTF_8);
		
		
		
		
		System.out.println("Name:"+name+"\n surname : "+surname+"\n ticketNumber:"+ticketNumber);
		
		Data_Sale  sale =  ticketService.getTicketByNumberANDFullName(ticketNumber,name,surname);
		if(sale.getUser() == null) {
			model.setViewName("CheckInOne");
			model.addObject("Error","Girilen Bilgiler Yanlýþ , Lütfen Bilgileri Kontrol Edip Tekrar Deneyiniz!");
			
			return model;
		}else {
		if (ticketService.TicketControlisAlreadySelectSeat(ticketNumber))
		{
		
		System.out.println("0Name:"+sale.getUser().getSales_user_Name()+"\n surname : "+sale.getUser().getSales_user_Surname()+"\n ticketNumber:"+sale.getTicket().getTicketNumber());
		
		System.err.println("SÝNÝF:"+sale.getTicket().getSinif());
		
		//model.addObject("sale",sale);
		
		 
		 
		 
		 
		 
		 
		 
		 try {
				List<Seat> seats = new ArrayList<Seat>();
				
				Document doc =Jsoup.connect(webUtils.PlaneGetImgUrl(sale.getTicket().getUcakModelName(), sale.getTicket().getUcakModelType())).get();
				
				Elements plane = doc.select(".plane");
				Elements el_seatMap = doc.select("#seatmap");
				
				System.out.println("Size:"+ el_seatMap.size());
				System.out.println("TicketNumber->"+sale.getTicket().getTicketNumber());
				List<Data_Seat> data_Seats = ticketService.getTicketSeats(sale.getTicket().getTicketNumber());
						
				int  ks = 0;
				for (Element element : el_seatMap) {
					System.out.println("DBSEAT SÝZE LÝST COUNT : "+data_Seats.size());
					System.out.println("size :"+element.select("area").size());
					
					for (Element item : element.select("area")) {
						//System.out.println("--------------------------------");
						ks++;
						//System.out.println("id :"+ks);
						
						//System.out.println("item title :"+item.attr("title"));
						
						JSONObject obj = new JSONObject(item.attr("title"));
						
						
						
						/*System.out.println("item id :"+obj.getString("id"));
						System.out.println("item seats :"+obj.getString("seats"));
						System.out.println("item coords :"+obj.getString("coords"));
						System.out.println("item description :"+obj.getString("description"));*/
						//System.out.println();
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
						Boolean isAvailable = data_Seats.stream().filter(o -> o.getSeat_Number().equals(item_seats_number+item_seats_character)).findFirst().isPresent();
						
						//System.out.println("--------------------------------");
						
						Seat seat = new Seat(ks,item_id,item_seats_character,item_seats_number,item_coords,item_class+" "+item_description,item_class,isAvailable);
						seats.add(seat);
						
					}
					
				}
				
				
				
				
				
				System.out.println();
				
				resim = plane.get(0).attr("src");
				
			
			
			System.out.println("Size L:"+seats.size());
			Map<String,Object> allObjectsMap = new HashMap<String,Object>();
		    allObjectsMap.put("SeatsList", seats);
		    allObjectsMap.put("sale", sale);
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
		}else {
			model.setViewName("CheckInOne");
			model.addObject("Error","Daha Önceden Koltuk Seçimi Yaptýnýz");
			
			return model;
		}
		}
	}
	
	@RequestMapping(value = ("/check-in/me"),method=RequestMethod.POST , produces = "application/json")
	@ResponseBody
	public String  checkInMe(
			ModelAndView  model,
			Model modelv,
			HttpServletRequest request) {
		
		
		
		String TicketKey = request.getParameter("TicketKey");
		String Seat = request.getParameter("Seat");
		
		final GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.registerTypeAdapter(OriginDestinationOption.class, new OriginDestinationOptionDeserializer());
	    gsonBuilder.registerTypeAdapter(PTC_FareBreakdowns.class, new  PTC_FareBreakdownsDeserializer());
	   // gsonBuilder.registerTypeAdapter(FareInfo.class, new  FareInfoDeserializer());
	    final Gson gson = gsonBuilder.setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
	   
	    Status status = new Status();
	   if(TicketKey != null && Seat != null) {
		 Boolean Inserted =  ticketService.TicketSeatSave(TicketKey, Seat);
		 if(Inserted) {
			 status.setStatus("Success");
			   status.setError("TicketKey : "+TicketKey+" / Seat : "+Seat);
		 }else {
			 status.setStatus("Fail");
			   status.setError("Cannot Inserted Seat ");
		 }
		  
		   
	   }else if(TicketKey == null){
		   status.setStatus("Fail");
		   status.setError("TicketKey is null");
	   } else if(Seat == null){
		   status.setStatus("Fail");
		   status.setError("Seat is null");
	   }
	    	
	 	    
	 	   
	 	   
	 	
	 	 return gson.toJson(status);
	    
	   
		
		
	}
	
	@RequestMapping(value = ("/check-in/ticket"),method=RequestMethod.GET)
	public ModelAndView getTicket(
			ModelAndView  model,
			Model modelv,
			HttpServletRequest request) {
		
		
		String TicketKey = request.getParameter("Key");
		
		if(TicketKey != null) {
			Data_Seat data_Seat = ticketService.getTicketByTicketKey(TicketKey);
			Map<String,Object> allObjectsMap = new HashMap<String,Object>();
		    
		    allObjectsMap.put("data_Seat", data_Seat);
		    
		    model.addAllObjects(allObjectsMap);
		    
			model.setViewName("TicketPage");
			return model;
		}else {
			 return new ModelAndView("redirect:/");
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
					//System.out.println("id :"+ks);
					
					//System.out.println("item title :"+item.attr("title"));
					
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
					Seat seat = new Seat(ks,item_id,item_seats_character,item_seats_number,item_coords,item_description,item_class,false);
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

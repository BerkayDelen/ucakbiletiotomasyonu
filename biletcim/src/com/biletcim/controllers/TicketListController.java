package com.biletcim.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.configs.Config;
import com.biletcim.entities.Company;
import com.biletcim.entities.Data_Company;
import com.biletcim.entities.Data_Plane;
import com.biletcim.entities.Data_Ticket;
import com.biletcim.entities.Data_TicketsSaveDate;
import com.biletcim.entities.Plane;
import com.biletcim.entities.Port;
import com.biletcim.entities.Ticket;
import com.biletcim.entities.json.ExtraOTAFlightInfoList;
import com.biletcim.entities.json.FareInfo;
import com.biletcim.entities.json.FlightSegment;
import com.biletcim.entities.json.OriginDestinationOption;
import com.biletcim.entities.json.PTC_FareBreakdowns;
import com.biletcim.entities.json.TRAirline;
import com.biletcim.helpers.FareInfoDeserializer;
import com.biletcim.helpers.OriginDestinationOptionDeserializer;
import com.biletcim.helpers.PTC_FareBreakdownsDeserializer;
import com.biletcim.helpers.WebUtils;
import com.biletcim.services.AirlinesService;
import com.biletcim.services.PortService;
import com.biletcim.services.TicketService;
import com.biletcim.services.UserService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@RequestMapping("/ucuslar")
@Controller
public class TicketListController {
	
	@Autowired
    private PortService portService;
	
	@Autowired
	private WebUtils wu ;
	
	@Autowired
    private AirlinesService airlinesService;
	
	@Autowired
	private TicketService ticketService;
	
	
	
	  
	  public static Connection conn = null;
	  public static Statement stmt = null;
	
	
	
	@RequestMapping(value = ("/js"),method=RequestMethod.GET)
	public ModelAndView getTicketsJS(ModelAndView  model) {
		
		model.setViewName("api");
        return model;
		
	}
	
	
	
	@RequestMapping(value = ("/{ports}/{date}"),method=RequestMethod.GET)
	public ModelAndView getTickets(
			@PathVariable(value="ports") String Ports,
			@PathVariable(value="date") String FlyDate,
			ModelAndView  model,
			Model modelVM) {
		
		
		   
		  
		  
		  
		      //STEP 2: Register JDBC driver
		      
		      
				

		   
		
		
		List<Ticket> Tickets = new ArrayList<Ticket>();
		
		 int ticketID = 0;
		 String ticketNumber = null;
		
		 String KalkisZamani = null;
		 String VarisZamani = null;
		
		 String Sure;
		
		 String UcakModelName;
		 String UcakModelType;

		 String KalkisYeri = null;
		 String VarisYeri = null;
		 double Fiyat = 0;
		
		//Ticket ticket FlyDate = 
		
		System.out.println("Ports"+Ports);
		System.out.println("FlyDate"+FlyDate);
		//List<Port> Ports = new ArrayList<Port>();
		String[] LocationCodes = Ports.split("-");
		String FromLocationCodes = LocationCodes[0];
		String ToLocationCodes = LocationCodes[1];
		
		String LFromLocationCodes = portService.getPortByShortName(FromLocationCodes).getCity();
		String LToLocationCodes = portService.getPortByShortName(ToLocationCodes).getCity();
		Data_TicketsSaveDate data_TicketsSaveDate = new Data_TicketsSaveDate(FromLocationCodes, ToLocationCodes);
		ticketService.AddTicketSaveDate(data_TicketsSaveDate);
		
		System.out.println("data_TicketsSaveDate ID :"+data_TicketsSaveDate.getId());
		
		String date = convertDate(FlyDate);
		
		System.out.println("DateD:"+date);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String dateD=FlyDate.substring(0, 2);
    	String dateM=FlyDate.substring(2, 4);
    	String dateY=FlyDate.substring(4, 8);
		
        String dateInString = dateY+"-"+dateM+"-"+dateD;
        
        
		if(date != "Error") {
			List<Company> companies = new ArrayList<Company>();
			companies = airlinesService.getCompanyies();
			
			
			
			 String json = "";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				

			      //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database...");
			      
					conn = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASS);
				
			      System.out.println("Connected database successfully...");
			      
			      //STEP 4: Execute a query
			      System.out.println("Inserting records into the table...");
			     
					stmt = conn.createStatement();
					
					
			StringBuilder urlBuilder = new StringBuilder("https://api.turkishairlines.com/test/getAvailability");
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("apisecret", Config.apiKeySecret);
	        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
	        conn.setRequestProperty("apikey",  Config.apiKeyPublic);
	        byte[] body = ("{ "
	        		+ " \"ReducedDataIndicator\":false,"
	        		+ " \"RoutingType\":\"o\", "
	        		+ " \"PassengerTypeQuantity\":[    {      \"Code\":\"adult\",      \"Quantity\":1    },    {      \"Code\":\"child\",      \"Quantity\":0    },    {      \"Code\":\"infant\",      \"Quantity\":0    }  ], "
	        		+ " \"OriginDestinationInformation\":["
	        		+ "		    {     "
	        		+ "				 \"DepartureDateTime\":{     "
	        		+ "					   \"WindowAfter\":\"P0D\",  "
	        		+ "				      \"WindowBefore\":\"P0D\",     "
	        		+ "					   \"Date\":\""+date+"\"      }, "
	        		+ "			     \"OriginLocation\":{    "
	        		+ "					    \"LocationCode\":\""+FromLocationCodes+"\",   "
	        		+ "					     \"MultiAirportCityInd\":false      }, "
	        		+ "			     \"DestinationLocation\":{  "
	        		+ "					      \"LocationCode\":\""+ToLocationCodes+"\",  "
	        		+ "					      \"MultiAirportCityInd\":false      }, "
	        		+ "			     \"CabinPreferences\":[        {          \"Cabin\":\"ECONOMY\"        } ,{          \"Cabin\":\"BUSINESS\"        }     ]    } "
	        		+ " ]"
	        		+ "}").getBytes();
	        System.err.println("Body:"+body.toString());
	        conn.setFixedLengthStreamingMode(body.length);
	        conn.setDoOutput(true);

	        OutputStream out = conn.getOutputStream();
	        out.write(body);
	        System.out.println(body);
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	        json = sb.toString();
	        
	        
	        
	        
	        try {
				final GsonBuilder gsonBuilder = new GsonBuilder();
			    gsonBuilder.registerTypeAdapter(OriginDestinationOption.class, new OriginDestinationOptionDeserializer());
			    gsonBuilder.registerTypeAdapter(PTC_FareBreakdowns.class, new  PTC_FareBreakdownsDeserializer());
			   // gsonBuilder.registerTypeAdapter(FareInfo.class, new  FareInfoDeserializer());
			    final Gson gson = gsonBuilder.setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
			    
			 TRAirline trAirline = gson.fromJson(sb.toString(), TRAirline.class);
	    	 String Status = trAirline.getStatus().toString();
	    	 System.out.println("Status:->"+Status);
	         System.out.println("requestId:->"+trAirline.getRequestId().toString());
	         System.out.println("message:->");
	         System.out.println("|->getDescription:->"+trAirline.getMessage().getDescription().toString());
	         System.out.println("|->getCode:->"+trAirline.getMessage().getCode().toString());
	    	 //System.out.println(gson.toJson(trAirline));
	    	 if(Status.equals("SUCCESS")) {
	    		 
	    		 
	    		List<OriginDestinationOption> destinationOptions =  trAirline
	    				.getData()
	    				.getAvailabilityOTAResponse()
	    				.getCreateOTAAirRoute()
	    				.getOTA_AirAvailRS()
	    				.getOriginDestinationInformation()
	    				.getOriginDestinationOptions()
	    				.getOriginDestinationOption();
	    		
	    		List<ExtraOTAFlightInfoList> flightInfoLists =  trAirline
	    				.getData()
	    				.getAvailabilityOTAResponse()
	    				.getCreateOTAAirRoute()
	    				.getExtraOTAAvailabilityInfoListType()
	    				.getExtraOTAAvailabilityInfoList()
	    				.getExtraOTAFlightInfoListType()
	    				.getExtraOTAFlightInfoList();
	    		
	    		//TODO - Tickets insert database
	    		//TODO - Twice Ticket ->  <- (Hard)
	    		System.out.println("destinationOptions Count:->"+destinationOptions.size());
	    		System.out.println("destinationOptions Count:->"+flightInfoLists.size());
	    		
	    		for (int i = 0; i < destinationOptions.size(); i++) {
	    			
	    			FlightSegment flightSegment = destinationOptions.get(i).getFlightSegment();
	    			ExtraOTAFlightInfoList flightInfo =  flightInfoLists.get(i);
	    			
					String DepartureDateTime = flightSegment.getDepartureDateTime();
					String ArrivalDateTime = flightSegment.getArrivalDateTime();
					String JourneyDuration	= flightSegment.getJourneyDuration();
					UcakModelName = flightSegment.getEquipment().getValue();
					UcakModelType = flightSegment.getEquipment().getAirEquipType();
					ticketNumber = flightSegment.getFlightNumber();
					Boolean isPureAnadoluJetFlight = flightInfo.getÝsPureAnadoluJetFlight();
					//String Amount_test = flightInfo.getBookingPriceInfoType()					
					
					String[] TDate = DepartureDateTime.split("-");
			        
			        
			        
			        
			        modelVM.addAttribute("Date",TDate[2].substring(0, 2)+" "+convertDateTR(TDate[1])+" "+TDate[0]);
			        
					KalkisZamani=DepartureDateTime.substring(DepartureDateTime.indexOf("T")+1, DepartureDateTime.indexOf("T")+6);
					VarisZamani=ArrivalDateTime.substring(ArrivalDateTime.indexOf("T")+1, ArrivalDateTime.indexOf("T")+6);
					String Sure_NW=JourneyDuration.substring(JourneyDuration.indexOf("T")+1, JourneyDuration.indexOf("M")+1);
					String Sure_Saat = Sure_NW.substring(0,Sure_NW.indexOf("H"));
					String Sure_Dakika = Sure_NW.substring(Sure_NW.indexOf("H")+1,Sure_NW.indexOf("M"));
					Sure=Sure_Saat+" Saat "+Sure_Dakika+" Dakika";
					
					//UcakModelName = Equipment_Value;
					//UcakModelType = Equipment_AirEquipType;
					
					System.out.println("Kalkýþ Zamaný:"+DepartureDateTime);
					System.out.println("Varýþ Zamaný:"+ArrivalDateTime);
					System.out.println("Süresi Zamaný:"+JourneyDuration);
					
					//System.out.println("Uçak Model:"+Equipment_Value);
					//System.out.println("Uçak Type:"+Equipment_AirEquipType);
					
					
					int havalimanýCompany = 0;
					if(isPureAnadoluJetFlight) {
						havalimanýCompany = 2;
					}else {
						havalimanýCompany = 1;
					}
					Company company =null;
					for (int company_id = 0; company_id < companies.size(); company_id++) {
						if(companies.get(company_id).getCompanyID() == havalimanýCompany){
							company = companies.get(company_id);
						}
					}
					
					
					
					
				/*	Ticket bilet = new Ticket(
							ticketID,
							ticketNumber,
							dateInString,
							KalkisZamani,
							VarisZamani,
							Sure,
							UcakModelName,
							UcakModelType,
							wu.FirstUpper(LFromLocationCodes)+" "+FromLocationCodes,
							wu.FirstUpper(LToLocationCodes)+" "+ToLocationCodes,
							Fiyat,
							_Class,
							company);
					*/
				}
	    		 
	    	 }else {
	    		 
	    		 model = wu.FailureControl(model,trAirline.getMessage().getCode().toString());
	    	 }
			}catch (Exception e2) {
				// TODO: handle exception
				
				System.err.println("level 1->"+e2.getMessage());
				model = wu.FailureControl(model,e2.getMessage());
				
				
			}
	        
	        
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			/*
			try {
			JSONObject obj = new JSONObject(json);
			JSONObject data = obj.getJSONObject("data");
			JSONObject data_availabilityOTAResponse = data.getJSONObject("availabilityOTAResponse");
			JSONObject data_createOTAAirRoute = data_availabilityOTAResponse.getJSONObject("createOTAAirRoute");
			JSONObject data_extraOTAAvailabilityInfoListType = data_createOTAAirRoute.getJSONObject("extraOTAAvailabilityInfoListType");//info getter
			
			JSONObject data_extraOTAAvailabilityInfoList = data_extraOTAAvailabilityInfoListType.getJSONObject("extraOTAAvailabilityInfoList");
			JSONObject data_extraOTAFlightInfoListType = data_extraOTAAvailabilityInfoList.getJSONObject("extraOTAFlightInfoListType");
			
			JSONArray Flys = data_extraOTAFlightInfoListType.getJSONArray("extraOTAFlightInfoList");
			
			JSONObject data_OTA_AirAvailRS = data_createOTAAirRoute.getJSONObject("OTA_AirAvailRS");// getter
			JSONObject data_OriginDestinationInformation = data_OTA_AirAvailRS.getJSONObject("OriginDestinationInformation");
			JSONObject data_OriginDestinationOptions = data_OriginDestinationInformation.getJSONObject("OriginDestinationOptions");
			JSONArray Flys_real = data_OriginDestinationOptions.getJSONArray("OriginDestinationOption");
			
			
			
			for (int i = 0; i < Flys.length(); i++)
			{
				String flightNumber = "";
				String Amount = "";
				String _Class = "";
				
				JSONObject fly = Flys.getJSONObject(i);
				
				JSONObject flys_real = Flys_real.getJSONObject(i);
				//Get Fly Object Real
				
				JSONObject fly_real_FlightSegment = flys_real.getJSONObject("FlightSegment");
				JSONObject fly_real_Equipment = fly_real_FlightSegment.getJSONObject("Equipment");
				String Equipment_Value = fly_real_Equipment.getString("Value");
				String Equipment_AirEquipType = fly_real_Equipment.getString("AirEquipType");
				
				
				String DepartureDateTime 	= fly_real_FlightSegment.getString("DepartureDateTime");
				String ArrivalDateTime 		= fly_real_FlightSegment.getString("ArrivalDateTime");
				String JourneyDuration	 	= fly_real_FlightSegment.getString("JourneyDuration");
				
				String[] TDate = DepartureDateTime.split("-");
		        
		        
		        
		        
		        modelVM.addAttribute("Date",TDate[2].substring(0, 2)+" "+convertDateTR(TDate[1])+" "+TDate[0]);
		        
				KalkisZamani=DepartureDateTime.substring(DepartureDateTime.indexOf("T")+1, DepartureDateTime.indexOf("T")+6);
				VarisZamani=ArrivalDateTime.substring(ArrivalDateTime.indexOf("T")+1, ArrivalDateTime.indexOf("T")+6);
				String Sure_NW=JourneyDuration.substring(JourneyDuration.indexOf("T")+1, JourneyDuration.indexOf("M")+1);
				String Sure_Saat = Sure_NW.substring(0,Sure_NW.indexOf("H"));
				String Sure_Dakika = Sure_NW.substring(Sure_NW.indexOf("H")+1,Sure_NW.indexOf("M"));
				Sure=Sure_Saat+" Saat "+Sure_Dakika+" Dakika";
				UcakModelName = Equipment_Value;
				UcakModelType = Equipment_AirEquipType;
				
				System.out.println("Kalkýþ Zamaný:"+DepartureDateTime);
				System.out.println("Varýþ Zamaný:"+ArrivalDateTime);
				System.out.println("Süresi Zamaný:"+JourneyDuration);
				System.out.println("Uçak Model:"+Equipment_Value);
				System.out.println("Uçak Type:"+Equipment_AirEquipType);
				//End Get Fly Object Real
				
				
				Boolean isPureAnadoluJetFlight = fly.getBoolean("isPureAnadoluJetFlight");
				JSONObject fly_bookingPriceInfoType = fly.getJSONObject("bookingPriceInfoType");
				JSONObject fly_PTC_FareBreakdowns = fly_bookingPriceInfoType.getJSONObject("PTC_FareBreakdowns");
				JSONObject PTC_FareBreakdown_item = null;
				try {
				JSONArray fly_PTC_FareBreakdown = fly_PTC_FareBreakdowns.getJSONArray("PTC_FareBreakdown");
				
				//in price 1 -PassengerFare
					for (int item_i = 0; item_i < fly_PTC_FareBreakdown.length(); item_i++)
					{
					 PTC_FareBreakdown_item = fly_PTC_FareBreakdown.getJSONObject(item_i);
					 JSONObject FareBasisCodes = PTC_FareBreakdown_item.getJSONObject("FareBasisCodes");
					 String FareBasisCode = FareBasisCodes.getString("FareBasisCode");
					 if(FareBasisCode.equals("ER") ) {
						 System.out.println("_AA_in_ER");
						 JSONObject PassengerFare = PTC_FareBreakdown_item.getJSONObject("PassengerFare");
							JSONObject TotalFare = PassengerFare.getJSONObject("TotalFare");
							String TotalFare_Amount = "";
							 TotalFare_Amount = TotalFare.getString("Amount");
							 Amount = TotalFare_Amount;
							 
							 JSONObject FareInfo = PTC_FareBreakdown_item.getJSONObject("FareInfo");
								JSONObject FareReference = FareInfo.getJSONObject("FareReference");
								String FareReference_content = FareReference.getString("content");
								_Class = FareReference_content;
							 
					 }
					}
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
					
					JSONObject fly_PTC_FareBreakdown = fly_PTC_FareBreakdowns.getJSONObject("PTC_FareBreakdown");
					
					//in price 1 -PassengerFare
					System.out.println("_AA_in_");
					 PTC_FareBreakdown_item = fly_PTC_FareBreakdown;
					 
					 JSONObject PassengerFare = PTC_FareBreakdown_item.getJSONObject("PassengerFare");
						JSONObject TotalFare = PassengerFare.getJSONObject("TotalFare");
						String TotalFare_Amount = "";
						 TotalFare_Amount = TotalFare.getString("Amount");
						 Amount = TotalFare_Amount;
						 
						 
						 JSONObject FareInfo = PTC_FareBreakdown_item.getJSONObject("FareInfo");
							JSONObject FareReference = FareInfo.getJSONObject("FareReference");
							String FareReference_content = FareReference.getString("content");
							_Class = FareReference_content;
				}
				
				
				
				
				
				
				flightNumber = fly.getString("flightNumber");
				ticketID=-1;
				ticketNumber = flightNumber;
				
				//out price 1
				try {
					
					Fiyat = Double.parseDouble(Amount);;
				}
				catch (Exception e) {
					System.out.print("Hata in FN = "+e.getMessage());
				}
				
				
				
				System.out.println("flightNumber_	:"+flightNumber);
				System.out.println("Amount_			:"+Amount);
				System.out.println("");
				
				int havalimanýCompany = 0;
				if(isPureAnadoluJetFlight) {
					havalimanýCompany = 2;
				}else {
					havalimanýCompany = 1;
				}
				Company company =null;
				for (int company_id = 0; company_id < companies.size(); company_id++) {
					if(companies.get(company_id).getCompanyID() == havalimanýCompany){
						company = companies.get(company_id);
					}
				}
				
				
				
				
				Ticket bilet = new Ticket(
						ticketID,
						ticketNumber,
						dateInString,
						KalkisZamani,
						VarisZamani,
						Sure,
						UcakModelName,
						UcakModelType,
						wu.FirstUpper(LFromLocationCodes)+" "+FromLocationCodes,
						wu.FirstUpper(LToLocationCodes)+" "+ToLocationCodes,
						Fiyat,
						_Class,
						company);
				
				
				KalkisYeri = LFromLocationCodes;
				VarisYeri = LToLocationCodes;
				
				if(Fiyat !=0 && Fiyat!=0.0) {
					Data_Company data_Company = new Data_Company(company.getCompanyID(),company.getCompanyName(),company.getCompanyImg());
					
					Data_Plane data_Plane = new Data_Plane(UcakModelName, UcakModelType);
					//Data_Plane data_Plane_c = ticketService.getPlaneControl(data_Plane);
					
					//System.out.println(" data_Plane id:"+data_Plane_c.getId());
					
					/*if(data_Plane_c.getId() == 0) {
						ticketService.addPlane(data_Plane);
						
					}else {
						data_Plane = data_Plane_c;
					}*/
					
					

			        /*
			        SimpleDateFormat sdf = 
			                 new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        

			            Date ticketDate = (Date) formatter.parse(dateInString);
			            System.out.println(date);
			            System.out.println(formatter.format(date));

			        
			            java.util.Date dt = new java.util.Date();

			            java.text.

			            String currentTime = sdf.format(dt);*/
			        	
			      
			      /*  
					Data_Ticket data_Ticket = new Data_Ticket(
							ticketNumber,
							dateInString,
							KalkisZamani,
							VarisZamani,
							Sure,
							data_Plane,
							wu.FirstUpper(LFromLocationCodes)+" "+FromLocationCodes,
							wu.FirstUpper(LToLocationCodes)+" "+ToLocationCodes,
							Fiyat,
							data_TicketsSaveDate,
							data_Company);
					
					
					
					String sql = "INSERT INTO `tickets` "+
								"( `ticketNumber`,`ticketDate`, `kalkisZamani`, `varisZamani`, `sure`,  `Plane_Name`, `Plane_Model`, `kalkisYeri`, `varisYeri`, `fiyat`, `sinif`, `companyID`, `save_date`)"+
							" VALUES ( '"+ticketNumber+"','"+dateInString+"', '"+KalkisZamani+"', '"+VarisZamani+"', '"+Sure+"',  '"+data_Plane.getPlane_Name()+"', '"+data_Plane.getPlane_Model()+"', '"+wu.FirstUpper(LFromLocationCodes)+" "+FromLocationCodes+"', '"+wu.FirstUpper(LToLocationCodes)+" "+ToLocationCodes+"', '"+Fiyat+"', '"+_Class+"', '"+data_Company.getCompanyID()+"' , '"+data_TicketsSaveDate.getId()+"');";
					System.out.println(sql);
							stmt.executeUpdate(sql);
							
					      System.out.println("Inserted records into the table...");
					   
					      
					try {
						
						ticketService.AddTicket(data_Ticket);
						
						
					}catch (Exception e) {
						System.out.println("Hata: "+e.getMessage());
					}
					
					
					
					
					
					
					// bilet.setPlane(new Plane(UcakModelName,UcakModelType));
					 //ticketService.AddTicket(bilet);
					
					//ticketService
					Tickets.add(bilet);
					
				}
				
			}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
			--E
			*/
			
			//model.addObject("FlyList", "deneme");
		}else {
			//model.addObject("Error", "Lütfen Geçerli Bir Tarih Giriniz.");
			//model.addObject("Error", "Lütfen Geçerli Bir Tarih Giriniz.");
		}
		System.out.println("Tickets Size:"+Tickets.size());
		Map<String,Object> allObjectsMap = new HashMap<String,Object>();
	    allObjectsMap.put("TicketsList", Tickets);
	    
	    model.addAllObjects(allObjectsMap);

        
		
		
        model.setViewName("TicketListPage");
        modelVM.addAttribute("KalkisYeri",KalkisYeri);
        modelVM.addAttribute("VarisYeri",VarisYeri);
        
        
        
        
        //+" "+convertDateTR(KalkisZamani.substring(beginIndex))
        
        
        return model;
	}
	
	@RequestMapping(value = "",method=RequestMethod.POST)
	public ModelAndView getDayOfTickets() {
		
		
		/*
		try {
		StringBuilder urlBuilder = new StringBuilder("https://api.turkishairlines.com/test/getAvailability");
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("apisecret", Config.apiKeySecret);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("apikey",  Config.apiKeyPublic);
        byte[] body = ("{ "
        		+ " \"ReducedDataIndicator\":false,"
        		+ " \"RoutingType\":\"o\", "
        		+ " \"PassengerTypeQuantity\":[    {      \"Code\":\"adult\",      \"Quantity\":1    },    {      \"Code\":\"child\",      \"Quantity\":1    },    {      \"Code\":\"infant\",      \"Quantity\":0    }  ], "
        		+ " \"OriginDestinationInformation\":["
        		+ "		    {     "
        		+ "				 \"DepartureDateTime\":{     "
        		+ "					   \"WindowAfter\":\"P0D\",  "
        		+ "				      \"WindowBefore\":\"P0D\",     "
        		+ "					   \"Date\":\"26FEB\"      }, "
        		+ "			     \"OriginLocation\":{    "
        		+ "					    \"LocationCode\":\"IST\",   "
        		+ "					     \"MultiAirportCityInd\":false      }, "
        		+ "			     \"DestinationLocation\":{  "
        		+ "					      \"LocationCode\":\"ESB\",  "
        		+ "					      \"MultiAirportCityInd\":false      }, "
        		+ "			     \"CabinPreferences\":[        {          \"Cabin\":\"ECONOMY\"        }      ]    } "
        		+ " ]"
        		+ "}").getBytes();
        conn.setFixedLengthStreamingMode(body.length);
        conn.setDoOutput(true);

        OutputStream out = conn.getOutputStream();
        out.write(body);
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        return new ModelAndView("TicketListPage");
	}
	
	/*	
	    Jan	January		Ocak
		Feb	February	Þubat
		Mar	March		Mart
		Apr	April		Nisan
		May	May			Mayýs
		Jun	June		Haziran
		Jul	July		Temmuz
		Aug	August		Aðustos
		Sep	September	Eylül
		Oct	October		Ekim
		Nov	November	Kasým
		Dec	December	Aralýk
		*/
	
	
	
	
	private String convertDate(String date) {
		String dateD=date.substring(0, 2);
		String dateM=date.substring(2, 4);
		System.out.println(dateM);
		
		
		if(dateM.equals("01")) {
			return dateD+"Jan".toUpperCase();
		}else if(dateM.equals("02")) {
			return dateD+"Feb".toUpperCase();
		}
		else if(dateM.equals("03")) {
			return dateD+"Mar".toUpperCase();
		}
		else if(dateM.equals("04")) {
			return dateD+"Apr".toUpperCase();
		}
		else if(dateM.equals("05")) {
			return dateD+"May".toUpperCase();
		}
		else if(dateM.equals("06")) {
			return dateD+"Jun".toUpperCase();
		}
		else if(dateM.equals("07")) {
			return dateD+"Jul".toUpperCase();
		}
		else if(dateM.equals("08")) {
			return dateD+"Aug".toUpperCase();
		}
		else if(dateM.equals("09")) {
			return dateD+"Sep".toUpperCase();
		}
		else if(dateM.equals("10")) {
			return dateD+"Oct".toUpperCase();
		}
		else if(dateM.equals("11")) {
			return dateD+"Nov".toUpperCase();
		}
		else if(dateM.equals("12")) {
			return dateD+"Dec".toUpperCase();
		}else {
			return "Error";
		}
		
		//System.out.println("DateD:"+dateD);
		//System.out.println("DateM:"+dateM);
		
		
		
	}
	
	private String convertDateTR(String date) {
		
		String dateM=date;
		System.out.println(dateM);
		
		
		if(dateM.equals("01")) {
			return "Ocak".toUpperCase();
		}else if(dateM.equals("02")) {
			return "Þubat".toUpperCase();
		}
		else if(dateM.equals("03")) {
			return "Mart".toUpperCase();
		}
		else if(dateM.equals("04")) {
			return "Nisan".toUpperCase();
		}
		else if(dateM.equals("05")) {
			return "Mayýs".toUpperCase();
		}
		else if(dateM.equals("06")) {
			return "Haziran".toUpperCase();
		}
		else if(dateM.equals("07")) {
			return "Temmuz".toUpperCase();
		}
		else if(dateM.equals("08")) {
			return "Aðustos".toUpperCase();
		}
		else if(dateM.equals("09")) {
			return "Eylül".toUpperCase();
		}
		else if(dateM.equals("10")) {
			return "Ekim".toUpperCase();
		}
		else if(dateM.equals("11")) {
			return "Kasým".toUpperCase();
		}
		else if(dateM.equals("12")) {
			return "Aralýk".toUpperCase();
		}else {
			return "Error";
		}
		
		//System.out.println("DateD:"+dateD);
		//System.out.println("DateM:"+dateM);
		
		
		
	}
	
	

}

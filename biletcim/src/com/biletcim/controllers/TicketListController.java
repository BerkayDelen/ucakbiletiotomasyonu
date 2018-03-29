package com.biletcim.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.biletcim.entities.Port;
import com.biletcim.entities.Ticket;
import com.biletcim.helpers.WebUtils;
import com.biletcim.services.AirlinesService;
import com.biletcim.services.PortService;
import com.biletcim.services.UserService;

@RequestMapping("/ucuslar")
@Controller
public class TicketListController {
	
	@Autowired
    private PortService portService;
	
	@Autowired
	private WebUtils wu ;
	
	@Autowired
    private AirlinesService airlinesService;
	
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
		
		String date = convertDate(FlyDate);
		
		System.out.println("DateD:"+date);
		if(date != "Error") {
			List<Company> companies = new ArrayList<Company>();
			companies = airlinesService.getCompanyies();
			
			
			
			 String json = "";
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
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	//		String json = "{	\"status\" : \"SUCCESS\",	\"requestId\": \"0000016165b5a37e-3911b4\",	\"message\" : {		\"code\" : \"TK-0000\",		\"description\" : \"Request Processed Successfully.\"	},	\"data\" : {\"availabilityOTAResponse\":{\"createOTAAirRoute\":{\"extraOTAAvailabilityInfoListType\":{\"extraOTAAvailabilityInfoList\":{\"extraOTAFlightInfoListType\":{\"extraOTAFlightInfoList\":[{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2105\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2107\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2189\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2113\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"Q\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"271.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"39.35\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"218.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}}}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2117\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2123\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2127\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2135\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2139\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2141\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2143\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2147\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2151\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2153\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2159\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2163\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2167\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2169\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2171\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2175\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2179\",\"isFullAvailable\":true},{\"isPureAnadoluJetFlight\":false,\"extraOTASegmentInfoListType\":{\"extraOTASegmentInfoList\":{\"isAvailable\":true,\"isConnected\":false,\"segmentIndex\":\"1\",\"isAnadoluJetSegment\":false,\"isDomestic\":true,\"isStandBySeat\":false}},\"StandbyIndicator\":false,\"isElectronicTicketAvailable\":true,\"isCodeShare\":false,\"isFullCodeShare\":false,\"bookingPriceInfoType\":{\"PTC_FareBreakdowns\":{\"PTC_FareBreakdown\":[{\"FareBasisCodes\":{\"FareBasisCode\":\"EU\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"L\",\"content\":\"EU\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"191.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"12.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"27.15\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"138.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"20\",\"FlightSegmentRPH\":\"1\"}}},{\"FareBasisCodes\":{\"FareBasisCode\":\"ER\"},\"PassengerTypeQuantity\":{\"Quantity\":\"1\",\"Code\":\"ADT\"},\"FareInfo\":{\"PassengerFare\":\"\",\"FareReference\":{\"ResBookDesigCode\":\"P\",\"content\":\"ER\"}},\"PassengerFare\":{\"TotalFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"121.99\"},\"Taxes\":{\"Tax\":[{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"VQ\",\"Amount\":\"14.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"YR\",\"Amount\":\"27.99\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"DU\",\"Amount\":\"10.00\",\"RefundableInd\":false},{\"CurrencyCode\":\"TRY\",\"TaxCode\":\"KD\",\"Amount\":\"16.47\",\"RefundableInd\":false}]},\"BaseFare\":{\"CurrencyCode\":\"TRY\",\"Amount\":\"70.00\"},\"FareBaggageAllowance\":{\"UnitOfMeasure\":\"KILO\",\"UnitOfMeasureQuantity\":\"15\",\"FlightSegmentRPH\":\"1\"}}}]}},\"isDomestic\":true,\"isFullInternational\":false,\"flightNumber\":\"TK2183\",\"isFullAvailable\":true}]},\"isAllFlightsFullCodeShare\":false,\"isIndeedHasMoreFlightsForAnotherPortInTheSameCity\":false,\"RPH\":\"ANK_IST_20MAR2018\"}},\"OTA_AirAvailRS\":{\"Comment\":\"\",\"OriginDestinationInformation\":{\"OriginLocation\":{\"AlternateLocationInd\":false,\"LocationCode\":\"ANK\"},\"OriginDestinationOptions\":{\"OriginDestinationOption\":[{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"2\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"2\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"UNKNOWN_PLANE\",\"AirEquipType\":\"78G\"},\"DepartureDateTime\":\"2018-03-20T04:30:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T05:40:00.000+03:00\",\"FlightNumber\":\"TK2105\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H10M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"5\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"5\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"BOEING 737-800\",\"AirEquipType\":\"738\"},\"DepartureDateTime\":\"2018-03-20T05:20:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T06:35:00.000+03:00\",\"FlightNumber\":\"TK2107\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"7\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"7\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"BOEING B737-800\",\"AirEquipType\":\"78D\"},\"DepartureDateTime\":\"2018-03-20T06:30:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T07:55:00.000+03:00\",\"FlightNumber\":\"TK2189\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H25M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"7\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"7\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"BOEING B737-800\",\"AirEquipType\":\"78D\"},\"DepartureDateTime\":\"2018-03-20T07:00:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T08:20:00.000+03:00\",\"FlightNumber\":\"TK2113\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H20M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"Q\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"A320-200\",\"AirEquipType\":\"320\"},\"DepartureDateTime\":\"2018-03-20T08:00:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T09:15:00.000+03:00\",\"FlightNumber\":\"TK2117\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"UNKNOWN_PLANE\",\"AirEquipType\":\"78G\"},\"DepartureDateTime\":\"2018-03-20T09:00:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T10:15:00.000+03:00\",\"FlightNumber\":\"TK2123\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"7\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"7\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"UNKNOWN_PLANE\",\"AirEquipType\":\"77B\"},\"DepartureDateTime\":\"2018-03-20T10:50:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T12:10:00.000+03:00\",\"FlightNumber\":\"TK2127\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H20M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"AIRBUS A320-200\",\"AirEquipType\":\"32A\"},\"DepartureDateTime\":\"2018-03-20T11:05:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T12:30:00.000+03:00\",\"FlightNumber\":\"TK2135\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H25M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"BOEING B737-800\",\"AirEquipType\":\"78D\"},\"DepartureDateTime\":\"2018-03-20T12:05:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T13:25:00.000+03:00\",\"FlightNumber\":\"TK2139\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H20M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"BOEING B737-900ER\",\"AirEquipType\":\"79B\"},\"DepartureDateTime\":\"2018-03-20T12:35:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T13:50:00.000+03:00\",\"FlightNumber\":\"TK2141\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"3\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"3\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"AIRBUS A321-231\",\"AirEquipType\":\"321\"},\"DepartureDateTime\":\"2018-03-20T13:05:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T14:15:00.000+03:00\",\"FlightNumber\":\"TK2143\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H10M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"BOEING 737-800\",\"AirEquipType\":\"738\"},\"DepartureDateTime\":\"2018-03-20T14:00:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T15:15:00.000+03:00\",\"FlightNumber\":\"TK2147\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"UNKNOWN_PLANE\",\"AirEquipType\":\"78G\"},\"DepartureDateTime\":\"2018-03-20T15:10:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T16:25:00.000+03:00\",\"FlightNumber\":\"TK2151\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"BOEING B737-900ER\",\"AirEquipType\":\"79B\"},\"DepartureDateTime\":\"2018-03-20T16:00:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T17:15:00.000+03:00\",\"FlightNumber\":\"TK2153\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"8\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"8\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"BOEING B737-800\",\"AirEquipType\":\"78D\"},\"DepartureDateTime\":\"2018-03-20T17:05:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T18:20:00.000+03:00\",\"FlightNumber\":\"TK2159\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"AIRBUS A321-231\",\"AirEquipType\":\"321\"},\"DepartureDateTime\":\"2018-03-20T18:10:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T19:30:00.000+03:00\",\"FlightNumber\":\"TK2163\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H20M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"AIRBUS A321-231\",\"AirEquipType\":\"321\"},\"DepartureDateTime\":\"2018-03-20T19:00:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T20:20:00.000+03:00\",\"FlightNumber\":\"TK2167\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H20M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"8\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"8\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"AIRBUS A321-231\",\"AirEquipType\":\"32R\"},\"DepartureDateTime\":\"2018-03-20T19:35:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T20:50:00.000+03:00\",\"FlightNumber\":\"TK2169\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H15M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"8\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"8\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"UNKNOWN_PLANE\",\"AirEquipType\":\"78G\"},\"DepartureDateTime\":\"2018-03-20T20:05:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T21:25:00.000+03:00\",\"FlightNumber\":\"TK2171\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H20M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"AIRBUS A330-300\",\"AirEquipType\":\"333\"},\"DepartureDateTime\":\"2018-03-20T21:50:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T23:00:00.000+03:00\",\"FlightNumber\":\"TK2175\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H10M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"9\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":false,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"AIRBUS A320\",\"AirEquipType\":\"32N\"},\"DepartureDateTime\":\"2018-03-20T22:05:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T23:25:00.000+03:00\",\"FlightNumber\":\"TK2179\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H20M0.000S\"}},{\"FlightSegment\":{\"DepartureAirport\":{\"LocationCode\":\"ESB\"},\"Ticket\":\"eTicket\",\"ArrivalAirport\":{\"LocationCode\":\"IST\"},\"BookingClassAvail\":[{\"ResBookDesigQuantity\":\"8\",\"ResBookDesigStatusCode\":\"EU\",\"ResBookDesigCode\":\"L\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:EU\"},{\"ResBookDesigQuantity\":\"8\",\"ResBookDesigStatusCode\":\"ER\",\"ResBookDesigCode\":\"P\",\"RPH\":\"Pax:ADT&#9; SegmentIndex:1&#9; Cabin:ER\"}],\"DateChangeNbr\":true,\"StopQuantity\":\"0\",\"CodeshareInd\":false,\"Equipment\":{\"Value\":\"AIRBUS A320-200\",\"AirEquipType\":\"32S\"},\"DepartureDateTime\":\"2018-03-20T23:15:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-21T00:40:00.000+03:00\",\"FlightNumber\":\"TK2183\",\"OperatingAirline\":{\"CompanyShortName\":\"TK\"},\"JourneyDuration\":\"P0DT1H25M0.000S\"}}]},\"DepartureDateTime\":\"2018-03-20T00:00:00.000+03:00\",\"ArrivalDateTime\":\"2018-03-20T00:00:00.000+03:00\",\"RPH\":\"ANK_IST_20MAR2018\",\"DestinationLocation\":{\"AlternateLocationInd\":false,\"LocationCode\":\"IST\"}},\"Version\":\"0\"}},\"isMixCabin\":false}}}";
			
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
				
				JSONObject fly = Flys.getJSONObject(i);
				
				JSONObject flys_real = Flys_real.getJSONObject(i);
				//Get Fly Object Real
				
				JSONObject fly_real_FlightSegment = flys_real.getJSONObject("FlightSegment");
				JSONObject fly_real_Equipment = fly_real_FlightSegment.getJSONObject("Equipment");
				String Equipment_Value = fly_real_Equipment.getString("Value");
				String Equipment_AirEquipType = fly_real_Equipment.getString("AirEquipType");
				
				
				String DepartureDateTime = fly_real_FlightSegment.getString("DepartureDateTime");
				String ArrivalDateTime = fly_real_FlightSegment.getString("ArrivalDateTime");
				String JourneyDuration = fly_real_FlightSegment.getString("JourneyDuration");
				
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
						 JSONObject PassengerFare = PTC_FareBreakdown_item.getJSONObject("PassengerFare");
							JSONObject TotalFare = PassengerFare.getJSONObject("TotalFare");
							String TotalFare_Amount = "";
							 TotalFare_Amount = TotalFare.getString("Amount");
							 Amount = TotalFare_Amount;
							 
					 }
					}
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
					
					JSONObject fly_PTC_FareBreakdown = fly_PTC_FareBreakdowns.getJSONObject("PTC_FareBreakdown");
					
					//in price 1 -PassengerFare
					
					 PTC_FareBreakdown_item = fly_PTC_FareBreakdown;
					 
					 JSONObject PassengerFare = PTC_FareBreakdown_item.getJSONObject("PassengerFare");
						JSONObject TotalFare = PassengerFare.getJSONObject("TotalFare");
						String TotalFare_Amount = "";
						 TotalFare_Amount = TotalFare.getString("Amount");
						 Amount = TotalFare_Amount;
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
						KalkisZamani,
						VarisZamani,
						Sure,
						UcakModelName,
						UcakModelType,
						wu.FirstUpper(LFromLocationCodes)+" "+FromLocationCodes,
						wu.FirstUpper(LToLocationCodes)+" "+ToLocationCodes,
						Fiyat,
						company);
				
				
				KalkisYeri = LFromLocationCodes;
				VarisYeri = LToLocationCodes;
				if(Fiyat !=0 && Fiyat!=0.0) {
					Tickets.add(bilet);
				}
				
			}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			//model.addObject("FlyList", "deneme");
		}else {
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

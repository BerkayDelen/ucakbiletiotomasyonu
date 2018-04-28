package com.biletcim.helpers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.biletcim.entities.json.FareInfo;
import com.biletcim.entities.json.FlightSegment;
import com.biletcim.entities.json.OriginDestinationOption;
import com.biletcim.entities.json.OriginDestinationOptionL;
import com.biletcim.entities.json.PTC_FareBreakdown;
import com.biletcim.entities.json.PTC_FareBreakdowns;
import com.biletcim.entities.json.PassengerFare;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class PTC_FareBreakdownsDeserializer implements JsonDeserializer<PTC_FareBreakdowns> {

	@Override
	public PTC_FareBreakdowns deserialize(JsonElement arg0, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {

		//System.err.println("Des JsonElement:"+arg0.toString());
		
		JSONObject  json = new JSONObject(arg0.toString());


		PTC_FareBreakdowns fareBreakdowns = null;


		Object FSObj = json.get("PTC_FareBreakdown");
		if (FSObj instanceof JSONArray) {
			//System.out.println("It's an array");
		    // It's an array
			final GsonBuilder gsonBuildert = new GsonBuilder();
			gsonBuildert.registerTypeAdapter(FareInfo.class, new  FareInfoDeserializer());
			gsonBuildert.registerTypeAdapter(PassengerFare.class, new  FareBaggageAllowanceDeserializer());
			final Gson gson = gsonBuildert.setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		    fareBreakdowns = gson.fromJson(arg0.toString(), PTC_FareBreakdowns.class);
			
		    /*
			JSONArray arr_flightSegment = json.getJSONArray("FlightSegment");*/
			
		//	PTC_FareBreakdowns  breakdowns = new Gson().fromJson(arg0.toString(), PTC_FareBreakdowns.class);
			//fareBreakdown = breakdowns.getPTC_FareBreakdown().get(0);
			
		}
		else if (FSObj instanceof JSONObject) {
			//System.out.println("It's an object");
			final GsonBuilder gsonBuildert = new GsonBuilder();
			gsonBuildert.registerTypeAdapter(FareInfo.class, new  FareInfoDeserializer());
			gsonBuildert.registerTypeAdapter(PassengerFare.class, new  FareBaggageAllowanceDeserializer());
			
		    final Gson gson = gsonBuildert.setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
			PTC_FareBreakdown fareBreakdown = gson.fromJson(arg0.toString(), PTC_FareBreakdown.class);
			// breakdowns = new Gson().fromJson(arg0.toString(), PTC_FareBreakdowns.class);
			//fareBreakdown = breakdowns.getPTC_FareBreakdown().get(0);
			
			
			List<PTC_FareBreakdown> PTC_FareBreakdownlist = new ArrayList<PTC_FareBreakdown>();
			PTC_FareBreakdownlist.add(fareBreakdown);
			 PTC_FareBreakdowns l1s= new PTC_FareBreakdowns(PTC_FareBreakdownlist);
			 fareBreakdowns = l1s;
			 
			 
		    // It's an object
		    //interventionObject = (JSONObject)intervention;
			//JSONObject data = obj.getJSONObject("data");
			//PTC_FareBreakdown destinationOption = new Gson().fromJson(arg0.toString(), PTC_FareBreakdown.class);
			//fareBreakdown = destinationOption.get();
			
		}
		else {
		    // It's something else, like a string or number
			System.out.println("It's something else, like a string or number");
		}
		
		return  fareBreakdowns;
	}

}

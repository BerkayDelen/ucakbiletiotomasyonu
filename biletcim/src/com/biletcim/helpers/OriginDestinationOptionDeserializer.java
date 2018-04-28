package com.biletcim.helpers;

import java.lang.reflect.Type;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.biletcim.entities.json.FlightSegment;
import com.biletcim.entities.json.OriginDestinationOption;
import com.biletcim.entities.json.OriginDestinationOptionL;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class OriginDestinationOptionDeserializer implements JsonDeserializer<OriginDestinationOption> {

	@Override
	public OriginDestinationOption deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2)
			throws JsonParseException {
		
		//System.err.println("Des JsonElement:"+arg0.toString());
		//System.err.println("Des Type:"+arg1.getTypeName().toString());
		//System.err.println("Des Context:"+arg2..toString());
		
		JSONObject  json = new JSONObject(arg0.toString());
		
		FlightSegment flightSegment = null;
		Object FSObj = json.get("FlightSegment");
		if (FSObj instanceof JSONArray) {
			//System.out.println("It's an array");
		    // It's an array
		    /*
			JSONArray arr_flightSegment = json.getJSONArray("FlightSegment");*/
			
			OriginDestinationOptionL arr_flightSegment = new Gson().fromJson(arg0.toString(), OriginDestinationOptionL.class);
			flightSegment = arr_flightSegment.getFlightSegment().get(0);
			
		}
		else if (FSObj instanceof JSONObject) {
			//System.out.println("It's an object");
		    // It's an object
		    //interventionObject = (JSONObject)intervention;
			//JSONObject data = obj.getJSONObject("data");
			OriginDestinationOption destinationOption = new Gson().fromJson(arg0.toString(), OriginDestinationOption.class);
			flightSegment = destinationOption.getFlightSegment();
			
		}
		else {
		    // It's something else, like a string or number
			System.out.println("It's something else, like a string or number");
		}
		
		return new OriginDestinationOption(flightSegment);
	}
	
	

}

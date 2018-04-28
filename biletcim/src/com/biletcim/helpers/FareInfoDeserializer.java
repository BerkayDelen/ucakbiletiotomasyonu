package com.biletcim.helpers;

import java.lang.reflect.Type;

import org.json.JSONArray;
import org.json.JSONObject;

import com.biletcim.entities.json.FareInfo;
import com.biletcim.entities.json.FareInfoL;
import com.biletcim.entities.json.FareReference;
import com.biletcim.entities.json.FlightSegment;
import com.biletcim.entities.json.OriginDestinationOption;
import com.biletcim.entities.json.OriginDestinationOptionL;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class FareInfoDeserializer implements JsonDeserializer<FareInfo>{

	@Override
	public FareInfo deserialize(JsonElement arg0, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		//System.err.println("Des  in FareInfo  JsonElement:"+arg0.toString());
		//System.err.println("Des Type:"+arg1.getTypeName().toString());
		//System.err.println("Des Context:"+arg2..toString());
		
		JSONObject  json = new JSONObject(arg0.toString());
		
		FareReference fareReference  = null;
		Object FSObj = json.get("FareReference");
		if (FSObj instanceof JSONArray) {
			//System.out.println("It's an array");
		    // It's an array
		    /*
			JSONArray arr_flightSegment = json.getJSONArray("FlightSegment");*/
			
			FareInfoL arr_flightSegment = new Gson().fromJson(arg0.toString(), FareInfoL.class);
			fareReference = arr_flightSegment.getFareReference().get(0);
			
		}
		else if (FSObj instanceof JSONObject) {
			//System.out.println("It's an object");
		    // It's an object
		    //interventionObject = (JSONObject)intervention;
			//JSONObject data = obj.getJSONObject("data");
			FareInfo destinationOption = new Gson().fromJson(arg0.toString(), FareInfo.class);
			fareReference = destinationOption.getFareReference();
			
		}
		else {
		    // It's something else, like a string or number
			System.out.println("It's something else, like a string or number");
		}
		FareInfo fareInfo = new FareInfo("", fareReference);
		
		
		return fareInfo;
	}

}

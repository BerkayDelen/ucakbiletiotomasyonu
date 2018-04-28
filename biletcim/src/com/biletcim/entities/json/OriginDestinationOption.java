package com.biletcim.entities.json;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class OriginDestinationOption{
  @SerializedName("FlightSegment")
  @Expose
  private FlightSegment FlightSegment;

public FlightSegment getFlightSegment() {
	return FlightSegment;
}

public void setFlightSegment(FlightSegment flightSegment) {
	FlightSegment = flightSegment;
}

public OriginDestinationOption(com.biletcim.entities.json.FlightSegment flightSegment) {
	super();
	FlightSegment = flightSegment;
}


			
}
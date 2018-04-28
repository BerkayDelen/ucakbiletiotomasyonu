package com.biletcim.entities.json;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginDestinationOptionL {
	@SerializedName("FlightSegment")
	  @Expose
	  private List<FlightSegment> FlightSegment;

	public List<FlightSegment> getFlightSegment() {
		return FlightSegment;
	}

	public void setFlightSegment(List<FlightSegment> flightSegment) {
		FlightSegment = flightSegment;
	}
	
	
}

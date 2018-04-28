package com.biletcim.entities.json.ta;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginDestinationOption {

@SerializedName("FlightSegment")
@Expose
private List<FlightSegment> flightSegment = null;

public List<FlightSegment> getFlightSegment() {
return flightSegment;
}

public void setFlightSegment(List<FlightSegment> flightSegment) {
this.flightSegment = flightSegment;
}

}
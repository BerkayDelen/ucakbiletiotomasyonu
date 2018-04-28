package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginDestinationInformation {

@SerializedName("OriginLocation")
@Expose
private OriginLocation originLocation;
@SerializedName("OriginDestinationOptions")
@Expose
private OriginDestinationOptions originDestinationOptions;
@SerializedName("DepartureDateTime")
@Expose
private String departureDateTime;
@SerializedName("ArrivalDateTime")
@Expose
private String arrivalDateTime;
@SerializedName("RPH")
@Expose
private String rPH;
@SerializedName("DestinationLocation")
@Expose
private DestinationLocation destinationLocation;

public OriginLocation getOriginLocation() {
return originLocation;
}

public void setOriginLocation(OriginLocation originLocation) {
this.originLocation = originLocation;
}

public OriginDestinationOptions getOriginDestinationOptions() {
return originDestinationOptions;
}

public void setOriginDestinationOptions(OriginDestinationOptions originDestinationOptions) {
this.originDestinationOptions = originDestinationOptions;
}

public String getDepartureDateTime() {
return departureDateTime;
}

public void setDepartureDateTime(String departureDateTime) {
this.departureDateTime = departureDateTime;
}

public String getArrivalDateTime() {
return arrivalDateTime;
}

public void setArrivalDateTime(String arrivalDateTime) {
this.arrivalDateTime = arrivalDateTime;
}

public String getRPH() {
return rPH;
}

public void setRPH(String rPH) {
this.rPH = rPH;
}

public DestinationLocation getDestinationLocation() {
return destinationLocation;
}

public void setDestinationLocation(DestinationLocation destinationLocation) {
this.destinationLocation = destinationLocation;
}

}
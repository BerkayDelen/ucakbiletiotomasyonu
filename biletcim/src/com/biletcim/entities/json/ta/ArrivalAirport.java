package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArrivalAirport {

@SerializedName("LocationCode")
@Expose
private String locationCode;

public String getLocationCode() {
return locationCode;
}

public void setLocationCode(String locationCode) {
this.locationCode = locationCode;
}

}
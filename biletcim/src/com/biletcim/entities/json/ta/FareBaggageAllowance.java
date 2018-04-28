package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareBaggageAllowance {

@SerializedName("UnitOfMeasure")
@Expose
private String unitOfMeasure;
@SerializedName("UnitOfMeasureQuantity")
@Expose
private String unitOfMeasureQuantity;
@SerializedName("FlightSegmentRPH")
@Expose
private String flightSegmentRPH;

public String getUnitOfMeasure() {
return unitOfMeasure;
}

public void setUnitOfMeasure(String unitOfMeasure) {
this.unitOfMeasure = unitOfMeasure;
}

public String getUnitOfMeasureQuantity() {
return unitOfMeasureQuantity;
}

public void setUnitOfMeasureQuantity(String unitOfMeasureQuantity) {
this.unitOfMeasureQuantity = unitOfMeasureQuantity;
}

public String getFlightSegmentRPH() {
return flightSegmentRPH;
}

public void setFlightSegmentRPH(String flightSegmentRPH) {
this.flightSegmentRPH = flightSegmentRPH;
}

}
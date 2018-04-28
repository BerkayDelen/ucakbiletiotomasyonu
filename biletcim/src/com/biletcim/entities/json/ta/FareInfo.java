package com.biletcim.entities.json.ta;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareInfo {

@SerializedName("PassengerFare")
@Expose
private String passengerFare;
@SerializedName("FareReference")
@Expose
private List<FareReference> fareReference = null;

public String getPassengerFare() {
return passengerFare;
}

public void setPassengerFare(String passengerFare) {
this.passengerFare = passengerFare;
}

public List<FareReference> getFareReference() {
return fareReference;
}

public void setFareReference(List<FareReference> fareReference) {
this.fareReference = fareReference;
}

}
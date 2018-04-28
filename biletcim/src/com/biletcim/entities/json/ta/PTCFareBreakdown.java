package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PTCFareBreakdown {

@SerializedName("FareBasisCodes")
@Expose
private FareBasisCodes fareBasisCodes;
@SerializedName("PassengerTypeQuantity")
@Expose
private PassengerTypeQuantity passengerTypeQuantity;
@SerializedName("FareInfo")
@Expose
private FareInfo fareInfo;
@SerializedName("PassengerFare")
@Expose
private PassengerFare passengerFare;

public FareBasisCodes getFareBasisCodes() {
return fareBasisCodes;
}

public void setFareBasisCodes(FareBasisCodes fareBasisCodes) {
this.fareBasisCodes = fareBasisCodes;
}

public PassengerTypeQuantity getPassengerTypeQuantity() {
return passengerTypeQuantity;
}

public void setPassengerTypeQuantity(PassengerTypeQuantity passengerTypeQuantity) {
this.passengerTypeQuantity = passengerTypeQuantity;
}

public FareInfo getFareInfo() {
return fareInfo;
}

public void setFareInfo(FareInfo fareInfo) {
this.fareInfo = fareInfo;
}

public PassengerFare getPassengerFare() {
return passengerFare;
}

public void setPassengerFare(PassengerFare passengerFare) {
this.passengerFare = passengerFare;
}

}
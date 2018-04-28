package com.biletcim.entities.json;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class FareInfoL{
  @SerializedName("PassengerFare")
  @Expose
  private String PassengerFare;
  @SerializedName("FareReference")
  @Expose
  private List<FareReference> FareReference;
  public void setPassengerFare(String PassengerFare){
   this.PassengerFare=PassengerFare;
  }
  public String getPassengerFare(){
   return PassengerFare;
  }
  public List<FareReference> getFareReference() {
	return FareReference;
  }
  public void setFareReference(List<FareReference> fareReference) {
	FareReference = fareReference;
  }
  public FareInfoL(String passengerFare, List<com.biletcim.entities.json.FareReference> fareReference) {
	super();
	PassengerFare = passengerFare;
	FareReference = fareReference;
  }
  
  

  
  
}
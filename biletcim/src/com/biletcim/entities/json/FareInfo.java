package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class FareInfo{
  @SerializedName("PassengerFare")
  @Expose
  private String PassengerFare;
  @SerializedName("FareReference")
  @Expose
  private FareReference FareReference;
  public void setPassengerFare(String PassengerFare){
   this.PassengerFare=PassengerFare;
  }
  public String getPassengerFare(){
   return PassengerFare;
  }
  public void setFareReference(FareReference FareReference){
   this.FareReference=FareReference;
  }
  public FareReference getFareReference(){
   return FareReference;
  }
  
public FareInfo(String passengerFare, com.biletcim.entities.json.FareReference fareReference) {
	super();
	PassengerFare = passengerFare;
	FareReference = fareReference;
}
  
  
}
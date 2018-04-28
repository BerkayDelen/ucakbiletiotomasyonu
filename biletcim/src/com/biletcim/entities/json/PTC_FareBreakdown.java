package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class PTC_FareBreakdown{
  @SerializedName("FareBasisCodes")
  @Expose
  private FareBasisCodes FareBasisCodes;
  @SerializedName("PassengerTypeQuantity")
  @Expose
  private PassengerTypeQuantity PassengerTypeQuantity;
  @SerializedName("FareInfo")
  @Expose
  private FareInfo FareInfo;
  
  @SerializedName("PassengerFare")
  @Expose
  private PassengerFare PassengerFare;
  
  public void setFareBasisCodes(FareBasisCodes FareBasisCodes){
   this.FareBasisCodes=FareBasisCodes;
  }
  public FareBasisCodes getFareBasisCodes(){
   return FareBasisCodes;
  }
  public void setPassengerTypeQuantity(PassengerTypeQuantity PassengerTypeQuantity){
   this.PassengerTypeQuantity=PassengerTypeQuantity;
  }
  public PassengerTypeQuantity getPassengerTypeQuantity(){
   return PassengerTypeQuantity;
  }
  /*
  public void setFareInfo(FareInfo FareInfo){
   this.FareInfo=FareInfo;
  }
  public FareInfo getFareInfo(){
   return FareInfo;
  }
  */
  /*
  public void setPassengerFare(PassengerFare PassengerFare){
   this.PassengerFare=PassengerFare;
  }
  public PassengerFare getPassengerFare(){
   return PassengerFare;
  }
  */
}
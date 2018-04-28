package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ArrivalAirport{
  @SerializedName("LocationCode")
  @Expose
  private String LocationCode;
  public void setLocationCode(String LocationCode){
   this.LocationCode=LocationCode;
  }
  public String getLocationCode(){
   return LocationCode;
  }
}
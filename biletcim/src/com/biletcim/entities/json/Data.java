package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Data{
  @SerializedName("availabilityOTAResponse")
  @Expose
  private AvailabilityOTAResponse availabilityOTAResponse;
  public void setAvailabilityOTAResponse(AvailabilityOTAResponse availabilityOTAResponse){
   this.availabilityOTAResponse=availabilityOTAResponse;
  }
  public AvailabilityOTAResponse getAvailabilityOTAResponse(){
   return availabilityOTAResponse;
  }
}
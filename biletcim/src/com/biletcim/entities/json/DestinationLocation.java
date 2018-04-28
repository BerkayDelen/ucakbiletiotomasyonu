package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class DestinationLocation{
  @SerializedName("AlternateLocationInd")
  @Expose
  private Boolean AlternateLocationInd;
  @SerializedName("LocationCode")
  @Expose
  private String LocationCode;
  public void setAlternateLocationInd(Boolean AlternateLocationInd){
   this.AlternateLocationInd=AlternateLocationInd;
  }
  public Boolean getAlternateLocationInd(){
   return AlternateLocationInd;
  }
  public void setLocationCode(String LocationCode){
   this.LocationCode=LocationCode;
  }
  public String getLocationCode(){
   return LocationCode;
  }
}
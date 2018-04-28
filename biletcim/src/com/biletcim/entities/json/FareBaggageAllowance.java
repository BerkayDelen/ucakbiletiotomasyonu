package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class FareBaggageAllowance{
  @SerializedName("UnitOfMeasure")
  @Expose
  private String UnitOfMeasure;
  @SerializedName("UnitOfMeasureQuantity")
  @Expose
  private Integer UnitOfMeasureQuantity;
  @SerializedName("FlightSegmentRPH")
  @Expose
  private Integer FlightSegmentRPH;
  public void setUnitOfMeasure(String UnitOfMeasure){
   this.UnitOfMeasure=UnitOfMeasure;
  }
  public String getUnitOfMeasure(){
   return UnitOfMeasure;
  }
  public void setUnitOfMeasureQuantity(Integer UnitOfMeasureQuantity){
   this.UnitOfMeasureQuantity=UnitOfMeasureQuantity;
  }
  public Integer getUnitOfMeasureQuantity(){
   return UnitOfMeasureQuantity;
  }
  public void setFlightSegmentRPH(Integer FlightSegmentRPH){
   this.FlightSegmentRPH=FlightSegmentRPH;
  }
  public Integer getFlightSegmentRPH(){
   return FlightSegmentRPH;
  }
}
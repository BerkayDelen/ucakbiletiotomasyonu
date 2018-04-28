package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class OriginDestinationInformation{
  @SerializedName("OriginLocation")
  @Expose
  private OriginLocation OriginLocation;
  @SerializedName("OriginDestinationOptions")
  @Expose
  private OriginDestinationOptions OriginDestinationOptions;
  @SerializedName("DepartureDateTime")
  @Expose
  private String DepartureDateTime;
  @SerializedName("ArrivalDateTime")
  @Expose
  private String ArrivalDateTime;
  @SerializedName("RPH")
  @Expose
  private String RPH;
  @SerializedName("DestinationLocation")
  @Expose
  private DestinationLocation DestinationLocation;
  public void setOriginLocation(OriginLocation OriginLocation){
   this.OriginLocation=OriginLocation;
  }
  public OriginLocation getOriginLocation(){
   return OriginLocation;
  }
  public void setOriginDestinationOptions(OriginDestinationOptions OriginDestinationOptions){
   this.OriginDestinationOptions=OriginDestinationOptions;
  }
  public OriginDestinationOptions getOriginDestinationOptions(){
   return OriginDestinationOptions;
  }
  public void setDepartureDateTime(String DepartureDateTime){
   this.DepartureDateTime=DepartureDateTime;
  }
  public String getDepartureDateTime(){
   return DepartureDateTime;
  }
  public void setArrivalDateTime(String ArrivalDateTime){
   this.ArrivalDateTime=ArrivalDateTime;
  }
  public String getArrivalDateTime(){
   return ArrivalDateTime;
  }
  public void setRPH(String RPH){
   this.RPH=RPH;
  }
  public String getRPH(){
   return RPH;
  }
  public void setDestinationLocation(DestinationLocation DestinationLocation){
   this.DestinationLocation=DestinationLocation;
  }
  public DestinationLocation getDestinationLocation(){
   return DestinationLocation;
  }
}
package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ExtraOTAAvailabilityInfoList{
  @SerializedName("extraOTAFlightInfoListType")
  @Expose
  private ExtraOTAFlightInfoListType extraOTAFlightInfoListType;
  @SerializedName("isAllFlightsFullCodeShare")
  @Expose
  private Boolean isAllFlightsFullCodeShare;
  @SerializedName("isIndeedHasMoreFlightsForAnotherPortInTheSameCity")
  @Expose
  private Boolean isIndeedHasMoreFlightsForAnotherPortInTheSameCity;
  @SerializedName("RPH")
  @Expose
  private String RPH;
  public void setExtraOTAFlightInfoListType(ExtraOTAFlightInfoListType extraOTAFlightInfoListType){
   this.extraOTAFlightInfoListType=extraOTAFlightInfoListType;
  }
  public ExtraOTAFlightInfoListType getExtraOTAFlightInfoListType(){
   return extraOTAFlightInfoListType;
  }
  public void set›sAllFlightsFullCodeShare(Boolean isAllFlightsFullCodeShare){
   this.isAllFlightsFullCodeShare=isAllFlightsFullCodeShare;
  }
  public Boolean get›sAllFlightsFullCodeShare(){
   return isAllFlightsFullCodeShare;
  }
  public void set›sIndeedHasMoreFlightsForAnotherPortInTheSameCity(Boolean isIndeedHasMoreFlightsForAnotherPortInTheSameCity){
   this.isIndeedHasMoreFlightsForAnotherPortInTheSameCity=isIndeedHasMoreFlightsForAnotherPortInTheSameCity;
  }
  public Boolean get›sIndeedHasMoreFlightsForAnotherPortInTheSameCity(){
   return isIndeedHasMoreFlightsForAnotherPortInTheSameCity;
  }
  public void setRPH(String RPH){
   this.RPH=RPH;
  }
  public String getRPH(){
   return RPH;
  }
}
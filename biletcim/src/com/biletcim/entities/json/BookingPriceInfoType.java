package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class BookingPriceInfoType{
  @SerializedName("PTC_FareBreakdowns")
  @Expose
  private PTC_FareBreakdowns PTC_FareBreakdowns;
  public void setPTC_FareBreakdowns(PTC_FareBreakdowns PTC_FareBreakdowns){
   this.PTC_FareBreakdowns=PTC_FareBreakdowns;
  }
  public PTC_FareBreakdowns getPTC_FareBreakdowns(){
   return PTC_FareBreakdowns;
  }
}
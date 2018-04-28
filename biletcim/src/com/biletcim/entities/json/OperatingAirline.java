package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class OperatingAirline{
  @SerializedName("CompanyShortName")
  @Expose
  private String CompanyShortName;
  public void setCompanyShortName(String CompanyShortName){
   this.CompanyShortName=CompanyShortName;
  }
  public String getCompanyShortName(){
   return CompanyShortName;
  }
}
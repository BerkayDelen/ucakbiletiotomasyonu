package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Equipment{
  @SerializedName("Value")
  @Expose
  private String Value;
  @SerializedName("AirEquipType")
  @Expose
  private String AirEquipType;
  public void setValue(String Value){
   this.Value=Value;
  }
  public String getValue(){
   return Value;
  }
  public void setAirEquipType(String AirEquipType){
   this.AirEquipType=AirEquipType;
  }
  public String getAirEquipType(){
   return AirEquipType;
  }
}
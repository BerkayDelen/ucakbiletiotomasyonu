package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class FareBasisCodes{
  @SerializedName("FareBasisCode")
  @Expose
  private String FareBasisCode;
  public void setFareBasisCode(String FareBasisCode){
   this.FareBasisCode=FareBasisCode;
  }
  public String getFareBasisCode(){
   return FareBasisCode;
  }
}
package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ExtraOTAAvailabilityInfoListType{
  @SerializedName("extraOTAAvailabilityInfoList")
  @Expose
  private ExtraOTAAvailabilityInfoList extraOTAAvailabilityInfoList;
  public void setExtraOTAAvailabilityInfoList(ExtraOTAAvailabilityInfoList extraOTAAvailabilityInfoList){
   this.extraOTAAvailabilityInfoList=extraOTAAvailabilityInfoList;
  }
  public ExtraOTAAvailabilityInfoList getExtraOTAAvailabilityInfoList(){
   return extraOTAAvailabilityInfoList;
  }
}
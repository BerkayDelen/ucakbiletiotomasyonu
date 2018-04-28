package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class CreateOTAAirRoute{
  @SerializedName("extraOTAAvailabilityInfoListType")
  @Expose
  private ExtraOTAAvailabilityInfoListType extraOTAAvailabilityInfoListType;
  @SerializedName("OTA_AirAvailRS")
  @Expose
  private OTA_AirAvailRS OTA_AirAvailRS;
  public void setExtraOTAAvailabilityInfoListType(ExtraOTAAvailabilityInfoListType extraOTAAvailabilityInfoListType){
   this.extraOTAAvailabilityInfoListType=extraOTAAvailabilityInfoListType;
  }
  public ExtraOTAAvailabilityInfoListType getExtraOTAAvailabilityInfoListType(){
   return extraOTAAvailabilityInfoListType;
  }
  public void setOTA_AirAvailRS(OTA_AirAvailRS OTA_AirAvailRS){
   this.OTA_AirAvailRS=OTA_AirAvailRS;
  }
  public OTA_AirAvailRS getOTA_AirAvailRS(){
   return OTA_AirAvailRS;
  }
}
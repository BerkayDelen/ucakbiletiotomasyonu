package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ExtraOTASegmentInfoListType{
  @SerializedName("extraOTASegmentInfoList")
  @Expose
  private ExtraOTASegmentInfoList extraOTASegmentInfoList;
  public void setExtraOTASegmentInfoList(ExtraOTASegmentInfoList extraOTASegmentInfoList){
   this.extraOTASegmentInfoList=extraOTASegmentInfoList;
  }
  public ExtraOTASegmentInfoList getExtraOTASegmentInfoList(){
   return extraOTASegmentInfoList;
  }
}
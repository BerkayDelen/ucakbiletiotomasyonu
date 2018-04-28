package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class ExtraOTAFlightInfoListType{
  @SerializedName("extraOTAFlightInfoList")
  @Expose
  private List<ExtraOTAFlightInfoList> extraOTAFlightInfoList;
  public void setExtraOTAFlightInfoList(List<ExtraOTAFlightInfoList> extraOTAFlightInfoList){
   this.extraOTAFlightInfoList=extraOTAFlightInfoList;
  }
  public List<ExtraOTAFlightInfoList> getExtraOTAFlightInfoList(){
   return extraOTAFlightInfoList;
  }
}
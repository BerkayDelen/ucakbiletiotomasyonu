package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class OriginDestinationOptions{
  @SerializedName("OriginDestinationOption")
  @Expose
  private List<OriginDestinationOption> OriginDestinationOption;
  public void setOriginDestinationOption(List<OriginDestinationOption> OriginDestinationOption){
   this.OriginDestinationOption=OriginDestinationOption;
  }
  public List<OriginDestinationOption> getOriginDestinationOption(){
   return OriginDestinationOption;
  }
}
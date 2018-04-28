package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class PTC_FareBreakdowns{
  @SerializedName("PTC_FareBreakdown")
  @Expose
  private List<PTC_FareBreakdown> PTC_FareBreakdown;
  
  
  
  public PTC_FareBreakdowns(List<com.biletcim.entities.json.PTC_FareBreakdown> pTC_FareBreakdown) {
	super();
	PTC_FareBreakdown = pTC_FareBreakdown;
}
public void setPTC_FareBreakdown(List<PTC_FareBreakdown> PTC_FareBreakdown){
   this.PTC_FareBreakdown=PTC_FareBreakdown;
  }
  public List<PTC_FareBreakdown> getPTC_FareBreakdown(){
   return PTC_FareBreakdown;
  }
  
  
  
  
}
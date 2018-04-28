package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Taxes{
  @SerializedName("Tax")
  @Expose
  private List<Tax> Tax;
  public void setTax(List<Tax> Tax){
   this.Tax=Tax;
  }
  public List<Tax> getTax(){
   return Tax;
  }
}
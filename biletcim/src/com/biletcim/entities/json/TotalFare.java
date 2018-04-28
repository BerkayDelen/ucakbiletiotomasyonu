package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class TotalFare{
  @SerializedName("CurrencyCode")
  @Expose
  private String CurrencyCode;
  @SerializedName("Amount")
  @Expose
  private Double Amount;
  public void setCurrencyCode(String CurrencyCode){
   this.CurrencyCode=CurrencyCode;
  }
  public String getCurrencyCode(){
   return CurrencyCode;
  }
  public void setAmount(Double Amount){
   this.Amount=Amount;
  }
  public Double getAmount(){
   return Amount;
  }
}
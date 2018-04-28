package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Tax{
  @SerializedName("CurrencyCode")
  @Expose
  private String CurrencyCode;
  @SerializedName("TaxCode")
  @Expose
  private String TaxCode;
  @SerializedName("Amount")
  @Expose
  private Double Amount;
  @SerializedName("RefundableInd")
  @Expose
  private Boolean RefundableInd;
  public void setCurrencyCode(String CurrencyCode){
   this.CurrencyCode=CurrencyCode;
  }
  public String getCurrencyCode(){
   return CurrencyCode;
  }
  public void setTaxCode(String TaxCode){
   this.TaxCode=TaxCode;
  }
  public String getTaxCode(){
   return TaxCode;
  }
  public void setAmount(Double Amount){
   this.Amount=Amount;
  }
  public Double getAmount(){
   return Amount;
  }
  public void setRefundableInd(Boolean RefundableInd){
   this.RefundableInd=RefundableInd;
  }
  public Boolean getRefundableInd(){
   return RefundableInd;
  }
}
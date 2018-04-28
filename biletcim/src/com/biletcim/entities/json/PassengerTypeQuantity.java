package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class PassengerTypeQuantity{
  @SerializedName("Quantity")
  @Expose
  private Integer Quantity;
  @SerializedName("Code")
  @Expose
  private String Code;
  public void setQuantity(Integer Quantity){
   this.Quantity=Quantity;
  }
  public Integer getQuantity(){
   return Quantity;
  }
  public void setCode(String Code){
   this.Code=Code;
  }
  public String getCode(){
   return Code;
  }
}
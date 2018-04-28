package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class BookingClassAvail{
  @SerializedName("ResBookDesigQuantity")
  @Expose
  private Integer ResBookDesigQuantity;
  @SerializedName("ResBookDesigStatusCode")
  @Expose
  private String ResBookDesigStatusCode;
  @SerializedName("ResBookDesigCode")
  @Expose
  private String ResBookDesigCode;
  @SerializedName("RPH")
  @Expose
  private String RPH;
  public void setResBookDesigQuantity(Integer ResBookDesigQuantity){
   this.ResBookDesigQuantity=ResBookDesigQuantity;
  }
  public Integer getResBookDesigQuantity(){
   return ResBookDesigQuantity;
  }
  public void setResBookDesigStatusCode(String ResBookDesigStatusCode){
   this.ResBookDesigStatusCode=ResBookDesigStatusCode;
  }
  public String getResBookDesigStatusCode(){
   return ResBookDesigStatusCode;
  }
  public void setResBookDesigCode(String ResBookDesigCode){
   this.ResBookDesigCode=ResBookDesigCode;
  }
  public String getResBookDesigCode(){
   return ResBookDesigCode;
  }
  public void setRPH(String RPH){
   this.RPH=RPH;
  }
  public String getRPH(){
   return RPH;
  }
}
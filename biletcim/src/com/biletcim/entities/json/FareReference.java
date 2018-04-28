package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class FareReference{
  @SerializedName("ResBookDesigCode")
  @Expose
  private String ResBookDesigCode;
  @SerializedName("content")
  @Expose
  private String content;
  public void setResBookDesigCode(String ResBookDesigCode){
   this.ResBookDesigCode=ResBookDesigCode;
  }
  public String getResBookDesigCode(){
   return ResBookDesigCode;
  }
  public void setContent(String content){
   this.content=content;
  }
  public String getContent(){
   return content;
  }
}
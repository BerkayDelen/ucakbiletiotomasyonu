package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Message{
  @SerializedName("code")
  @Expose
  private String code;
  @SerializedName("description")
  @Expose
  private String description;
  public void setCode(String code){
   this.code=code;
  }
  public String getCode(){
   return code;
  }
  public void setDescription(String description){
   this.description=description;
  }
  public String getDescription(){
   return description;
  }
}
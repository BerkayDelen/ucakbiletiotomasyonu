package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class TRAirline{
  @SerializedName("data")
  @Expose
  private Data data;
  @SerializedName("requestId")
  @Expose
  private String requestId;
  @SerializedName("message")
  @Expose
  private Message message;
  @SerializedName("status")
  @Expose
  private String status;
  public void setData(Data data){
   this.data=data;
  }
  public Data getData(){
   return data;
  }
  public void setRequestId(String requestId){
   this.requestId=requestId;
  }
  public String getRequestId(){
   return requestId;
  }
  public void setMessage(Message message){
   this.message=message;
  }
  public Message getMessage(){
   return message;
  }
  public void setStatus(String status){
   this.status=status;
  }
  public String getStatus(){
   return status;
  }
}
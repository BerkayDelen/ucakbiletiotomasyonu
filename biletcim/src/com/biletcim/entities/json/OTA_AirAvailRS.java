package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class OTA_AirAvailRS{
  @SerializedName("Comment")
  @Expose
  private String Comment;
  @SerializedName("OriginDestinationInformation")
  @Expose
  private OriginDestinationInformation OriginDestinationInformation;
  @SerializedName("Version")
  @Expose
  private Integer Version;
  public void setComment(String Comment){
   this.Comment=Comment;
  }
  public String getComment(){
   return Comment;
  }
  public void setOriginDestinationInformation(OriginDestinationInformation OriginDestinationInformation){
   this.OriginDestinationInformation=OriginDestinationInformation;
  }
  public OriginDestinationInformation getOriginDestinationInformation(){
   return OriginDestinationInformation;
  }
  public void setVersion(Integer Version){
   this.Version=Version;
  }
  public Integer getVersion(){
   return Version;
  }
}
package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class AvailabilityOTAResponse{
  @SerializedName("createOTAAirRoute")
  @Expose
  private CreateOTAAirRoute createOTAAirRoute;
  @SerializedName("isMixCabin")
  @Expose
  private Boolean isMixCabin;
  public void setCreateOTAAirRoute(CreateOTAAirRoute createOTAAirRoute){
   this.createOTAAirRoute=createOTAAirRoute;
  }
  public CreateOTAAirRoute getCreateOTAAirRoute(){
   return createOTAAirRoute;
  }
  public void set›sMixCabin(Boolean isMixCabin){
   this.isMixCabin=isMixCabin;
  }
  public Boolean get›sMixCabin(){
   return isMixCabin;
  }
}
package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ExtraOTASegmentInfoList{
  @SerializedName("isAvailable")
  @Expose
  private Boolean isAvailable;
  @SerializedName("isConnected")
  @Expose
  private Boolean isConnected;
  @SerializedName("segmentIndex")
  @Expose
  private Integer segmentIndex;
  @SerializedName("isAnadoluJetSegment")
  @Expose
  private Boolean isAnadoluJetSegment;
  @SerializedName("isDomestic")
  @Expose
  private Boolean isDomestic;
  @SerializedName("isStandBySeat")
  @Expose
  private Boolean isStandBySeat;
  public void set›sAvailable(Boolean isAvailable){
   this.isAvailable=isAvailable;
  }
  public Boolean get›sAvailable(){
   return isAvailable;
  }
  public void set›sConnected(Boolean isConnected){
   this.isConnected=isConnected;
  }
  public Boolean get›sConnected(){
   return isConnected;
  }
  public void setSegmentIndex(Integer segmentIndex){
   this.segmentIndex=segmentIndex;
  }
  public Integer getSegmentIndex(){
   return segmentIndex;
  }
  public void set›sAnadoluJetSegment(Boolean isAnadoluJetSegment){
   this.isAnadoluJetSegment=isAnadoluJetSegment;
  }
  public Boolean get›sAnadoluJetSegment(){
   return isAnadoluJetSegment;
  }
  public void set›sDomestic(Boolean isDomestic){
   this.isDomestic=isDomestic;
  }
  public Boolean get›sDomestic(){
   return isDomestic;
  }
  public void set›sStandBySeat(Boolean isStandBySeat){
   this.isStandBySeat=isStandBySeat;
  }
  public Boolean get›sStandBySeat(){
   return isStandBySeat;
  }
}
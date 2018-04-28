package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ExtraOTAFlightInfoList{
  @SerializedName("isPureAnadoluJetFlight")
  @Expose
  private Boolean isPureAnadoluJetFlight;
  /*@SerializedName("extraOTASegmentInfoListType")
  @Expose
  private ExtraOTASegmentInfoListType extraOTASegmentInfoListType;*/
  @SerializedName("StandbyIndicator")
  @Expose
  private Boolean StandbyIndicator;
  @SerializedName("isElectronicTicketAvailable")
  @Expose
  private Boolean isElectronicTicketAvailable;
  @SerializedName("isCodeShare")
  @Expose
  private Boolean isCodeShare;
  @SerializedName("isFullCodeShare")
  @Expose
  private Boolean isFullCodeShare;
  @SerializedName("bookingPriceInfoType")
  @Expose
  private BookingPriceInfoType bookingPriceInfoType;
  @SerializedName("isDomestic")
  @Expose
  private Boolean isDomestic;
  @SerializedName("isFullInternational")
  @Expose
  private Boolean isFullInternational;
  @SerializedName("flightNumber")
  @Expose
  private String flightNumber;
  @SerializedName("isFullAvailable")
  @Expose
  private Boolean isFullAvailable;
  public void set›sPureAnadoluJetFlight(Boolean isPureAnadoluJetFlight){
   this.isPureAnadoluJetFlight=isPureAnadoluJetFlight;
  }
  public Boolean get›sPureAnadoluJetFlight(){
   return isPureAnadoluJetFlight;
  }
  /*
  public void setExtraOTASegmentInfoListType(ExtraOTASegmentInfoListType extraOTASegmentInfoListType){
   this.extraOTASegmentInfoListType=extraOTASegmentInfoListType;
  }
  public ExtraOTASegmentInfoListType getExtraOTASegmentInfoListType(){
   return extraOTASegmentInfoListType;
  }
  */
  public void setStandbyIndicator(Boolean StandbyIndicator){
   this.StandbyIndicator=StandbyIndicator;
  }
  public Boolean getStandbyIndicator(){
   return StandbyIndicator;
  }
  public void set›sElectronicTicketAvailable(Boolean isElectronicTicketAvailable){
   this.isElectronicTicketAvailable=isElectronicTicketAvailable;
  }
  public Boolean get›sElectronicTicketAvailable(){
   return isElectronicTicketAvailable;
  }
  public void set›sCodeShare(Boolean isCodeShare){
   this.isCodeShare=isCodeShare;
  }
  public Boolean get›sCodeShare(){
   return isCodeShare;
  }
  public void set›sFullCodeShare(Boolean isFullCodeShare){
   this.isFullCodeShare=isFullCodeShare;
  }
  public Boolean get›sFullCodeShare(){
   return isFullCodeShare;
  }
  public void setBookingPriceInfoType(BookingPriceInfoType bookingPriceInfoType){
   this.bookingPriceInfoType=bookingPriceInfoType;
  }
  public BookingPriceInfoType getBookingPriceInfoType(){
   return bookingPriceInfoType;
  }
  public void set›sDomestic(Boolean isDomestic){
   this.isDomestic=isDomestic;
  }
  public Boolean get›sDomestic(){
   return isDomestic;
  }
  public void set›sFullInternational(Boolean isFullInternational){
   this.isFullInternational=isFullInternational;
  }
  public Boolean get›sFullInternational(){
   return isFullInternational;
  }
  public void setFlightNumber(String flightNumber){
   this.flightNumber=flightNumber;
  }
  public String getFlightNumber(){
   return flightNumber;
  }
  public void set›sFullAvailable(Boolean isFullAvailable){
   this.isFullAvailable=isFullAvailable;
  }
  public Boolean get›sFullAvailable(){
   return isFullAvailable;
  }
}
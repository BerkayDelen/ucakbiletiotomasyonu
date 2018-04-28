package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class FlightSegment{
  @SerializedName("DepartureAirport")
  @Expose
  private DepartureAirport DepartureAirport;
  @SerializedName("Ticket")
  @Expose
  private String Ticket;
  @SerializedName("ArrivalAirport")
  @Expose
  private ArrivalAirport ArrivalAirport;
  /*
  @SerializedName("BookingClassAvail")
  @Expose
  private List<BookingClassAvail> BookingClassAvail;
  */
  @SerializedName("DateChangeNbr")
  @Expose
  private Boolean DateChangeNbr;
  @SerializedName("StopQuantity")
  @Expose
  private Integer StopQuantity;
  @SerializedName("CodeshareInd")
  @Expose
  private Boolean CodeshareInd;
  @SerializedName("Equipment")
  @Expose
  private Equipment Equipment;
  @SerializedName("DepartureDateTime")
  @Expose
  private String DepartureDateTime;
  @SerializedName("ArrivalDateTime")
  @Expose
  private String ArrivalDateTime;
  @SerializedName("FlightNumber")
  @Expose
  private String FlightNumber;
  @SerializedName("OperatingAirline")
  @Expose
  private OperatingAirline OperatingAirline;
  @SerializedName("JourneyDuration")
  @Expose
  private String JourneyDuration;
  public void setDepartureAirport(DepartureAirport DepartureAirport){
   this.DepartureAirport=DepartureAirport;
  }
  public DepartureAirport getDepartureAirport(){
   return DepartureAirport;
  }
  public void setTicket(String Ticket){
   this.Ticket=Ticket;
  }
  public String getTicket(){
   return Ticket;
  }
 
  public void setArrivalAirport(ArrivalAirport ArrivalAirport){
   this.ArrivalAirport=ArrivalAirport;
  }
  public ArrivalAirport getArrivalAirport(){
   return ArrivalAirport;
  }
  /*
  public void setBookingClassAvail(List<BookingClassAvail> BookingClassAvail){
   this.BookingClassAvail=BookingClassAvail;
  }
  public List<BookingClassAvail> getBookingClassAvail(){
   return BookingClassAvail;
  }
  */
  public void setDateChangeNbr(Boolean DateChangeNbr){
   this.DateChangeNbr=DateChangeNbr;
  }
  public Boolean getDateChangeNbr(){
   return DateChangeNbr;
  }
  public void setStopQuantity(Integer StopQuantity){
   this.StopQuantity=StopQuantity;
  }
  public Integer getStopQuantity(){
   return StopQuantity;
  }
  public void setCodeshareInd(Boolean CodeshareInd){
   this.CodeshareInd=CodeshareInd;
  }
  public Boolean getCodeshareInd(){
   return CodeshareInd;
  }
  public void setEquipment(Equipment Equipment){
   this.Equipment=Equipment;
  }
  public Equipment getEquipment(){
   return Equipment;
  }
  public void setDepartureDateTime(String DepartureDateTime){
   this.DepartureDateTime=DepartureDateTime;
  }
  public String getDepartureDateTime(){
   return DepartureDateTime;
  }
  public void setArrivalDateTime(String ArrivalDateTime){
   this.ArrivalDateTime=ArrivalDateTime;
  }
  public String getArrivalDateTime(){
   return ArrivalDateTime;
  }
  public void setFlightNumber(String FlightNumber){
   this.FlightNumber=FlightNumber;
  }
  public String getFlightNumber(){
   return FlightNumber;
  }
  public void setOperatingAirline(OperatingAirline OperatingAirline){
   this.OperatingAirline=OperatingAirline;
  }
  public OperatingAirline getOperatingAirline(){
   return OperatingAirline;
  }
  public void setJourneyDuration(String JourneyDuration){
   this.JourneyDuration=JourneyDuration;
  }
  public String getJourneyDuration(){
   return JourneyDuration;
  }
}
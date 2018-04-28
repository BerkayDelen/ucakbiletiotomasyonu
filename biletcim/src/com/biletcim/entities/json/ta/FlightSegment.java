package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightSegment {

@SerializedName("DepartureAirport")
@Expose
private DepartureAirport departureAirport;
@SerializedName("Ticket")
@Expose
private String ticket;
@SerializedName("ArrivalAirport")
@Expose
private ArrivalAirport arrivalAirport;
@SerializedName("BookingClassAvail")
@Expose
private BookingClassAvail bookingClassAvail;
@SerializedName("DateChangeNbr")
@Expose
private Boolean dateChangeNbr;
@SerializedName("StopQuantity")
@Expose
private String stopQuantity;
@SerializedName("GroundDuration")
@Expose
private String groundDuration;
@SerializedName("CodeshareInd")
@Expose
private Boolean codeshareInd;
@SerializedName("Equipment")
@Expose
private Equipment equipment;
@SerializedName("DepartureDateTime")
@Expose
private String departureDateTime;
@SerializedName("ArrivalDateTime")
@Expose
private String arrivalDateTime;
@SerializedName("FlightNumber")
@Expose
private String flightNumber;
@SerializedName("OperatingAirline")
@Expose
private OperatingAirline operatingAirline;
@SerializedName("JourneyDuration")
@Expose
private String journeyDuration;

public DepartureAirport getDepartureAirport() {
return departureAirport;
}

public void setDepartureAirport(DepartureAirport departureAirport) {
this.departureAirport = departureAirport;
}

public String getTicket() {
return ticket;
}

public void setTicket(String ticket) {
this.ticket = ticket;
}

public ArrivalAirport getArrivalAirport() {
return arrivalAirport;
}

public void setArrivalAirport(ArrivalAirport arrivalAirport) {
this.arrivalAirport = arrivalAirport;
}

public BookingClassAvail getBookingClassAvail() {
return bookingClassAvail;
}

public void setBookingClassAvail(BookingClassAvail bookingClassAvail) {
this.bookingClassAvail = bookingClassAvail;
}

public Boolean getDateChangeNbr() {
return dateChangeNbr;
}

public void setDateChangeNbr(Boolean dateChangeNbr) {
this.dateChangeNbr = dateChangeNbr;
}

public String getStopQuantity() {
return stopQuantity;
}

public void setStopQuantity(String stopQuantity) {
this.stopQuantity = stopQuantity;
}

public String getGroundDuration() {
return groundDuration;
}

public void setGroundDuration(String groundDuration) {
this.groundDuration = groundDuration;
}

public Boolean getCodeshareInd() {
return codeshareInd;
}

public void setCodeshareInd(Boolean codeshareInd) {
this.codeshareInd = codeshareInd;
}

public Equipment getEquipment() {
return equipment;
}

public void setEquipment(Equipment equipment) {
this.equipment = equipment;
}

public String getDepartureDateTime() {
return departureDateTime;
}

public void setDepartureDateTime(String departureDateTime) {
this.departureDateTime = departureDateTime;
}

public String getArrivalDateTime() {
return arrivalDateTime;
}

public void setArrivalDateTime(String arrivalDateTime) {
this.arrivalDateTime = arrivalDateTime;
}

public String getFlightNumber() {
return flightNumber;
}

public void setFlightNumber(String flightNumber) {
this.flightNumber = flightNumber;
}

public OperatingAirline getOperatingAirline() {
return operatingAirline;
}

public void setOperatingAirline(OperatingAirline operatingAirline) {
this.operatingAirline = operatingAirline;
}

public String getJourneyDuration() {
return journeyDuration;
}

public void setJourneyDuration(String journeyDuration) {
this.journeyDuration = journeyDuration;
}

}
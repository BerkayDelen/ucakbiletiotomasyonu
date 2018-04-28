package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraOTAFlightInfoList {

@SerializedName("isPureAnadoluJetFlight")
@Expose
private Boolean isPureAnadoluJetFlight;
@SerializedName("extraOTASegmentInfoListType")
@Expose
private ExtraOTASegmentInfoListType extraOTASegmentInfoListType;
@SerializedName("StandbyIndicator")
@Expose
private Boolean standbyIndicator;
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

public Boolean getIsPureAnadoluJetFlight() {
return isPureAnadoluJetFlight;
}

public void setIsPureAnadoluJetFlight(Boolean isPureAnadoluJetFlight) {
this.isPureAnadoluJetFlight = isPureAnadoluJetFlight;
}

public ExtraOTASegmentInfoListType getExtraOTASegmentInfoListType() {
return extraOTASegmentInfoListType;
}

public void setExtraOTASegmentInfoListType(ExtraOTASegmentInfoListType extraOTASegmentInfoListType) {
this.extraOTASegmentInfoListType = extraOTASegmentInfoListType;
}

public Boolean getStandbyIndicator() {
return standbyIndicator;
}

public void setStandbyIndicator(Boolean standbyIndicator) {
this.standbyIndicator = standbyIndicator;
}

public Boolean getIsElectronicTicketAvailable() {
return isElectronicTicketAvailable;
}

public void setIsElectronicTicketAvailable(Boolean isElectronicTicketAvailable) {
this.isElectronicTicketAvailable = isElectronicTicketAvailable;
}

public Boolean getIsCodeShare() {
return isCodeShare;
}

public void setIsCodeShare(Boolean isCodeShare) {
this.isCodeShare = isCodeShare;
}

public Boolean getIsFullCodeShare() {
return isFullCodeShare;
}

public void setIsFullCodeShare(Boolean isFullCodeShare) {
this.isFullCodeShare = isFullCodeShare;
}

public BookingPriceInfoType getBookingPriceInfoType() {
return bookingPriceInfoType;
}

public void setBookingPriceInfoType(BookingPriceInfoType bookingPriceInfoType) {
this.bookingPriceInfoType = bookingPriceInfoType;
}

public Boolean getIsDomestic() {
return isDomestic;
}

public void setIsDomestic(Boolean isDomestic) {
this.isDomestic = isDomestic;
}

public Boolean getIsFullInternational() {
return isFullInternational;
}

public void setIsFullInternational(Boolean isFullInternational) {
this.isFullInternational = isFullInternational;
}

public String getFlightNumber() {
return flightNumber;
}

public void setFlightNumber(String flightNumber) {
this.flightNumber = flightNumber;
}

public Boolean getIsFullAvailable() {
return isFullAvailable;
}

public void setIsFullAvailable(Boolean isFullAvailable) {
this.isFullAvailable = isFullAvailable;
}

}
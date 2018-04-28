package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraOTAAvailabilityInfoList {

@SerializedName("extraOTAFlightInfoListType")
@Expose
private ExtraOTAFlightInfoListType extraOTAFlightInfoListType;
@SerializedName("isAllFlightsFullCodeShare")
@Expose
private Boolean isAllFlightsFullCodeShare;
@SerializedName("isIndeedHasMoreFlightsForAnotherPortInTheSameCity")
@Expose
private Boolean isIndeedHasMoreFlightsForAnotherPortInTheSameCity;
@SerializedName("RPH")
@Expose
private String rPH;

public ExtraOTAFlightInfoListType getExtraOTAFlightInfoListType() {
return extraOTAFlightInfoListType;
}

public void setExtraOTAFlightInfoListType(ExtraOTAFlightInfoListType extraOTAFlightInfoListType) {
this.extraOTAFlightInfoListType = extraOTAFlightInfoListType;
}

public Boolean getIsAllFlightsFullCodeShare() {
return isAllFlightsFullCodeShare;
}

public void setIsAllFlightsFullCodeShare(Boolean isAllFlightsFullCodeShare) {
this.isAllFlightsFullCodeShare = isAllFlightsFullCodeShare;
}

public Boolean getIsIndeedHasMoreFlightsForAnotherPortInTheSameCity() {
return isIndeedHasMoreFlightsForAnotherPortInTheSameCity;
}

public void setIsIndeedHasMoreFlightsForAnotherPortInTheSameCity(Boolean isIndeedHasMoreFlightsForAnotherPortInTheSameCity) {
this.isIndeedHasMoreFlightsForAnotherPortInTheSameCity = isIndeedHasMoreFlightsForAnotherPortInTheSameCity;
}

public String getRPH() {
return rPH;
}

public void setRPH(String rPH) {
this.rPH = rPH;
}

}
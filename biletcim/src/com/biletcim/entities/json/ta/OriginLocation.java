package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginLocation {

@SerializedName("AlternateLocationInd")
@Expose
private Boolean alternateLocationInd;
@SerializedName("LocationCode")
@Expose
private String locationCode;

public Boolean getAlternateLocationInd() {
return alternateLocationInd;
}

public void setAlternateLocationInd(Boolean alternateLocationInd) {
this.alternateLocationInd = alternateLocationInd;
}

public String getLocationCode() {
return locationCode;
}

public void setLocationCode(String locationCode) {
this.locationCode = locationCode;
}

}
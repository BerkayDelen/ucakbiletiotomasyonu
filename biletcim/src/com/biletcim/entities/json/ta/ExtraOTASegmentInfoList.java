package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraOTASegmentInfoList {

@SerializedName("isAvailable")
@Expose
private Boolean isAvailable;
@SerializedName("isConnected")
@Expose
private Boolean isConnected;
@SerializedName("segmentIndex")
@Expose
private String segmentIndex;
@SerializedName("isAnadoluJetSegment")
@Expose
private Boolean isAnadoluJetSegment;
@SerializedName("isDomestic")
@Expose
private Boolean isDomestic;
@SerializedName("isStandBySeat")
@Expose
private Boolean isStandBySeat;

public Boolean getIsAvailable() {
return isAvailable;
}

public void setIsAvailable(Boolean isAvailable) {
this.isAvailable = isAvailable;
}

public Boolean getIsConnected() {
return isConnected;
}

public void setIsConnected(Boolean isConnected) {
this.isConnected = isConnected;
}

public String getSegmentIndex() {
return segmentIndex;
}

public void setSegmentIndex(String segmentIndex) {
this.segmentIndex = segmentIndex;
}

public Boolean getIsAnadoluJetSegment() {
return isAnadoluJetSegment;
}

public void setIsAnadoluJetSegment(Boolean isAnadoluJetSegment) {
this.isAnadoluJetSegment = isAnadoluJetSegment;
}

public Boolean getIsDomestic() {
return isDomestic;
}

public void setIsDomestic(Boolean isDomestic) {
this.isDomestic = isDomestic;
}

public Boolean getIsStandBySeat() {
return isStandBySeat;
}

public void setIsStandBySeat(Boolean isStandBySeat) {
this.isStandBySeat = isStandBySeat;
}

}
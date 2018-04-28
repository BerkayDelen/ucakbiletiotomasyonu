package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateOTAAirRoute {

@SerializedName("extraOTAAvailabilityInfoListType")
@Expose
private ExtraOTAAvailabilityInfoListType extraOTAAvailabilityInfoListType;
@SerializedName("OTA_AirAvailRS")
@Expose
private OTAAirAvailRS oTAAirAvailRS;

public ExtraOTAAvailabilityInfoListType getExtraOTAAvailabilityInfoListType() {
return extraOTAAvailabilityInfoListType;
}

public void setExtraOTAAvailabilityInfoListType(ExtraOTAAvailabilityInfoListType extraOTAAvailabilityInfoListType) {
this.extraOTAAvailabilityInfoListType = extraOTAAvailabilityInfoListType;
}

public OTAAirAvailRS getOTAAirAvailRS() {
return oTAAirAvailRS;
}

public void setOTAAirAvailRS(OTAAirAvailRS oTAAirAvailRS) {
this.oTAAirAvailRS = oTAAirAvailRS;
}

}
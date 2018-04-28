
package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraOTAAvailabilityInfoListType {

@SerializedName("extraOTAAvailabilityInfoList")
@Expose
private ExtraOTAAvailabilityInfoList extraOTAAvailabilityInfoList;

public ExtraOTAAvailabilityInfoList getExtraOTAAvailabilityInfoList() {
return extraOTAAvailabilityInfoList;
}

public void setExtraOTAAvailabilityInfoList(ExtraOTAAvailabilityInfoList extraOTAAvailabilityInfoList) {
this.extraOTAAvailabilityInfoList = extraOTAAvailabilityInfoList;
}

}
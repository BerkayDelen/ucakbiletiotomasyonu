package com.biletcim.entities.json.ta;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraOTAFlightInfoListType {

@SerializedName("extraOTAFlightInfoList")
@Expose
private List<ExtraOTAFlightInfoList> extraOTAFlightInfoList = null;

public List<ExtraOTAFlightInfoList> getExtraOTAFlightInfoList() {
return extraOTAFlightInfoList;
}

public void setExtraOTAFlightInfoList(List<ExtraOTAFlightInfoList> extraOTAFlightInfoList) {
this.extraOTAFlightInfoList = extraOTAFlightInfoList;
}

}
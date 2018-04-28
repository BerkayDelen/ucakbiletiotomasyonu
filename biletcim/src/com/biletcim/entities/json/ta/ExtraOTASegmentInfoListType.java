package com.biletcim.entities.json.ta;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraOTASegmentInfoListType {

@SerializedName("extraOTASegmentInfoList")
@Expose
private List<ExtraOTASegmentInfoList> extraOTASegmentInfoList = null;

public List<ExtraOTASegmentInfoList> getExtraOTASegmentInfoList() {
return extraOTASegmentInfoList;
}

public void setExtraOTASegmentInfoList(List<ExtraOTASegmentInfoList> extraOTASegmentInfoList) {
this.extraOTASegmentInfoList = extraOTASegmentInfoList;
}

}
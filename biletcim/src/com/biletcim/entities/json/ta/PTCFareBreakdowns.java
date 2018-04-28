package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PTCFareBreakdowns {

@SerializedName("PTC_FareBreakdown")
@Expose
private PTCFareBreakdown pTCFareBreakdown;

public PTCFareBreakdown getPTCFareBreakdown() {
return pTCFareBreakdown;
}

public void setPTCFareBreakdown(PTCFareBreakdown pTCFareBreakdown) {
this.pTCFareBreakdown = pTCFareBreakdown;
}

}
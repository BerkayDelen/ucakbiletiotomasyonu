package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingPriceInfoType {

@SerializedName("PTC_FareBreakdowns")
@Expose
private PTCFareBreakdowns pTCFareBreakdowns;

public PTCFareBreakdowns getPTCFareBreakdowns() {
return pTCFareBreakdowns;
}

public void setPTCFareBreakdowns(PTCFareBreakdowns pTCFareBreakdowns) {
this.pTCFareBreakdowns = pTCFareBreakdowns;
}

}
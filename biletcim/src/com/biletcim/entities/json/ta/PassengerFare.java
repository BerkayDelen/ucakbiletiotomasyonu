package com.biletcim.entities.json.ta;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassengerFare {

@SerializedName("TotalFare")
@Expose
private TotalFare totalFare;
@SerializedName("Taxes")
@Expose
private Taxes taxes;
@SerializedName("BaseFare")
@Expose
private BaseFare baseFare;
@SerializedName("FareBaggageAllowance")
@Expose
private List<FareBaggageAllowance> fareBaggageAllowance = null;

public TotalFare getTotalFare() {
return totalFare;
}

public void setTotalFare(TotalFare totalFare) {
this.totalFare = totalFare;
}

public Taxes getTaxes() {
return taxes;
}

public void setTaxes(Taxes taxes) {
this.taxes = taxes;
}

public BaseFare getBaseFare() {
return baseFare;
}

public void setBaseFare(BaseFare baseFare) {
this.baseFare = baseFare;
}

public List<FareBaggageAllowance> getFareBaggageAllowance() {
return fareBaggageAllowance;
}

public void setFareBaggageAllowance(List<FareBaggageAllowance> fareBaggageAllowance) {
this.fareBaggageAllowance = fareBaggageAllowance;
}

}
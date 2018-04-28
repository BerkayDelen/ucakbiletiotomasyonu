package com.biletcim.entities.json.ta;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Taxes {

@SerializedName("Tax")
@Expose
private List<Tax> tax = null;

public List<Tax> getTax() {
return tax;
}

public void setTax(List<Tax> tax) {
this.tax = tax;
}

}
package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OperatingAirline {

@SerializedName("CompanyShortName")
@Expose
private String companyShortName;

public String getCompanyShortName() {
return companyShortName;
}

public void setCompanyShortName(String companyShortName) {
this.companyShortName = companyShortName;
}

}
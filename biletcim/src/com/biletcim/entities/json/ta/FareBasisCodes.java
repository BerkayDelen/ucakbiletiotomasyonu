package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareBasisCodes {

@SerializedName("FareBasisCode")
@Expose
private String fareBasisCode;

public String getFareBasisCode() {
return fareBasisCode;
}

public void setFareBasisCode(String fareBasisCode) {
this.fareBasisCode = fareBasisCode;
}

}
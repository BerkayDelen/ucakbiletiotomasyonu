package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipment {

@SerializedName("Value")
@Expose
private String value;
@SerializedName("AirEquipType")
@Expose
private String airEquipType;

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

public String getAirEquipType() {
return airEquipType;
}

public void setAirEquipType(String airEquipType) {
this.airEquipType = airEquipType;
}

}
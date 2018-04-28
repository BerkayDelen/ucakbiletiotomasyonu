package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassengerTypeQuantity {

@SerializedName("Quantity")
@Expose
private String quantity;
@SerializedName("Code")
@Expose
private String code;

public String getQuantity() {
return quantity;
}

public void setQuantity(String quantity) {
this.quantity = quantity;
}

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

}
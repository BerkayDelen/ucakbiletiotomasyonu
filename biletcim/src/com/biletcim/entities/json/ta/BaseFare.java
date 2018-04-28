package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseFare {

@SerializedName("CurrencyCode")
@Expose
private String currencyCode;
@SerializedName("Amount")
@Expose
private String amount;

public String getCurrencyCode() {
return currencyCode;
}

public void setCurrencyCode(String currencyCode) {
this.currencyCode = currencyCode;
}

public String getAmount() {
return amount;
}

public void setAmount(String amount) {
this.amount = amount;
}

}
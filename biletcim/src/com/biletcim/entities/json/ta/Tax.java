package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax {

@SerializedName("CurrencyCode")
@Expose
private String currencyCode;
@SerializedName("TaxCode")
@Expose
private String taxCode;
@SerializedName("Amount")
@Expose
private String amount;
@SerializedName("RefundableInd")
@Expose
private Boolean refundableInd;

public String getCurrencyCode() {
return currencyCode;
}

public void setCurrencyCode(String currencyCode) {
this.currencyCode = currencyCode;
}

public String getTaxCode() {
return taxCode;
}

public void setTaxCode(String taxCode) {
this.taxCode = taxCode;
}

public String getAmount() {
return amount;
}

public void setAmount(String amount) {
this.amount = amount;
}

public Boolean getRefundableInd() {
return refundableInd;
}

public void setRefundableInd(Boolean refundableInd) {
this.refundableInd = refundableInd;
}

}
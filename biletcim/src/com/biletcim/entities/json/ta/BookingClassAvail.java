package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingClassAvail {

@SerializedName("ResBookDesigQuantity")
@Expose
private String resBookDesigQuantity;
@SerializedName("ResBookDesigStatusCode")
@Expose
private String resBookDesigStatusCode;
@SerializedName("ResBookDesigCode")
@Expose
private String resBookDesigCode;
@SerializedName("RPH")
@Expose
private String rPH;

public String getResBookDesigQuantity() {
return resBookDesigQuantity;
}

public void setResBookDesigQuantity(String resBookDesigQuantity) {
this.resBookDesigQuantity = resBookDesigQuantity;
}

public String getResBookDesigStatusCode() {
return resBookDesigStatusCode;
}

public void setResBookDesigStatusCode(String resBookDesigStatusCode) {
this.resBookDesigStatusCode = resBookDesigStatusCode;
}

public String getResBookDesigCode() {
return resBookDesigCode;
}

public void setResBookDesigCode(String resBookDesigCode) {
this.resBookDesigCode = resBookDesigCode;
}

public String getRPH() {
return rPH;
}

public void setRPH(String rPH) {
this.rPH = rPH;
}

}
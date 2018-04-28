package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

@SerializedName("code")
@Expose
private String code;
@SerializedName("description")
@Expose
private String description;

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

}
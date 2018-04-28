package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareReference {

@SerializedName("ResBookDesigCode")
@Expose
private String resBookDesigCode;
@SerializedName("content")
@Expose
private String content;

public String getResBookDesigCode() {
return resBookDesigCode;
}

public void setResBookDesigCode(String resBookDesigCode) {
this.resBookDesigCode = resBookDesigCode;
}

public String getContent() {
return content;
}

public void setContent(String content) {
this.content = content;
}

}
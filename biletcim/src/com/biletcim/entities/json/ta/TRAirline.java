package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRAirline {

@SerializedName("status")
@Expose
private String status;
@SerializedName("requestId")
@Expose
private String requestId;
@SerializedName("message")
@Expose
private Message message;
@SerializedName("data")
@Expose
private Data data;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getRequestId() {
return requestId;
}

public void setRequestId(String requestId) {
this.requestId = requestId;
}

public Message getMessage() {
return message;
}

public void setMessage(Message message) {
this.message = message;
}

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

}
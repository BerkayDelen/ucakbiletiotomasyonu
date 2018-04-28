package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OTAAirAvailRS {

@SerializedName("Comment")
@Expose
private String comment;
@SerializedName("OriginDestinationInformation")
@Expose
private OriginDestinationInformation originDestinationInformation;
@SerializedName("Version")
@Expose
private String version;

public String getComment() {
return comment;
}

public void setComment(String comment) {
this.comment = comment;
}

public OriginDestinationInformation getOriginDestinationInformation() {
return originDestinationInformation;
}

public void setOriginDestinationInformation(OriginDestinationInformation originDestinationInformation) {
this.originDestinationInformation = originDestinationInformation;
}

public String getVersion() {
return version;
}

public void setVersion(String version) {
this.version = version;
}

}

package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailabilityOTAResponse {

@SerializedName("createOTAAirRoute")
@Expose
private CreateOTAAirRoute createOTAAirRoute;
@SerializedName("isMixCabin")
@Expose
private Boolean isMixCabin;

public CreateOTAAirRoute getCreateOTAAirRoute() {
return createOTAAirRoute;
}

public void setCreateOTAAirRoute(CreateOTAAirRoute createOTAAirRoute) {
this.createOTAAirRoute = createOTAAirRoute;
}

public Boolean getIsMixCabin() {
return isMixCabin;
}

public void setIsMixCabin(Boolean isMixCabin) {
this.isMixCabin = isMixCabin;
}

}
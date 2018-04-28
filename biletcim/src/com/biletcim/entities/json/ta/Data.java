
package com.biletcim.entities.json.ta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

@SerializedName("availabilityOTAResponse")
@Expose
private AvailabilityOTAResponse availabilityOTAResponse;

public AvailabilityOTAResponse getAvailabilityOTAResponse() {
return availabilityOTAResponse;
}

public void setAvailabilityOTAResponse(AvailabilityOTAResponse availabilityOTAResponse) {
this.availabilityOTAResponse = availabilityOTAResponse;
}

}
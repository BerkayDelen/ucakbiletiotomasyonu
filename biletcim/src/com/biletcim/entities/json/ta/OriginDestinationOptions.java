package com.biletcim.entities.json.ta;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginDestinationOptions {

@SerializedName("OriginDestinationOption")
@Expose
private List<OriginDestinationOption> originDestinationOption = null;

public List<OriginDestinationOption> getOriginDestinationOption() {
return originDestinationOption;
}

public void setOriginDestinationOption(List<OriginDestinationOption> originDestinationOption) {
this.originDestinationOption = originDestinationOption;
}

}
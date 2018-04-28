package com.biletcim.entities.test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestVal {

@SerializedName("one")
@Expose
private String one;
@SerializedName("key")
@Expose
private String key;

public String getOne() {
return one;
}

public void setOne(String one) {
this.one = one;
}

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

}
package com.biletcim.entities.json;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {
	
	  @SerializedName("Status")
	  @Expose
	  private String Status;
	  
	  @SerializedName("Error")
	  @Expose
	  private String Error;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}
	
	
	  

}

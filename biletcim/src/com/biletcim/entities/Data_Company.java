package com.biletcim.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



public class Data_Company {

	
	private int CompanyID;
	
	
	private String CompanyName;
	
	
	private String CompanyImg;
	
	
    
	
	
	public Data_Company(){
		super();
	}
	public Data_Company(int companyID, String companyName, String companyImg) {
		super();
		CompanyID = companyID;
		CompanyName = companyName;
		CompanyImg = companyImg;
	}
	
	public int getCompanyID() {
		return CompanyID;
	}
	public void setCompanyID(int companyID) {
		CompanyID = companyID;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCompanyImg() {
		return CompanyImg;
	}
	public void setCompanyImg(String companyImg) {
		CompanyImg = companyImg;
	}
	
	
	
	
	
	
	
	

}

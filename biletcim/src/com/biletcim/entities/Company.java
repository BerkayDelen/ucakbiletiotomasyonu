package com.biletcim.entities;

public class Company {
	
	private int CompanyID;
	private String CompanyName;
	private String CompanyImg;
	
	public Company(int companyID, String companyName, String companyImg) {
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

package com.biletcim.entities;

public class Sale_User {
	
	


	private Boolean sales_user_isLogin;
	private int sales_user_id;

	private String sales_user_Name;
	private String sales_user_Surname;
	
	private String sales_user_TC;
	private String sales_user_Email;
	
	
	private Boolean sales_user_gender;

	
	
	public Sale_User(Boolean sales_user_isLogin, int sales_user_id, String sales_user_Name, String sales_user_Surname,
			String sales_user_TC, String sales_user_Email, Boolean sales_user_gender) {
		super();
		this.sales_user_isLogin = sales_user_isLogin;
		this.sales_user_id = sales_user_id;
		this.sales_user_Name = sales_user_Name;
		this.sales_user_Surname = sales_user_Surname;
		this.sales_user_TC = sales_user_TC;
		this.sales_user_Email = sales_user_Email;
		this.sales_user_gender = sales_user_gender;
	}



	public Boolean getSales_user_isLogin() {
		return sales_user_isLogin;
	}



	public void setSales_user_isLogin(Boolean sales_user_isLogin) {
		this.sales_user_isLogin = sales_user_isLogin;
	}



	public int getSales_user_id() {
		return sales_user_id;
	}



	public void setSales_user_id(int sales_user_id) {
		this.sales_user_id = sales_user_id;
	}



	public String getSales_user_Name() {
		return sales_user_Name;
	}



	public void setSales_user_Name(String sales_user_Name) {
		this.sales_user_Name = sales_user_Name;
	}



	public String getSales_user_Surname() {
		return sales_user_Surname;
	}



	public void setSales_user_Surname(String sales_user_Surname) {
		this.sales_user_Surname = sales_user_Surname;
	}



	public String getSales_user_TC() {
		return sales_user_TC;
	}



	public void setSales_user_TC(String sales_user_TC) {
		this.sales_user_TC = sales_user_TC;
	}



	public String getSales_user_Email() {
		return sales_user_Email;
	}



	public void setSales_user_Email(String sales_user_Email) {
		this.sales_user_Email = sales_user_Email;
	}



	public Boolean getSales_user_gender() {
		return sales_user_gender;
	}



	public void setSales_user_gender(Boolean sales_user_gender) {
		this.sales_user_gender = sales_user_gender;
	}


	

	
	
	
	
	

}

package com.biletcim.entities;

import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class Login_User {
	
	
	private String email;
	
	private String password;
	
	private Boolean rememberMe;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	
	
	
	
	
	
	
	
}

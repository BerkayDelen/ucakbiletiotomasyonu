package com.biletcim.entities;

public class Country {
	
	private Language language;
	
	private String Code;

	
	
	public Country(Language language, String code) {
		
		this.language = language;
		Code = code;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}
	
	

}

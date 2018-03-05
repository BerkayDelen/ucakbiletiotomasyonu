package com.biletcim.entities;

public class Language {
	
	private String Code;
	private String Name;
	
	
	
	public Language(String code, String name) {
		
		Code = code;
		Name = name;
	}
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	
}

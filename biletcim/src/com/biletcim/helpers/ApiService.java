package com.biletcim.helpers;

import org.json.JSONArray;
import org.json.JSONObject;

import com.biletcim.entities.Coordinate;
import com.biletcim.entities.Country;
import com.biletcim.entities.Language;

public class ApiService {
	
	
	public static Country getCountry(JSONObject obj) {
		
		Country country = null;
		
		try {
			JSONObject Country_LanguageInfo = obj.getJSONObject("LanguageInfo");
			JSONObject LanguageInfo_Language = Country_LanguageInfo.getJSONObject("Language");
			String LanguageInfo_Language_Code = LanguageInfo_Language.getString("Code");
			String LanguageInfo_Language_Name = LanguageInfo_Language.getString("Name");
			
			String Country_LanguageInfo_Country_Code = obj.getString("Code");
			
			Language Country_LanguageInfo_N= new Language(LanguageInfo_Language_Code, LanguageInfo_Language_Name);
			country = new Country(Country_LanguageInfo_N, Country_LanguageInfo_Country_Code);
	
			return country;
			
	}catch (Exception e) {
		
		if(e.getMessage().equals("JSONObject[\"LanguageInfo\"] is not a JSONObject.")) {
			
			
			Language Country_LanguageInfo_N = new Language("", "");
			
			String Country_LanguageInfo_Country_Code = obj.getString("Code");
			
			 country = new Country(Country_LanguageInfo_N, Country_LanguageInfo_Country_Code);
			
		
		
		return country;
		}else {
			try {
				JSONObject Country_LanguageInfo = obj.getJSONObject("LanguageInfo");
				JSONArray Country_LanguageInfo_Language = Country_LanguageInfo.getJSONArray("Language");
							
				String Country_LanguageInfo_Code = Country_LanguageInfo_Language.getJSONObject(0).getString("Code");
				String Country_LanguageInfo_Name = Country_LanguageInfo_Language.getJSONObject(0).getString("Name");
				
				Language Country_LanguageInfo_N = new Language(Country_LanguageInfo_Code, Country_LanguageInfo_Name);
				
				String Country_LanguageInfo_Country_Code = obj.getString("Code");
				
				country = new Country(Country_LanguageInfo_N, Country_LanguageInfo_Country_Code);
				return country;
				
				}catch (Exception e1) {
				System.out.println(e1.getMessage()+"-- NULL country");
				return country;
				}
		}
	}
	
		
		
		
	}
	
	

}

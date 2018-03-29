package com.biletcim.services;

import java.util.List;

import com.biletcim.entities.Company;

public interface AirlinesService {
	public Company getCompanyById(int id);
	public List<Company> getCompanyies();

}

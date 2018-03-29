package com.biletcim.dao;

import java.util.List;

import com.biletcim.entities.Company;

public interface AirlinesDAO {

	public Company getCompanyById(int id);
	public List<Company> getCompanyies();
}

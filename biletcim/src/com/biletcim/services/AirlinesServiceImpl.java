package com.biletcim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biletcim.dao.AirlinesDAO;
import com.biletcim.entities.Company;

@Service
@Transactional
public class AirlinesServiceImpl implements AirlinesService {

	@Autowired
	private AirlinesDAO airlinesDAO;
	
	@Override
	@Transactional
	public Company getCompanyById(int id) {
		// TODO Auto-generated method stub
		return airlinesDAO.getCompanyById(id);
	}

}

package com.biletcim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.biletcim.configs.Config;
import com.biletcim.entities.Company;
import com.biletcim.entities.Port;

@Repository
public class AirlinesImpl implements AirlinesDAO {

	@Override
	public Company getCompanyById(int id) {
		Company company = null;
		
			String sql = "SELECT  * from company where companyID = ? ";
		
		try {
			Config.OpenDB(sql);
		Config.stmt.setInt(1,id);
		
		
		ResultSet rs =	Config.stmt.executeQuery();
   while(rs.next()){
      //Retrieve by column name
	   company = new Company(rs.getInt("companyID"), rs.getString("companyName"), rs.getString("companyImg"));
	   
     
      System.out.println("Company : " + rs.getString("companyName"));
     
   }
   rs.close();
	
   Config.CloseDB();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return company;
	}

}

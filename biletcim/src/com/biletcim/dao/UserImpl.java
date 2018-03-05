package com.biletcim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biletcim.configs.Config;
import com.biletcim.entities.Login_User;
//import com.biletcim.entities.Login;
import com.biletcim.entities.User;

@Repository
public class UserImpl implements UserDAO {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}
	
	
	@Override
	public List<User> getUsers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("from Users",User.class);
		
		List<User> users = query.getResultList();
		
		return users;
	}


	@Override
	public Boolean login(Login_User user) {
		Boolean durum = false;
		
		String sql = "SELECT count(*) as count from users where User_Email = ? and User_Password = ?";
		
					try {
						Config.OpenDB(sql);
					Config.stmt.setString(1,user.getEmail());
					Config.stmt.setString(2,user.getPassword());
					
					ResultSet rs =	Config.stmt.executeQuery();
			   while(rs.next()){
			      //Retrieve by column name
			      int count  = rs.getInt("count");
			      //Display values
			      System.out.println("count: " + count);
			      if(count != 0) {
			    	  durum = true;
			      }else {
			    	  durum = false;
			      }
			   }
			   rs.close();
				
			   Config.CloseDB();
					} catch (SQLException e) {
						
						e.printStackTrace();
						durum = null;
					}
					
		
					return durum;
		
	}

	

}

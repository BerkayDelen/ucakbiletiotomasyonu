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
		
		Query<User> query = session.createQuery("from users",User.class);
		
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
	
	@Override
	public com.biletcim.entities.User User(String uuid) {

		com.biletcim.entities.User user = new com.biletcim.entities.User();
		String sql = "SELECT * from users where User_UniqID = ?";
		
					try {
						Config.OpenDB(sql);
					Config.stmt.setString(1,uuid);
					
					
					ResultSet rs =	Config.stmt.executeQuery();
			   while(rs.next()){
			      //Retrieve by column name
				   System.out.println("Id ->"+rs.getInt("Id"));
				   System.out.println("Name ->"+rs.getString("User_Name"));
				   System.out.println("Surname ->"+rs.getString("User_Surname"));
				   System.out.println("Email ->"+rs.getString("User_Email"));
				   System.out.println("Uniq Id ->"+uuid);
				   
				   
				   
				   
					user.setId(rs.getInt("Id"));
					user.setName(rs.getString("User_Name"));
					user.setSurname(rs.getString("User_Surname"));
					user.setEmail(rs.getString("User_Email"));
					user.setUniqID(uuid);
					
			     
			   }
			   rs.close();
				
			   Config.CloseDB();
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
					
				
			return user;
	}

	

}

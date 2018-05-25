package com.biletcim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biletcim.entities.Login_User;
//import com.biletcim.entities.Login;
import com.biletcim.entities.User;

@Service
public interface UserService {

		public List<User> getUsers();
		
		public void addUser(User user);
		
		public Boolean login(Login_User user);

		public User User(String uuid);
	
}

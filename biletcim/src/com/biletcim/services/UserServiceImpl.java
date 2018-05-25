package com.biletcim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biletcim.dao.UserDAO;
import com.biletcim.entities.Login_User;
import com.biletcim.entities.User;
import com.biletcim.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);

	}

	@Override
	@Transactional
	public Boolean login(Login_User user) {
		
		return userDAO.login(user);
	}
	
	@Override
	public com.biletcim.entities.User User(String uuid) {
		return userDAO.User(uuid);
	}

}

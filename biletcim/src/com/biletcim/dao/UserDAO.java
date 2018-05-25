package com.biletcim.dao;

import java.util.List;

import com.biletcim.entities.Login_User;
import com.biletcim.entities.User;

public interface UserDAO {
	public List<User> getUsers();
	public void addUser(User user);
	public Boolean login(Login_User user);
	public User User(String uuid);

}

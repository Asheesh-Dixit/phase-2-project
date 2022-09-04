package com.flyaway.dao;

import com.flyaway.dto.User;

public interface UserDao {
	public boolean registerUser(User user);
	public boolean validateUser(User user);
	public void updateAdminPassword(String username, String password);
}

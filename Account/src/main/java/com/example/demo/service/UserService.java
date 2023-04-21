package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	
	public User addUser(User user);
	
	public List<User> getUser(int userId);
	
	public List<User> getUserByAccoountNo(int accountNo);

}

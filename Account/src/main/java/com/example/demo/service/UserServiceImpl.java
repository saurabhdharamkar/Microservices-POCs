package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getUser(int userId) {
		return userRepo.findByUserId(userId);
	}

	@Override
	public List<User> getUserByAccoountNo(int accountNo) {
		return userRepo.findByAccountNo(accountNo);
	}
	
	

}

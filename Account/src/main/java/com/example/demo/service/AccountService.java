package com.example.demo.service;

import com.example.demo.entity.Account;

public interface AccountService {
	
	public Account addAccount(Account account);
	
	public Account getAccount(int accountNo);
	
	public Account deposit(Account account);
	
	public Account withdraw(Account account);

}

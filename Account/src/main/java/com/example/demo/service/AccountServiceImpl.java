package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.exception.AccountNumNotFoundException;
import com.example.demo.repo.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public Account addAccount(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account getAccount(int accountNo) {
		
		//return accountRepo.findByAccountNo(accountNo);
		
		Optional<Account> optional = accountRepo.findById(accountNo);
		if(optional.isPresent())
			return optional.get();
		else 
			throw new AccountNumNotFoundException("Invalide Account Number!");
		
		
		
		//return accountRepo.findById(accountNo).orElseThrow(()->new AccountNumNotFoundException("Invalid Account Number!"));
	}

	@Override
	public Account deposit(Account account) {
		return accountRepo.save(account);

	}

	@Override
	public Account withdraw(Account account) {
		return accountRepo.save(account);
	}

}

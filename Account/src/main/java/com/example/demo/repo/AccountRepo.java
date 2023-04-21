package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

	@Query("from Account a where a.accountNo=?1")
	Account findByAccountNo(int accountNo);

}

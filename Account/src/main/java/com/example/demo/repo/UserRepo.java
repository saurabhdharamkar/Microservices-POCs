package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

	@Query("from User u where u.userId=?1")
	List<User> findByUserId(int userId);

	@Query(value="select * from banking.usertab u  where u.account_no=?1",nativeQuery = true)
	List<User> findByAccountNo(int accountNo);
	
	//@Query("select u.user_name from banking.usertab u where u.account_no=1")
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.exception.AccountNumNotFoundException;
import com.example.demo.exception.CorrectPasswordException;
import com.example.demo.exception.DepositAmmountException;
import com.example.demo.exception.LessThanZeroException;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.exception.WithdrawAmmountException;

import com.example.demo.payload.BalanceResponse;
import com.example.demo.payload.SetPassword;
import com.example.demo.payload.TransferAccountDetails;
import com.example.demo.service.AccountService;
import com.example.demo.service.KafkaAccountConsumerService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KafkaAccountConsumerService kafkaService;
	
	@PostMapping("/addAccount")
	public Account addAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}
	
	@GetMapping("/getAccount/{accountNo}")
	public ResponseEntity<?> getAccount(@PathVariable int accountNo) {
		ResponseEntity<?> resp = null; 
		try {
			 resp = ResponseEntity.ok(accountService.getAccount(accountNo));
		}catch (AccountNumNotFoundException annfe) {
			resp = new ResponseEntity<>(annfe.getMessage(),HttpStatus.NOT_FOUND);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return resp;
	}
	
	@GetMapping("/depositAmmount/{accountNo}/{password}/{deposit}")
	public ResponseEntity<?> depositAmmount(@PathVariable int accountNo,@PathVariable int password,@PathVariable int deposit) throws Exception{
		ResponseEntity<?>resp=null;
		try {
		Account account1=accountService.getAccount(accountNo);
		if(account1.getPassword()==password) {
		if(deposit>=500) {
		int accountBal=account1.getAccountBalance()+deposit;
		account1.setAccountBalance(accountBal);
		account1.setDeposit(deposit);
		accountService.addAccount(account1);
	     resp= new ResponseEntity <>(account1,HttpStatus.OK);
		}else {
			
			throw  new DepositAmmountException("Deposit Money must be greater than 500");
		}
		
		}else {
			throw new CorrectPasswordException("Please Enter Correct Password");
		}
		}catch(AccountNumNotFoundException er){
			resp=new ResponseEntity<>(er.getMessage(),HttpStatus.NOT_FOUND);
		}
			
		
		return resp;
	}
	
	@GetMapping("/withdrawAmmount/{accountNo}/{password}/{withdraw}")
	public ResponseEntity<?> withdrawAmmount(@PathVariable int accountNo,@PathVariable int password,@PathVariable int withdraw)throws Exception {
		ResponseEntity<?>resp=null;
		try {
		Account account1=accountService.getAccount(accountNo);
		if(account1.getPassword()==password) {
			
		if(withdraw>=100 && withdraw<=account1.getAccountBalance()) {
		int accountBal=account1.getAccountBalance()-withdraw;
		account1.setAccountNo(accountNo);
		account1.setAccountBalance(accountBal);
		account1.setWithdraw(withdraw);
		accountService.addAccount(account1);
		 resp=new ResponseEntity<>(account1,HttpStatus.OK);
		}else{
			
			throw new WithdrawAmmountException("Withdraw Money should be lass than Current balance");
		}
		}else {
			throw new CorrectPasswordException("Please Enter Correct Password");
		}
		}catch(AccountNumNotFoundException er){
			resp= new ResponseEntity<>(er.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		return resp;
	}
	

	@GetMapping("/checkBalance/{accountNo}/{password}")
	public ResponseEntity<?> checkAccountBalance(@PathVariable int accountNo,@PathVariable int password) throws Exception{
		ResponseEntity<?>resp=null;
		BalanceResponse balanceResponse =new BalanceResponse();
		try {
		
		Account acc=accountService.getAccount(accountNo);
		if(acc!=null) {
			if(acc.getPassword()==password) {
		balanceResponse.setAccNo(accountNo);
		balanceResponse.setAccBalance(acc.getAccountBalance());
		balanceResponse.setMsg("Account Balance Fetch successfully");
		 resp=new ResponseEntity<BalanceResponse>(balanceResponse, HttpStatus.OK);
		}else {
			throw new CorrectPasswordException("Please Enter Correct Password");
			
		}
		}else {
			balanceResponse.setMsg("No Record Present for this AccountNo");
		}
		}catch(AccountNumNotFoundException er) {
			resp= new ResponseEntity<>(er.getMessage(),HttpStatus.NOT_FOUND);
		}
		return resp;
		
	}
	
	@GetMapping("setPassword/{accountNo}/{username}/{password}")
		public ResponseEntity<?> setPassword(@PathVariable int accountNo,@PathVariable String username,@PathVariable int password) throws Exception {
		ResponseEntity<?>resp=null;
		try {
		SetPassword pass=new SetPassword();
			Account acc=accountService.getAccount(accountNo);
			
			if(acc!=null) {
			List<User> users=userService.getUserByAccoountNo(accountNo);
			for(User u :users) {
				if(u.getUserName().equalsIgnoreCase(username)) {
					acc.setPassword(password);
					pass.setUsername(username);
					pass.setAccountNo(accountNo);
					pass.setPassword(password);
					pass.setMsg("Password Set Successfully");
					accountService.addAccount(acc);
					resp= new ResponseEntity<SetPassword>(pass,HttpStatus.OK);
				}else {
					pass.setMsg("username does not match");
				}
			}
			
			}else {
				throw new RecordNotFoundException("Record Not Found");
			}
		}catch(AccountNumNotFoundException er){
			resp=new ResponseEntity<>(er.getMessage(),HttpStatus.NOT_FOUND);
		}
			return resp;
			
		}
	
	@GetMapping("transferAmmount/{accountNo1}/{ammount1}/{accountNo2}")
	public ResponseEntity<?> transferAmmount(@PathVariable int accountNo1,@PathVariable int ammount1,
			                                                                             @PathVariable int accountNo2)throws Exception{
		ResponseEntity<?>resp=null;
		try {
			TransferAccountDetails tAccount=new TransferAccountDetails();
			Account acc1=accountService.getAccount(accountNo1);
			Account acc2=accountService.getAccount(accountNo2);
			
			if(acc1!=null && acc2!=null ) {
				int accBal1=acc1.getAccountBalance()-ammount1;
				int accBal2=acc2.getAccountBalance()+ammount1;
				if(accBal1<=0) {
					throw new LessThanZeroException("Account balance should not be less than zero");
				}else {
				acc1.setAccountNo(accountNo1);
				acc1.setAccountBalance(accBal1);
				
				acc2.setAccountNo(accountNo2);
				acc2.setAccountBalance(accBal2);
				
				tAccount.setAccountNo1(accountNo1);
				tAccount.setAccountBalanceBeforeTransaction(acc1.getAccountBalance()+ammount1);
				tAccount.setTransferedAmmount(ammount1);
				tAccount.setAccountBalanceAfterTransaction(accBal1);
				tAccount.setMsg("Money Transfered Successfully");
				
				accountService.addAccount(acc1);
				accountService.addAccount(acc2);
			
				resp=new ResponseEntity<>(tAccount,HttpStatus.OK);
				}
			}else {
				throw new RecordNotFoundException("Record Not Found");
			}
			
		}catch(AccountNumNotFoundException er) {
			resp=new ResponseEntity<>(er.getMessage(),HttpStatus.NOT_FOUND);
		}
		return resp;
	}
	
	
	@GetMapping("/getMessage")
	public ResponseEntity<?> getAllMessages(){
		return ResponseEntity.ok(kafkaService.getMessages());
	}
	

	
	}



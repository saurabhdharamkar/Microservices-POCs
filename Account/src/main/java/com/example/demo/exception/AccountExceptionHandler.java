package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionHandler {
	
	@ExceptionHandler(value = WithdrawAmmountException.class)
	public ResponseEntity<String> withdrawAmmountException(){
		return new ResponseEntity<>("Withdraw Money should be lass than Current balance",HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = DepositAmmountException.class)
	public ResponseEntity<String> depositAmmountException(){
		return new ResponseEntity<>("Deposit Money must be greater than 500",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = CorrectPasswordException.class)
	public ResponseEntity<String> correctPasswordException(){
		return new ResponseEntity<>("Please Enter Correct Password",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<String> recordNotFoundException(){
		return new ResponseEntity<>("Record Not Found",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = LessThanHundreadError.class)
	public ResponseEntity<String> leassThanHundreadError(){
		return new ResponseEntity<>("Withdraw Money Must Not be Less than 100",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = LessThanZeroException.class)
	public ResponseEntity<String> LessThanZeroException(){
		return new ResponseEntity<>("Sorry You dont have sufficient ammount",HttpStatus.BAD_REQUEST);
	}

}

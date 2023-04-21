package com.example.demo.exception;

public class AccountNumNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AccountNumNotFoundException() {

	}
	
	public AccountNumNotFoundException(String msg) {
		super(msg);
	}
	
	

}

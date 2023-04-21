package com.example.demo.exception;

public class DepositAmmountGreater extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public DepositAmmountGreater(String errMsg) {
		super(errMsg);
	}

}

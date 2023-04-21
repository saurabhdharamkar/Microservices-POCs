package com.example.demo.exception;

public class CorrectPasswordException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	public CorrectPasswordException(String msg) {

        super(msg);
	}

}

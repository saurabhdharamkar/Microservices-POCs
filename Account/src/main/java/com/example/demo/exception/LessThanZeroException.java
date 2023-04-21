package com.example.demo.exception;

public class LessThanZeroException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public LessThanZeroException(String msg) {
		super(msg);
	}

}

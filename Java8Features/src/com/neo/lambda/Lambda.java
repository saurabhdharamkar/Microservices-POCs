package com.neo.lambda;

interface Product{
	void m1();
}

public class Lambda {
	
	public static void main(String[] args) {
		
		Product pro=()->System.out.println("Hello Java");
		pro.m1();
		
	}

}

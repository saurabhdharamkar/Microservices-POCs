package com.neo.lambda;


@FunctionalInterface
interface Product1{
	void m1();
}

public class FunctioonalInterface {
	
	static void m1() {
		System.out.println("Hey Akshay");
	}
	
	void m2() {
		System.out.println("HJey Saurabh");
	}
	
	public static void main(String[] args) {
		
		Product1 pro=FunctioonalInterface::m1;
		pro.m1();
		FunctioonalInterface fi=new FunctioonalInterface();
		Product1 pro1=fi::m2;
		pro1.m1();
		
	}

}

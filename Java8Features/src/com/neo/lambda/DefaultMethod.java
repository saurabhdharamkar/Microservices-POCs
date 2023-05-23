package com.neo.lambda;

interface Product3{
	
	default void m3() {
		System.out.println("Default Method Call");
	}
}

public class DefaultMethod implements Product3{
	
	public static void main(String[] args) {
		
		DefaultMethod dm=new DefaultMethod();
		dm.m3();
		
	}

}

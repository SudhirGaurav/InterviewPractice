package com.practice.java8.concept;

@FunctionalInterface
interface LembdaExpTest {

	default String show() {
		return "Inside default method show ";
	}

	static String show2() {
		return "Inside static show2 Method";
	}
	String test(); // Declare 
}

public class LambdaEWithDefaultMethodIntereface {

	public static void main(String[] args) {
		
		LembdaExpTest obj = () -> "return for declared Method"; // Implementation
		System.out.println(obj.test());
	}

}

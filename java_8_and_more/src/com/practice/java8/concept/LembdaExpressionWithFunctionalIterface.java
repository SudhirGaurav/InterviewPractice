package com.practice.java8.concept;

//Concept  -- > Whn u r writing lembda expression of an interface , that must have only one interface . or that Interfcae must have functional interface
// If interface have only one method that is by default FuntionalInterface . 

@FunctionalInterface
interface MyInterface{
	public int mul(int a);// Declare 
}

@FunctionalInterface
interface MyInterface2{
	public int show(int a, int b);
}
public class LembdaExpressionWithFunctionalIterface {

	public static void main(String[] args) {
		MyInterface mi = (int a) -> (a * a); // Definition or implementation of interface
		int result = mi.mul(5);
		System.out.println("Resulty is : "+result);
		
		
		MyInterface mi2 = (int b) -> (b*b);
		int mul=	mi2.mul(10);
		System.out.println("Mu is : "+mul);
		
		MyInterface mi3 = a -> a*a;        // Second flavor
		System.out.println(mi3.mul(2));
		
		
		
		MyInterface2 obj = (a,b) -> a*b; // for more than one parameter , before parameter () is required
		System.out.println(obj.show(2, 4));
		
	}
}

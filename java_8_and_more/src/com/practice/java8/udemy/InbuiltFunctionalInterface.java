package com.practice.java8.udemy;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * Function<T , R> -- T apply(T)
 * Predicate <T> ---  boolean test(T)
 * Consumer<T> ---  void apply(T)
 * 
 */

@FunctionalInterface
interface MyFunctionalInterface{ // User defined functionalInterface
	int test(int a);
}

public class InbuiltFunctionalInterface {
	public static void main(String[] args) {
		
		MyFunctionalInterface functionalInterface= a -> a*a;
		int result=	functionalInterface.test(2);
		System.out.println(result);
		
		Function<Integer, Integer> fun = a ->a*a;  // This is using inbuilt Function<T, R> Functional Interface
		int result2= fun.apply(5); // apply method is residing in Function<,> interface 
		System.out.println("Result 2 is : "+result2);
		
		Predicate<Integer> predicate = a -> a%2 ==0; // this is inbuilt Predicate<T> functional Interface 
		boolean bolVal=	predicate.test(2); // test method is abstract method in Predicates 
		System.out.println("bolVal is : "+bolVal);
		
		Consumer<Integer> consumer = a -> System.out.println(a);
		consumer.accept(9);
	}
}

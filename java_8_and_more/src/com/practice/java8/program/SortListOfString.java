package com.practice.java8.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Q. Write a Java 8 program to use a lambda expression and method ref to sort a list of strings in alphabetical order.
@FunctionalInterface
interface SortList{
	public void soft(List<String> list);
}

public class SortListOfString {

	public static void main(String[] args) {
		
		sortThroughLembdaExpression();
		sortThroughMethodReference();
	}

	private static void sortThroughMethodReference() {
		List<String> list = Arrays.asList("abc", "ABC");
		SortList sl = Collections :: sort;
		sl.soft(list);
		
		System.out.println("Sort though MethodRef : "+list);
	}

	private static void sortThroughLembdaExpression() {
		List<String> list = Arrays.asList("abc", "ABC");
		SortList sList = (listt) -> Collections.sort(listt);
		System.out.println("Sort though Lembda Expression : "+list);

		sList.soft(list);
		System.out.println("Sorted List  is : " + list);
	}
}

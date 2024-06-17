package com.practice.java8.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Q. Write a Java 8 program to use a lambda expression and method ref to sort a list of strings in alphabetical order.
//take away , it is just to learn how to use Functional Interface 
@FunctionalInterface
interface SortList{
	public void sort(List<String> list);
}

public class SortListOfString {
	public static void main(String[] args) {
		sortThroughMethodReference();
		sortThroughLembdaExpression();
		sortingThroughStream();
	}

	private static void sortThroughMethodReference() {
		List<String> list = Arrays.asList("ABC", "GHI" ,"DEF");
		SortList sl = Collections :: sort; // Expression
		sl.sort(list);// calling sort method of functional interface
		System.out.println("Sort though MethodRef : "+list);
	}

	private static void sortThroughLembdaExpression() {
		List<String> list = Arrays.asList("ABC", "GHI" ,"DEF");
		SortList sList = (listt) -> Collections.sort(listt);// Expression 
		sList.sort(list);// calling sort method of functional interface
		System.out.println("Sort though Lembda Expression : " + list);
	}

	private static void sortingThroughStream() {
		List<String> list = Arrays.asList("ABC", "GHI", "DEF");
		List<String> soretdeList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("Sort with the help of Stream is : " + soretdeList);
		list.sort(null);
	}
}


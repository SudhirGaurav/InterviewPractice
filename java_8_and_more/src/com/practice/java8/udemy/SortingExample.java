package com.practice.java8.udemy;
/*
Q .sort an array of String with length of the string . [Inter] [Custom sorting ]
IP = "AAAA" , "A" , "AAB"
op= A AAB , AAAA
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingExample {

	public static void main(String[] args) {
		question3();
	}

	private static void question3() {
		List<String> sList = Arrays.asList("AAAA", "A", "AAB");
		// OP should be A AAB AAAA
		Collections.sort(sList);
		// System.out.println("Sortes List : "+sList);

		List<String> sortedList = sList.stream().sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList()); // Method ref
		System.out.println("Sorted List is " + sortedList);

		List<String> sortedListByLambda = sList.stream().sorted(Comparator.comparing(str -> str.length()))
				.collect(Collectors.toList()); // Lambda function 
		System.out.println("Sorted List by lambda is " + sortedListByLambda);

	}
}

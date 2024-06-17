package com.practice.java8.udemy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Practice {

	//Q1 .find the max value from a list of integer using stream api[Inter]
	//Q2 .sort a array of string in decreasing order
	public static void main(String[] args) {
		List<Integer> list = List.of(4, 2, 5, 6, 78, 4);
		question11(list);
		
		List<String> sList = Arrays.asList("ABC","GHI","DEF");
		//question2(sList);
	}

	private static void question2(List<String> sList) {
		System.out.println("List is :"+sList);
		List<String> sortInreverseOrder=	sList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("List after reverse is  :"+sortInreverseOrder);
	}

	//first index is called aggregate 
	//second index is called nextNumber
	public static int findMax(int a, int b) { // The one u return is first argument always [VV imp concept ]
		System.out.println("a is :" + a + " b is : " + b);
		return a > b ? a : b;
	}

	private static void question11(List<Integer> list) {
		//Method ref
		//int max = list.stream().reduce(0, Java8Practice::findMax); // First value is reference value 
		//System.out.println("Max no is : " + max);
		
		//lambda function 
		int max2 = list.stream().reduce(0, (a,b) -> a>b ? a:b); // in this case above max method is not required . This will called                                                                                                                                                                                                                                                                                                                                                 
		System.out.println("Max2 is : "+max2);
	}

}

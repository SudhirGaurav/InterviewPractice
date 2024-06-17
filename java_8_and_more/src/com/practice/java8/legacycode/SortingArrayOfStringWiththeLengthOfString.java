package com.practice.java8.legacycode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Q .sort an array of String with length of the string . [Inter] [Custom sorting ]
IP = "AAAA" , "A" , "AAB"
op= A AAB , AAAA
*/

class SortByLenght implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return  (o1.length() - o2.length());
	}
}
public class SortingArrayOfStringWiththeLengthOfString {

	public static void main(String[] args) {
		sortingSring();
	}

	private static void sortingSring() {
		List<String> sList = Arrays.asList("AAAA" , "A" , "AAB");
		Collections.sort(sList , new SortByLenght());
		System.out.println("Sorted with Length : "+sList);
	}
}

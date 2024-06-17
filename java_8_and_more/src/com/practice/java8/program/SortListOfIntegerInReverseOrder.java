package com.practice.java8.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortListOfIntegerInReverseOrder {

	public static void main(String[] args) {

		sortInReverseOrderInLegacy();
		
		sortInReverseOrderInJava8();
	}

	private static void sortInReverseOrderInLegacy() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Collections.reverse(list);
		System.out.println(list);
	}
	
	private static void sortInReverseOrderInJava8() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> sortedList =list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sorted based on java 8 : "+sortedList);
		
	}
}

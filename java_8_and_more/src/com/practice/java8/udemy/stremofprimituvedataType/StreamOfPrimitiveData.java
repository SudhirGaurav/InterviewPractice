package com.practice.java8.udemy.stremofprimituvedataType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Q. Sort arr in reverse order using java 8....
//int[] arr = {3,5,2,7,9,1};
public class StreamOfPrimitiveData {

	public static void main(String[] args) {
		reverseIntArr(); // VVIMP for inteview
		joiningStringArr();
		splitingStringOfarrayOfString();
		
		
	}

	private static void splitingStringOfarrayOfString() {

		List<String> list = Arrays.asList("abc ABC", "def DEF ", "ghi GHI");
		List<String> splitList = list.stream().map(str -> str.split(" ")).flatMap(Arrays::stream)
				.collect(Collectors.toList()); // Stream of array Of String
		System.out.println("splitList is: " + splitList.get(0));
	}

	private static void reverseIntArr() {
		int[] arr = { 3, 5, 2, 7, 9, 1 };
		IntStream stream = Arrays.stream(arr);
		int[] sortedArr = stream.boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
		// printing arr
		Arrays.stream(sortedArr).boxed().forEach(System.out::print);
	}
	private static void joiningStringArr() {
		List<String> list = Arrays.asList("abc" , "def" , "ghi");
		String joinedString =list.stream().collect(Collectors.joining(" "));
		System.out.println("Joined stringis : "+joinedString);
	}
}

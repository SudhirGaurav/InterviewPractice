package com.practice.java8.program;

import java.util.Arrays;
import java.util.List;


//Q Find the no of string which size is more than 3
//String[] arr = {"java" , "python" , "hp" , "cisco" };
//op = 3
public class FindTotalStringInArr {

	public static void main(String[] args) {
		String[] arr = {"java" , "python" , "hp" , "cisco" };
		List<String> list = Arrays.asList(arr);
		long count=	list.stream().filter(k -> k.length()>3).count();
		System.out.println("Count is : "+count);
	}

}

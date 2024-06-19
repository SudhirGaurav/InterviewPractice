package com.practice.java8.udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceProgSet1 {
 
	public static String disp() {
		return "Calling static method ";
	}
	
	public String disp_2() {
		return "Calling static method ";
	}
	
	public static String toUppercaseMethod(String val) {
		return val.toUpperCase();
	}
	
	public  String toUppercaseMethod_nonStatic(String val) {
		return val.toUpperCase();
	}
	
	public static void main(String[] args) {
		//Concept ......
	//new ArrayList<>().stream().forEach(MethodReferenceProg :: disp); you can not use like this 
	//String str = MethodReferenceProg :: disp; // wrong . because target type of this expression must be a functional interface 

	List<String> sList = Arrays.asList("abc", "def", "ghi");
	List<String> uppercaseString = sList.stream().map(String::toUpperCase).collect(Collectors.toList());
	System.out.println("Upper case list is : " + uppercaseString);
	
	List<String> uppercaseString2= sList.stream().map(MethodReferenceProgSet1 :: toUppercaseMethod).collect(Collectors.toList()); // calling static method
	System.out.println("Second flaour: "+uppercaseString2);
	
	 MethodReferenceProgSet1 instance = new MethodReferenceProgSet1();
	 List<String> uppercaseString3= sList.stream().map(instance :: toUppercaseMethod_nonStatic).collect(Collectors.toList()); // calling Non static method. Need to create instance of the class
	 System.out.println("Second flaour: "+uppercaseString2);
	 
	 
	//List<String> uppercaseString4= sList.stream().map(MethodReferenceProg :: toUppercaseMethod_nonStatic).collect(Collectors.toList()); // ????? why this is not working ????
	//	System.out.println("Second flaour: "+uppercaseString2);
	
		
	}

}

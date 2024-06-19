package com.practice.java8.udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface MyInterface<T> {
	String toUpperCaseMethod(String str);

	static String toUpperCseAMethod_Static(String str) {
		return str.toUpperCase();
	}

	default String toUpperCseAMethod_defaualt(String str) {
		System.out.println("Inside Default method");
		return str.toUpperCase();
	}
}

public class MethodReferenceProgSet2 {

	public static void main(String[] args) {

		// using lambda  
		MyInterface mIntrf= (str) -> str.toUpperCase();                       
		String uStr= mIntrf.toUpperCaseMethod("sudhir");
		System.out.println("uStr is : "+uStr);
		
		// Using Method ref
		MyInterface my = String :: toUpperCase;
		String methodref =	my.toUpperCaseMethod("using method ref");
		System.out.println("methodref is : "+methodref);
		
		MyInterface myIf = MyInterface::toUpperCseAMethod_Static;// Creating ref 
		String str2=	myIf.toUpperCaseMethod("asdfg");
		System.out.println("STR2 is : "+str2);
		
		
		//Q. Create a list of strings from an array using a constructor reference.
		Supplier<List<String>> sup = ArrayList<String>:: new;
		List<String> list = sup.get();
		
	}

}

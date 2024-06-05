package com.practice.java8.concept;

interface DefautTestInterface {
	default int show() {
		System.out.println("Inside show mehtod");
		return 1;
	}
	int test();
	static int test2() {
		return 2;
	}
}

class MyClass implements DefautTestInterface {
	@Override
	public int test() {
		System.out.println("Implemented method");
		return 0;
	}

}

public class DefaultMethodMain {
	public static void main(String[] args) {

		System.out.println("Hi Java 8");
		System.out.println(DefautTestInterface.test2());
		
		MyClass mc = new MyClass();
		Runnable r= mc::show; 
		//System.out.println(r.run());
	}

}

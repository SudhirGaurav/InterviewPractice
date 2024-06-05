package com.practice.java8.concept;

interface defaultInterfac{
	default void disp(){
		System.out.println("Display Method");
	}
}

public class DefaultMethodConcept implements defaultInterfac {
	public static void main(String[] args) {
		
		DefaultMethodConcept concept = new DefaultMethodConcept();
		Runnable r =	concept :: disp;  // VVImp concept ... This line just refer the method with method reference 
		r.run();    // At this line , it ll execute disp method
		System.out.println("Main finished");
	}

}

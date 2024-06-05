package com.practice.java8.concept;

interface Parrent1 {
	
	default void show () {
		System.out.println("Parrent 1 show ");
	}
	
	public static void temp() {
		
	}
}

interface Parent2 {
	default void show() {
		System.out.println("Parrent 2 show ");
	}
}

class Derived implements Parrent1 , Parent2{

	@Override
	public void show() {  // this override is must
		Parrent1.super.show();
		//Parent2.super.show();
	}
}
public class DefaultMethodWithMultipeInheritence {

	public static void main(String[] args) {

		Derived derived= new Derived();
		derived.show();
	}

}

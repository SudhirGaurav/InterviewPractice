package com.example.customeimmutableclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Declare the class as final so it can’t be extended.
Make all of the fields private so that direct access is not allowed.
Don’t provide setter methods for variables.
Initialize all fields using a constructor method performing deep copy.
Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 */

final class MyImmutableClass{
	private int id ;
	private String name ;
	private  List<Object> list;
	
	public MyImmutableClass(int id,String name , List<Object> list) {
		this.id=id;
		this.name = name ;
		this.list =  new ArrayList<>(list); // U can not use clone method here 
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public List<Object> getList() {
		List<Object>  deep_coppy_list = new ArrayList<>(this.list);
		return deep_coppy_list ;
	}
}
public class MyImmutableClassMain {

	public static void main(String[] args) {
		MyImmutableClass impC = new MyImmutableClass(0, "sudhir", Arrays.asList("abc", "bcs"));		
	}

}

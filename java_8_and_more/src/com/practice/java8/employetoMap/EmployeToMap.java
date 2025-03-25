package com.practice.java8.employetoMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Employe{
	int id;
	String name ;
	public Employe(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class EmployeToMap {
	//List<Employe> list = Arrays.asList(new Employe(1, "Sudhir"), new Employe(2, "Gaurav"));

	List<Employe> eList = new ArrayList<>();

	public static void main(String[] ags) {
		System.out.println("Hiii");
		
	}

}

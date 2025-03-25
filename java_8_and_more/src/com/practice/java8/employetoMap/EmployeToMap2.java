package com.practice.java8.employetoMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{
	int id;
	String name ;
	public Employee(int id, String name) {
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
public class EmployeToMap2 {
	public static void main(String[] args) {
		System.out.println("hey 222");
		
		List<Employee> empls= new ArrayList<>();
		empls.add(new Employee(1, "Sudhir"));
		empls.add(new Employee(2, "Gaurav"));
		Map<Integer, String> eMap=	empls.stream().collect(Collectors.toMap(Employee :: getId, Employee :: getName));
		
		System.out.println("eMap is : "+eMap);
		Map<Integer, String> eMap2=	empls.stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
		System.out.println("eMap2 is : "+eMap2);

	}

}

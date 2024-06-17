package com.practice.java8.legacycode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employe implements Comparable<Employe> {
	  int id;
	  String name ;
	public Employe(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Employe o) {

		//return  (this.id - o.id ); // Increasing order
		return  (o.id- this.id ); // Decreasing order
	}
 }


	class Person {
		int id;
		String name;

		public Person(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + "]";
		}
	}
	
	class PersonSortById implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
		return	o1.id-o2.id;
		}
	}
public class LegacyCodeOfSorting {
	public static void main(String[] args) {

		/*
		 * List<Employe> eList = Arrays.asList(new Employe(1, "Sudhir"), new Employe(3,
		 * "Gaurav") , new Employe(2, "Nikhil")); System.out.println(eList);
		 * Collections.sort(eList); System.out.println("After sort"+eList);
		 */
		forPersonSorting();
	}

	private static void forPersonSorting() {
		
		//Integer
		List<Person> pList = Arrays.asList(new Person(1, "Sudhir"), new Person(3, "Gaurav") , new Person(2, "Nikhil"));
		Collections.sort(pList , new PersonSortById());
		System.out.println("After person sort is : ");
		System.out.println(pList);

	}

}

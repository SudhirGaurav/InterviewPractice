package com.practice.java8.udemy.customeclass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
				+ noOfStudents + "]";
	}
}

class MyUtilClass{
	
	public static boolean isValueGreaterThan90(Course course ) {
		return course.getReviewScore() >90;
	}
	
}
public class CustomeClassProg {
	public static void main(String[] args) {
		List<Course> courses= Arrays.asList(
				new Course("Spring", "Framwork", 98, 2000),
				new Course("Spring Boot", "Framwork", 95, 18000),
				new Course("API", "Framwork", 97, 22000),
				new Course("Microservice", "Microservice", 92, 2000),
				new Course("FullStack", "FullStack", 90, 2000),
				new Course("AWS", "cloud", 91, 2000),
				new Course("Azure", "cloud",70, 2000),
				new Course("Docker", "cloud", 18, 2000),
				new Course("Kuberneties", "clous", 8, 2000)
				);
		
		//Q1.check a;; courses where reviews a r greater than 90
		//question1(courses);
		
		//Q2. Sort by reviews
		//question2(courses);
		
		//Q3. Limit , skip
		question3(courses);
		
		//Q4. max, min
		question4(courses);
	}

	private static void question1(List<Course> courses) {
		System.out.println(courses.stream().allMatch(course -> course.getReviewScore()>90)); // By lambda expression
		Predicate<Course> predicate = MyUtilClass :: isValueGreaterThan90;
		System.out.println("My Method ref: "+courses.stream().allMatch(predicate)); 
	}
	
	private static void question2(List<Course> courses) {

	List<Course> sortedList=courses.stream().sorted(Comparator.comparing(Course :: getReviewScore)).collect(Collectors.toList());
	System.out.println(sortedList);
	}
	
	private static void question3(List<Course> courses) {

	List<Course> sortedList=courses.stream().limit(4)
			.collect(Collectors.toList());
	System.out.println(sortedList.size());
	System.out.println(sortedList);
	
	List<Course> skipedList=courses.stream().skip(8)   // It skips first 'n' element
			.collect(Collectors.toList());
	System.out.println(skipedList.size());
	System.out.println(skipedList);
	}
	
	private static void question4(List<Course> courses) {
		Optional<Course> max = courses.stream().max(Comparator.comparing(Course :: getNoOfStudents));
	Course value =	max.get();
	System.out.println("Value is: "+value);
	}
}

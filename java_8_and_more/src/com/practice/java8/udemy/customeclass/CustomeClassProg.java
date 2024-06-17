package com.practice.java8.udemy.customeclass;

import java.util.Arrays;
import java.util.List;

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

public class CustomeClassProg {
	public static void main(String[] args) {

		List<Course> courses= Arrays.asList(
				new Course("Spring", "Framwork", 98, 2000),
				new Course("Spring Boot", "Framwork", 95, 18000),
				new Course("API", "Framwork", 97, 22000),
				new Course("Microservice", "Microservice", 98, 2000),
				new Course("FullStack", "FullStack", 98, 2000),
				new Course("AWS", "cloud", 98, 2000),
				new Course("Azure", "cloud", 98, 2000),
				new Course("Docker", "cloud", 98, 2000),
				new Course("Kuberneties", "clous", 98, 2000)
				);
	}
}

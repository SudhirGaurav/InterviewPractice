package com.example.executerservice.competitive_question;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/*
 * Problem Statement:
		You are given an array of integers. Implement a Java program that calculates the sum of squares of 
		all elements in the array using multiple threads and ExecutorService.
 */
class SumOfSquareOfArrayElementTask implements Callable<Integer>{

	int[] arr;
	SumOfSquareOfArrayElementTask(int[] arr){
		this.arr=arr;
		
	}
	@Override
	public Integer call() throws Exception {
		
		//Java 8 
		 int sumOfSquare = Arrays.stream(arr).map(a -> a*a).sum();
		///*****************************
		 /*
		  * Traditional  for loop
		  */
		int sum = 0;
		for (int i : arr) {
			sum = sum + i * i;
		}
		//**********************
		return sumOfSquare;
	}
}

public class AddingSquareOfArray {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int[] arr = {3,4};
		SumOfSquareOfArrayElementTask task = new SumOfSquareOfArrayElementTask(arr);
		
	ExecutorService es =Executors.newFixedThreadPool(5);
	Future<Integer> future =es.submit(task);
	int retValue = future.get();
	System.out.println("Sum value is : "+retValue);
	}

}

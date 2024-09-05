package com.practice.java8.udemy.thread;

import java.util.Iterator;

/*
 * 
 * Note : Runnable is an functional interface in java-8
 */
public class ThreadPrograming {

	public static void main(String[] args) {

		Runnable r = ()-> {
			System.out.println(Thread.currentThread().getName());
		};
		
		Thread t1 = new Thread(r);
		t1.start();
	}

}

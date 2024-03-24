package com.example.simplethread;

import java.util.Iterator;

/*
 * Question : Use two Thread to increment a counter by 1000 time by each THread . Final result of counter should be 2000.
 */

/*
 * Concept learn after program ,
 * 1. Use common object as monitor in synchronized block
 * 2.if u do not used synchronized block u ll miss the a proper result 
 * 3[imp], u can improve bellow code by making increment method synchronized .  Synchronized block is not required after that 
 */

class CounterClass {
	int counter = 0;

	public void increment() {
		counter++;
	}
}
public class IncrementCounter {

	public static void main(String[] args) throws InterruptedException{

		CounterClass cc = new CounterClass();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				synchronized (cc) {
					for (int i = 0; i < 1000; i++) {
						cc.increment();
						
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				synchronized (cc) {
					for (int i = 0; i < 1000; i++) {
						cc.increment();
						
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("Finally count is : "+cc.counter);
	}

}

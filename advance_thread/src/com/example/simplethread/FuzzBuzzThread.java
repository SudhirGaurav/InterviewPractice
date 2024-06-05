package com.example.simplethread;

class Demo{
	volatile int  n =0; // to make immediate visibility to all thread

	Demo(int n){
		this.n = n;
	}
	
	 public void fuzz() {
		 for (int i = 0; i < n; i++) {
			System.out.println("Fuzz");
		}
	 }
	 
	 public void buzz() {
		 for (int i = 0; i < n; i++) {
			System.out.println("Buzz");
		}
	 }
 }

	class MyThread implements Runnable {
		public void run() {
			Demo d = new Demo(2);
			if (Thread.currentThread().getName().equals("first")) {
				d.fuzz();
			} else {
				d.buzz();
			}
		}
	}

public class FuzzBuzzThread {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start *******************");
		Thread t1 = new Thread(new MyThread());
		t1.setName("first");
		t1.start();

		Thread.sleep(1000);
		
		Thread t2 = new Thread(new MyThread());
		t2.setName("second");
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("End *******************");

	}
}

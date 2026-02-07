package com.example.simplethread;



class MyTask implements Runnable{

	@Override
	public void run() {
			while (true) {
				synchronized (Object.class) { // THread t1 apply lock on Object class . Once this block completes , Lock on Object class will be unlock
				try {
					System.out.println("Inside My Task");
					
					System.out.println("Odd");
					Thread.sleep(2000);
					Object.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Object.class.notifyAll();
			} // Object class will Unlock here 
		}
	}

}

class MyTask_2 implements Runnable {

	MyTask_2() {

	}

	@Override
	public void run() {
			while (true) {
				synchronized (Object.class) {
				System.out.println("Inside My Task-2");
				try {
					//Object.class.wait();
					System.out.println("Even");
					Thread.sleep(2000);
					Object.class.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//Object.class.notifyAll();
			}

		}
	}

}

public class FuzzBuzzThread_2 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new MyTask());
		t1.setName("Thread-Service");
		t1.start();
		
		//Thread.sleep(1000);
		
		Thread t2 = new Thread(new MyTask_2());
		t2.setName("Thread-Service_2");
		t2.start();

	}

}

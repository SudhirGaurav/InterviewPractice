package com.example.simplethread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PerfortmTask implements Runnable {

	List<String> list;
	public PerfortmTask(List list) {
		this.list = list;
	}
	@Override
	public void run() {
		System.out.println("Inside run...");
		list.add("sadsad");
		System.out.println("List inside run : "+list);

	}
}

public class ExecuterServuceExample {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		PerfortmTask task = new PerfortmTask(list);
		ExecutorService es=	Executors.newFixedThreadPool(5);
		es.execute(task);
		es.shutdown();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("List in main THread : "+list);
	
		
	}

}

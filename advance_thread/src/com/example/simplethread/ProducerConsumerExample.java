package com.example.simplethread;

import java.util.ArrayList;
import java.util.List;

class ProducingList implements Runnable{

	List<String> list;
	private static final int MAX_LIST_SIZE=1;
	public ProducingList(List list) {
		this.list=list;
	}
	@Override
	public void run() {
		int count=0;
		while (true) {
			synchronized (list) {
				if(list.size() == MAX_LIST_SIZE) {
					try {
						System.out.println("Adding value is list is full, hence Producer is waiting...");
					list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					String produced = "Thread-"+count++;
					System.out.println("Inside Producer Produced : "+produced);

					list.add(produced);
					try {Thread.sleep(1000);} 
					catch (InterruptedException e) {e.printStackTrace();}
					list.notify();
				}
			}
		}
	}
}
class ConsumingList implements Runnable{

	List<String> list;
	public ConsumingList(List<String> list) {
		this.list= list;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (list) {
				if(list.size()==0) {
					System.out.println("list is Empty.Hence,Consumer is waiting to ");
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					String value =list.get(0);
					System.out.println("Insise consumer consuled : "+value);
					list.remove(0);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					list.notify();
				}
			}
		}
	}
}
public class ProducerConsumerExample {

	public static void main(String[] args) throws InterruptedException {

		List<String> sharedList = new ArrayList<>();
		Thread t1 = new Thread(new ProducingList(sharedList));
		t1.start();
		//t1.join(); // Curret thread [main - thread ] will wait untill t1 finish his task
		Thread t2 = new Thread(new ConsumingList(sharedList));
		t2.start();
		
	}
}

/*Concept after writting code:
1. Both Thread doing IPC by common object list .

*/
package com.example.simplethread;

class OddEvenCounter {
	int counter = 0;

	public void increment() {
		counter++;
	}
}
class EvenClass implements Runnable {
	OddEvenCounter oeCC;

	public EvenClass(OddEvenCounter oeCC) {
		this.oeCC = oeCC;
	}

	@Override
	public void run() {
		synchronized (oeCC) {
			while (true) {
				if (oeCC.counter % 2 != 0) {
					try {
						System.out.println("Got  : " + oeCC.counter +" in EVEN calss . Hnece waiting ....");
						oeCC.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("EVEN no is : " + oeCC.counter);
					oeCC.increment();
					
					oeCC.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}
	}
}

class OddClass implements Runnable {
	OddEvenCounter oeCC;

	public OddClass(OddEvenCounter oeCC) {
		this.oeCC = oeCC;
	}
	@Override
	public void run() {
		synchronized (oeCC) {
			while (true) {
				if (oeCC.counter % 2 == 0) {
					try {
						System.out.println("Got  : " + oeCC.counter +" in ODD calss . Hnece waiting ....");
						oeCC.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ODD no is : " + oeCC.counter);
					oeCC.increment();
					
					oeCC.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

public class OddEvenPrint {

	public static void main(String[] args) throws Exception {
		OddEvenCounter oddEvencounter = new OddEvenCounter();
		Thread evenThread = new Thread(new EvenClass(oddEvencounter));
		evenThread.start();
		
		Thread oddThread = new Thread(new OddClass(oddEvencounter));
		oddThread.start();
	}
}

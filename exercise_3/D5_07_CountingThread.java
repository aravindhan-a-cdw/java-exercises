package exercise_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D5_07_CountingThread {

	public static void main(String[] args) {
		Counter count = new Counter();
		
		ExecutorService exe = Executors.newFixedThreadPool(2);
		
		exe.execute(() -> {
			
			while(true) {
				count.increment();
				System.out.println(count.get());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		exe.execute(() -> {
			while(true) {
				count.displayTenDone();
			}
		});
		exe.shutdown();
	}

}

class Counter{
	private int count;
	private boolean printed;
	
	Counter(){
		count = 0;
	}
	
	synchronized void increment() {
		count++;
		if(count % 10 == 0) {
			printed=false;
			notify();
		}
	}
	
	synchronized int get() {
		return count;
	}
	
	synchronized void displayTenDone() {
		if(count % 10 != 0)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		if (!printed) {
			System.out.println("Ten Done");
			printed = true;
		}
		notify();
	}
}


/*
 * Note:
 * - Is there a difference between giving sleep in method and thread execution?
 * 
 */



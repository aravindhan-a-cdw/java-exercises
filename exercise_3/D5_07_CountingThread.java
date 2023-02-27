package exercise_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D5_07_CountingThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter count = new Counter();
		
		ExecutorService exe = Executors.newFixedThreadPool(2);
		
		exe.execute(() -> {
			
			while(true) {
				Thread currThread = Thread.currentThread();
				currThread.setName("thread-1");
				System.out.println(currThread.getState());
//				synchronized(count) {
					count.increment();
					if(count.get() % 10 == 0) {
						System.out.println("Ten Done" + count.get());
					}
					else System.out.println(count.get() + currThread.getName());
//				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				System.out.println(currThread.getState());
			}
		});
		exe.execute(() -> {
			while(true) {
				Thread currThread = Thread.currentThread();
				currThread.setName("thread-2");
				System.out.println(currThread.getState());
//				synchronized(count) {
					count.increment();
					if(count.get() % 10 == 0) {
						System.out.println("Ten Done" + count.get());
					}
					else System.out.println(count.get() + currThread.getName());
//				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		exe.shutdown();
	}

}

class Counter{
	private int count;
	
	Counter(){
		count = 0;
	}
	
	synchronized void increment() {
		count++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	int get() {
		return count;
	}
}


/*
 * Note:
 * - Is there a difference between giving sleep in method and thread execution?
 * 
 */



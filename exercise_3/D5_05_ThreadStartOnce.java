package exercise_3;

public class D5_05_ThreadStartOnce {

	public static void main(String[] args) {
		Thread thread1 = new Thread();
//		Thread thread2 = new Thread();
//		
		System.out.println(thread1.getState());
		thread1.start();
		System.out.println(thread1.getState());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(thread1.getState());
		thread1.interrupt();
		System.out.println(thread1.getState());
//		thread1.start();
	}

}


/* Different states of a Thread in Java
 * - New, Runnable, Blocked, Waiting, Timed_Waiting, Terminated
 * - Using wait if there's only one thread executing will just make your 
 *   program hang eternally.
 * - 
 * 
 */
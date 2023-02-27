package exercise_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D5_02_Synchronized_Access {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(2);
		
		exe.execute(() -> {
			Message.display("[ ------ ");
		});

		exe.execute(() -> {
			Message.display("A Message");
		});

		exe.execute(() -> {
			Message.display(" ------ ]");
		});
		
		exe.shutdown();
	}


}

class Message{
	
	synchronized public static void display(String message) {
		System.out.print(message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}
	
}


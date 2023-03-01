package exercise_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D5_01_Even_Odd_Threading {

	public static void main(String[] args) {
		printWithThreads();
	}

	public static void printWithThreads() {
		ExecutorService exe = Executors.newFixedThreadPool(2);
		
		exe.execute(() -> {
			synchronized (System.out) {
				for (int number = 1; number <= 100; number += 2) {
					System.out.print(number + " ");
				}
				System.out.println("");
			}
		});

		exe.execute(() -> {
			synchronized (System.out) {
				for (int number = 2; number <= 100; number += 2) {
					System.out.print(number + " ");
				}
			}
		});
		
		
		
		exe.shutdown();

	}

}

package exercise_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class D5_06_AlphaCount {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			AlphaCounter count = new AlphaCounter();

			System.out.println((int) '1');
//		ExecutorService exe = Executors.newFixedThreadPool(2);

//		exe.execute(() -> {
			while (true) {
				try {
					String character = input.next();
					if (!count.countChars(character)) {
						break;
					}
					System.out.println(count.getCount());

				} catch (InputMismatchException e) {
					System.out.println("Input didn't match the expected type of string.");
				}
			}
//		});
		}

//		exe.execute(() -> {
//			while (true) {
//				try {
//					String character = input.next();
//					if(!count.countChars(character)) break;
//
//				} catch (InputMismatchException e) {
//					System.out.println("Input didn't match the expected type of string.");
//				}
//			}
//		});

//		exe.shutdown();

	}

}

class AlphaCounter {
	private int count;

	boolean countChars(String strInput) {
		try {
			for (char c : strInput.toLowerCase().toCharArray()) {
				if (c >= 'a' && c <= 'z')
					count = getCount() + 1;
				else
					return false;
			}
		} catch (InputMismatchException | IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public int getCount() {
		return count;
	}

}

//class NonAlphabetic extends Exception {
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "Enter only alphabetic characters!";
//	}
//}
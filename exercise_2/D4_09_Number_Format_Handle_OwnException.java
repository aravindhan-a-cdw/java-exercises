package exercise_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class D4_09_Number_Format_Handle_OwnException {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
//			while (true) {
				int[] marks = new int[10];
				int index = 0;
				while (index != 10) {
					try {
						System.out.printf("Enter student %d mark: ", index + 1);
						int mark = input.nextInt();
						if (mark < 0 || mark > 100) throw new InvalidMarkException();
						marks[index++] = mark;
					} catch (InputMismatchException e) {
						System.out.println("It is not a valid number, Try Again");
						input.next();
					} catch (InvalidMarkException e) {
						System.out.println(e);
					}
				}
				System.out.print("The average of ten students marks is ");
				System.out.println(calculateAverage(marks));
			}
//		}

	}

	public static int calculateAverage(int[] numbers) {
		int sum = 0;
		for (int index = 0; index < numbers.length; ++index) {
			sum += numbers[index];
		}
		return sum / numbers.length;
	}

}


class InvalidMarkException extends Exception {
	static final long serialVersionUID = 342342424;
	@Override
	public String toString() {
		return "The number you have entered is not a valid mark!";
	}
}


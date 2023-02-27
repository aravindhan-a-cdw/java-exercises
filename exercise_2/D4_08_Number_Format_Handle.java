package exercise_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class D4_08_Number_Format_Handle {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			while (true) {
				int[] marks = new int[10];
				int index = 0;
				while (index != 10) {
					try {
						System.out.printf("Enter student %d mark: ", index + 1);
						int mark = input.nextInt();
						marks[index++] = mark;
					} catch (InputMismatchException e) {
						System.out.println("It is not a valid input, Try Again");
						input.next();
					}
				}
				System.out.print("The average of ten students marks is ");
				System.out.println(calculateAverage(marks));
			}
		}

	}

	public static int calculateAverage(int[] numbers) {
		int sum = 0;
		for (int index = 0; index < numbers.length; ++index) {
			sum += numbers[index];
		}
		return sum / numbers.length;
	}

}

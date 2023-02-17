package exercise_1;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateAverage {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter the count of numbers you wish to calculate average: ");
			int count = input.nextInt();
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			int index = count;
			while (index != 0) {
				System.out.print("Enter a number: ");
				int inputInt = input.nextInt();
				numbers.add(inputInt);
				index--;
			}
			System.out.print("Average Value is: ");
			System.out.println(calcAverage(numbers));
		}
	}

	public static int calcAverage(ArrayList<Integer> numbers) {
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		return sum / numbers.size();
	}

}

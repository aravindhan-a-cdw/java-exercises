package exercise_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class D4_07_A_Continuous_Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numerator = 0;
		int denominator = 0;
		
		while(true) {
			System.out.print("Enter a numerator: ");
			try {
				numerator = input.nextInt();
			} catch (InputMismatchException e) {
				String exit = input.next();
				if(exit.compareToIgnoreCase("q") == 0) {
					System.out.println("Ended");
					break;
				}				
				System.out.println("Not a valid value, Try Again!");
				continue;
			}
			
			System.out.print("Enter a denominator: ");
			try {
				denominator = input.nextInt();
			} catch (InputMismatchException e) {			
				System.out.println("Not a valid value, Try Again!");
				input.next();
				continue;
			}
			
			try {
				System.out.print("Result is: ");
				System.out.println(numerator / denominator);
			} catch(ArithmeticException e) {
				System.out.println("Not a valid input");
			}
		}
		input.close();
	}

}

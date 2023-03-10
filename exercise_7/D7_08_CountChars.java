package exercise_7;

import java.util.Scanner;

public class D7_08_CountChars{
	public static void main(String args[]) {
		try (Scanner input = new Scanner(System.in)) {
			int count = 0;
			System.out.println("Enter some text to count: ");
			while(input.hasNext()) {
				String sentence = input.nextLine();
				count += sentence.length();
				System.out.println("Count: "+ count);
				System.out.println("Enter some text to count: ");
			}
		}
		
		
	}
}
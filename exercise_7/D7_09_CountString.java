package exercise_7;

import java.util.Scanner;

public class D7_09_CountString{
	public static void main(String args[]) {
		try (Scanner input = new Scanner(System.in)) {
			int count = 0;
			System.out.print("Enter some sentence to count number of words: ");
			while(input.hasNext()) {
				String sentence = input.nextLine();
				String[] words = sentence.split(" ");
				count += words.length;
				System.out.println("Number of words entered: " + count);
			}
		}
		
		
	}
}
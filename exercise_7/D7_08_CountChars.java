package exercise_7;

import java.util.Scanner;

public class D7_08_CountChars{
	public static void main(String args[]) {
		try (Scanner input = new Scanner(System.in)) {
			int count = 0;
			while(input.hasNext()) {
				String letter = input.nextLine();
				count += letter.toCharArray().length;
				System.out.println(count);
			}
		}
		
		
	}
}
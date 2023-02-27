package exercise_1;
import java.util.Scanner;

public class D1_15_PrintPrimesAndTypeOfNumber {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
//			System.out.print("Enter starting number: ");
//			int start = scan.nextInt();
//			System.out.print("Enter ending number: ");
//			int end = scan.nextInt();
//			displayPrimes(start, end);
			
			System.out.print("Enter a number to check its special properities: ");
			int number = scan.nextInt();
			
			if(isArmstrong(number)) {
				System.out.printf("%d is a Armstrong number.\n", number);
			}
			
			if(isPerfect(number)) {
				System.out.printf("%d is a Perfect number.\n", number);
			}
			
			if(isPalindrome(number)) {
				System.out.printf("%d is a Palindrome number.\n", number);
			}
			
		}
	}
	
	static void displayPrimes(int start, int end) {
		System.out.printf("Prime numbers between %d and %d are: \n", start, end);
		for(int index = start; index <= end; index++) {
			if(isPrime(index)) {
				System.out.println(index);
			}
		}
	}
	
	public static boolean isPrime(int number) {
		if(number == 1 || number == 2) {
			System.out.print(number);
			System.out.println(" is neither prime nor composite!");
			return false;
		}
		for(int index = 2; index <= Math.sqrt(number); index ++) {
			if(number % index == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isArmstrong(int number) {
		int copy = number;
		int sum = 0;
		int digits = 0;
		while(copy != 0) {
			copy /= 10;
			digits++;
		}
		
		copy = number;
		
		while(copy != 0) {
			int digit = copy % 10;
			copy = copy / 10;
			sum += Math.pow(digit, digits);
		}
		return sum == number;
	}
	
	public static boolean isPerfect(int number) {
		
		int sum = 1;
		
		for(int divisor = 2; divisor <= number / 2; ++divisor) {
			if(number % divisor == 0) {
				sum += divisor;
			}
		}
		return sum == number;
	}
	
	public static boolean isPalindrome(int number) {
		int copy = number;
		int reverse = 0;
		
		while(copy != 0) {
			int digit = copy % 10;
			copy /= 10;
			reverse *= 10;
			reverse += digit;
		}
		
//		System.out.println("The reverse is " + String.valueOf(reverse));
		return number == reverse;
	}
	
	

}

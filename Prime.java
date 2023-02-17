package exercise_1;
import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			while(true) {
				System.out.print("Enter a integer: ");
				int inputInt = input.nextInt();
				System.out.println(isPrime(inputInt) ? "It is a Prime Number!": "It is not a Prime Number!");
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

}

class Number {
	int value;
	
	public Number(int num) {
		this.value = num;
	}
	
	public boolean isPrime() {
		
		return false;
	}
	
}

package exercise_1;
import java.util.Scanner;

public class FindLocationInArray {

	public static void main(String[] args) {
		int[] array;
		array = new int[] {0,1,2,3,4,5,5,4,3,2,1,0};
		
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter a number to find its location: ");
			int findElement = input.nextInt();
			int location = 0;
			while(location != -1) {
				location = findLocation(array, findElement, location);
				if(location != -1) {
					System.out.print("The element is present in ");
					System.out.println(location);
				}
			}
		}
	}
	
	public static int findLocation(int[] array, int element, int offset) {
		
		if(offset == -1) return -1;
		if(offset != 0) ++offset;
		
		for(int index = offset; index < array.length; index++) {
			if (array[index] == element) {
				return index;
			}
		}
		
		return -1;
	}

}

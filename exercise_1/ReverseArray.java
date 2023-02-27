package exercise_1;

public class ReverseArray {

	public static void main(String[] args) {
		int array[] = new int[] {9,8,7,6,5,4,3,2,1,0,-1};
		reverseArray(array);
		for(int ele: array) {
			System.out.println(ele);
		}
	}
	
	public static void reverseArray(int[] inputArray) {
		int arraySize = inputArray.length;
		for(int index = 0; index <= arraySize / 2; index++) {
			int temp = inputArray[index];
			inputArray[index] = inputArray[arraySize - index - 1];
			inputArray[arraySize - index - 1] = temp;
		}
	}

}

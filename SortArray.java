package exercise_1;

public class SortArray {

	public static void main(String[] args) {
		int unsortedArray[];
		unsortedArray = new int[] {9,1,2,8,7,3,4,6,5};
		
		ascSort(unsortedArray);
		
		System.out.println("Sorted in Ascending Order: ");
		for (int ele: unsortedArray) {
			System.out.println(ele);
		}
		
		descSort(unsortedArray);
		
		System.out.println("Sorted in Descending Order: ");
		for (int ele: unsortedArray) {
			System.out.println(ele);
		}
		
	}
	
	public static void ascSort(int[] unsortedArray) {
		for(int index = 0; index < unsortedArray.length - 1; index++) {
			boolean swapped = false;
			
			for(int index2 = 0; index2 < unsortedArray.length - 1; index2++) {
				if(unsortedArray[index2] > unsortedArray[index2 + 1]) {
					swapped = true;
					int temp = unsortedArray[index2];
					unsortedArray[index2] = unsortedArray[index2 + 1];
					unsortedArray[index2 + 1] = temp;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	
	public static void descSort(int[] unsortedArray) {
		for(int index = 0; index < unsortedArray.length - 1; index++) {
			boolean swapped = false;
			
			for(int index2 = 0; index2 < unsortedArray.length - 1; index2++) {
				if(unsortedArray[index2] < unsortedArray[index2 + 1]) {
					swapped = true;
					int temp = unsortedArray[index2];
					unsortedArray[index2] = unsortedArray[index2 + 1];
					unsortedArray[index2 + 1] = temp;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}

}

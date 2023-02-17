package exercise_1;

public class TrianglePattern {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1}, {2,3}, {4,5,6}, {7,8,9,10}};
		
		for(int[] arr: matrix) {
			for (int ele: arr) {
				System.out.print(ele);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}

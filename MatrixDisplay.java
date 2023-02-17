package exercise_1;

public class MatrixDisplay {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3,4,5}, {5,4,3,2,1}, {9,8,7,6,5}, {9,8,7,6,5}};
		
		for(int[] arr: matrix) {
			for (int ele: arr) {
				System.out.print(ele);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}

package exercise_1;

public class StudentMarks {

	public static void main(String[] args) {
		int[][] marks = new int[][] { 
			{80, 85, 88, 90, 91}, 
			{81, 82, 85, 87, 91}, 
			{75, 66, 87, 85, 91}
			};
			
		int index = 1;
		for(int[] arr: marks) {
			int score = 0;
			
			for(int ele: arr) {
				score += ele;
			}
			System.out.print("Score of student " + String.valueOf(index) + " is: ");
			System.out.println(score);
			++index;
		}
	}

}

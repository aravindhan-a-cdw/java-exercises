package exercise_1;

public class D2_14_Student_Exam {

	public static void main(String[] args) {
		
	}

}

class Student{
	private String name, rollno;
	
	public Student(String name, String rollno) {
		this.name = name;
		this.rollno = rollno;
	}
}

class Exam extends Student{
	private int[] marks;
	
	public Exam(String name, String rollno, int mark1, int mark2, int mark3) {
		super(name, rollno);
		marks[0] = mark1;
		marks[1] = mark2;
		marks[2] = mark3;
	}
	
	public int calculateTotal() {
		return this.marks[0] + this.marks[1] + this.marks[2];
	}
}

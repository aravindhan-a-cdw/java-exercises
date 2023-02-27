package exercise_1;

public class D2_14_Student_Exam {

	public static void main(String[] args) {
		Result r1 = new Result("Aravindhan", "1234", 50, 60, 70);
//		r1.marks[0] = 1;
		System.out.println(r1.calculateTotal());
	}

}

class Student{
	private String name, rollno;
	public Student(String name, String rollno) {
		this.name = name;
		this.rollno = rollno;
	}
	
	public String getStudentDetails() {
		return this.name + " " + this.rollno; 
	}
}

class Exam extends Student{
	protected int[] marks;
	
	public Exam(String name, String rollno, int mark1, int mark2, int mark3) {
		super(name, rollno);
		marks = new int[3];
		marks[0] = mark1;
		marks[1] = mark2;
		marks[2] = mark3;
	}
}


class Result extends Exam {
	int totalmark;
	
	public Result(String name, String rollno, int mark1, int mark2, int mark3) {
		super(name, rollno, mark1, mark2, mark3);
	}
	
	public int calculateTotal() {
		return this.marks[0] + this.marks[1] + this.marks[2];
	}
}



package exercise_4.creational_pattern;

import java.util.ArrayList;
import java.util.List;

public class FactoryPatternTry {

	public static void main(String[] args) {
		
//		Teacher kidschool = new KinderGarden();
//		kidschool.teaches();
//		
//		Teacher highSchool = new HighSchool();
//		highSchool.teaches();
		
		
	}

}

abstract interface SchoolTeacherFactory{
	public Teacher getTeacher();
}


//public class TeacherTrainer implements SchoolTeacherFactory{
//	
//	private TeacherTrainer() {}
//	
//	public Teacher getTeacher() {
//		if(handleClass == "UKG" || handleClass.equals("LKG")) {
//			return new 
//		}
//	}
//}





abstract interface Teacher{
	public void teaches(Book b);
	public void handleClass();
}


class KinderGardenTeacher implements Teacher{

	@Override
	public void teaches(Book b) {
		System.out.println("We teach students with books which " + b.content());
	}

	@Override
	public void handleClass() {
		System.out.println("Handle class for LKG, UKG");
	}

	
	
}

class HighSchoolTeacher implements Teacher{
	
//	public Book getBook() {
//		return new SubjectBook();
//	}

	@Override
	public void teaches(Book b) {
		System.out.println("We teach students with books which " + b.content());
	}

	@Override
	public void handleClass() {
		System.out.println("Handle class for 11th and 12th ");
	}
}

/*
 * Now I can create new class which will not specify the exact type of 
 * book it will use rather it will specify as a abstract type book
 * and later I can add the new type of book for it to use.
 * 
 */

//class Tutorial implements School{
//	Book getBook() {
//		return null;
//	}
//}



abstract class Book{
	public abstract String content();
	public abstract void coverPage();
	public abstract void print();
}


class StoryBook extends Book{

	public String content() {
		return "Contains story which kids love to read.";
	}

	public void coverPage() {
		System.out.println("Colorful cover page with cartoons which kids love");
	}

	public void print() {
		System.out.println("Print the book in press");
	}
	
}

class SelfHelpBook extends Book{

	public String content() {
		return "Contains life experiences and tips that are helpful for life.";
	}

	public void coverPage() {
		System.out.println("Coverpage which contains catchy title or intuitive phrase about life");
	}

	public void print() {
		System.out.println("Print the book in press");
	}
	
}

class SubjectBook extends Book{

	public String content() {
		return "Contains concepts, questions and answers for exams.";
	}

	public void coverPage() {
		System.out.println("Image of the topics that are covered in the subject.");
	}

	public void print() {
		System.out.println("Print the book in press");
	}
	
}


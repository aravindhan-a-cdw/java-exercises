package exercise_1;

public class D2_10_Class_Constructors {

	public static void main(String[] args) {
		C obj = new C();
		System.out.println(obj);
	}

}

class A{
	public A(){
		System.out.println("Class A constructor called!");
	}
}

class B{
	public B(){
		System.out.println("Class B constructor called!");
	}
}

class C extends A{
	public B obj = new B();
}
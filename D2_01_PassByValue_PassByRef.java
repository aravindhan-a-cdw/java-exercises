package exercise_1;

public class D2_01_PassByValue_PassByRef {

	public static void main(String[] args) {
		int intValue = 100;
		int[] intArray = new int[] {10, 20, 30, 40, 50, 60};
		
		System.out.println("intValue before passing " + String.valueOf(intValue));
		pbv(intValue);
		System.out.println("intValue after passing " + String.valueOf(intValue));
		
		
		System.out.println("intArray[1] before passing " + String.valueOf(intArray[1]));
		pbr(intArray);
		System.out.println("intArray[1] after passing " + String.valueOf(intArray[1]));
		
		System.out.println("This proves that array is PBR and primitives are PBV");
		
		Test testObj = new Test(10, 20);
		
		System.out.println("testObj.x before passing " + String.valueOf(testObj.x));
		pbrObj(testObj);
		System.out.println("testObj.x before passing " + String.valueOf(testObj.x));
		
		
	}
	
	public static void pbv(int value) {
		value = 10;
		System.out.println("The passed value is changed to 10");
	}
	
	public static void pbr(int[] array) {
		array[1] = 10;
		System.out.println("The element at index 1 is changed to 10");
	}
	
	public static void pbrObj(Test obj) {
		obj.x = 110;
		System.out.println("The field x of Test obj is changed to 110");
	}

}

class Test{
	public int x, y;
	
	public Test(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

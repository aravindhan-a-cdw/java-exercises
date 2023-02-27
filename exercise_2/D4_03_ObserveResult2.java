package exercise_2;

import java.io.IOException;

public class D4_03_ObserveResult2 {
	
	public static void main(String[] args) {
		D4_03_ObserveResult2 s1 = new D4_03_ObserveResult2(); 
		s1.mth1();
	}

	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	
	public void mth2() {
		try {
//			throw new IOException();
			System.exit(0);
		}catch(Exception e) {
			System.out.println("catch-mth2");
		}
		finally {
			System.out.println("finally-mth2");
		}		
	}
	

}

/*
 * Notes:
 * 
 * When System.exit(0); is executed the program execution is ended.
 * 
 */


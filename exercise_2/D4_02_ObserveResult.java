package exercise_2;

import java.io.IOException;

public class D4_02_ObserveResult {
	
	public static void main(String[] args) {
		D4_02_ObserveResult s1 = new D4_02_ObserveResult(); 
		s1.mth1();
	}

	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	
	public void mth2() {
		try {
//			throw new IOException();
			return;
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
 * Finally block is always executed.
 * 
 */


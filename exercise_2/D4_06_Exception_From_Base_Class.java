package exercise_2;

import java.io.IOException;

public class D4_06_Exception_From_Base_Class {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Derived d1 = new Derived();
	}

}


class Base {
	public Base() throws IOException {
//		System.out.println("Base called");
		throw new IOException();
	}
}

class Derived extends Base{

	public Derived() throws IOException {
		try {
			Base b1 = new Base();			
		}catch(IOException e) {
			
		}
	}
	
}

/*
 * Derived class constructor cannot catch exception thrown by Base class
 * as the constructor of super class must be the first statement.
 * 
 */


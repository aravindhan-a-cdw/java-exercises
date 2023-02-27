package exercise_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D4_01_Simply_Throw_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
			
//			throwException();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}

	}
	
	public static void throwException() throws IOException {
		FileReader fr = new FileReader("/Users/aravindhan/eclipse-workspace/exercise_1/src/exercise_2/file.txt");
        BufferedReader br = new BufferedReader(fr);
        br.close();
        br.read();
//		throw new IOException();
		// We need to use throws or catch the exception to compile code.
	}

}

package exercise_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class D7_15_CopyFileLineByLine {

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader("abc.properties"));
				PrintWriter out = new PrintWriter(new FileWriter("abc.copy"))) {
			String line;
			while((line = reader.readLine()) != null) {
				out.println(line);
			}
			System.out.println("File copied line by line successfully!");
		}
	}

}

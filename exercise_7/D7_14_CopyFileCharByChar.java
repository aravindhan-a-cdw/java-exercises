package exercise_7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class D7_14_CopyFileCharByChar {

	public static void main(String[] args) throws IOException {
		try (FileReader reader = new FileReader("abc.properties");
				FileWriter writer = new FileWriter("abc.copy")) {
			int character;
			while((character = reader.read()) != -1) {
				writer.write(character);
			}
			System.out.println("File copied successfully!");
			
		}
	}

}

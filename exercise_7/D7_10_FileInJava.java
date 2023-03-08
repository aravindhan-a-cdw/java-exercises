package exercise_7;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class D7_10_FileInJava {

	public static void main(String[] args) throws IOException {
		File file = new File("abc.properties");
		File newFile = new File("xyc.properties");
		
		// Rename file
		file.renameTo(newFile);
		
		// Display size of file
		try (FileReader fileRead = new FileReader(newFile)) {
			char[] readArray = new char[16];
			int count = 0;
			int charsRead = 0;
			while((charsRead = fileRead.read(readArray, 0, 15)) >=  0) {
				count += charsRead;
			}
			System.out.println("File size is " + count + " bytes.");
		}
		
		// Delete file
		newFile.delete();
		
		
	}

}

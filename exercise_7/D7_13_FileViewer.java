package exercise_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D7_13_FileViewer {

	public static void main(String[] args) {
		File file = new File("abc.properties");
		
		// Display size of file
		try (FileReader fileRead = new FileReader(file)) {
			char[] readArray = new char[16];
			int charsRead = 0;
			while((charsRead = fileRead.read(readArray, 0, 15)) >=  0) {
				if(charsRead < 15) {
					String s = new String(readArray, 0, charsRead);
					System.out.print(s);
				}else {
					System.out.print(readArray);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Some unexpected exception");
			e.printStackTrace();
		}
	}

}

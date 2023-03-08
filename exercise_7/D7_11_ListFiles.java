package exercise_7;

import java.io.File;
import java.util.Scanner;

public class D7_11_ListFiles {

	public static void main(String[] args) {
		
		try (Scanner input = new Scanner(System.in)) {
			String directory = input.nextLine();
			
			File folder = new File(directory);
			
			if(folder.isDirectory()) {
				for(File file: folder.listFiles()) {
					if(file.isDirectory()) {
						System.out.print("Directory: ");
					}
					System.out.println(file);
				}
			}
		}
	}

}

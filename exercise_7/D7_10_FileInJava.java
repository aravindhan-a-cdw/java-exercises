package exercise_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class D7_10_FileInJava {

	public static void main(String[] args) throws IOException {
		
		try (Scanner input = new Scanner(System.in)) {
			while(true) {
				System.out.println("1.Delete file\n2.Rename File\n3.Display File size");
				System.out.print("Choose any task: ");
				int choice = input.nextInt();
				
				switch (choice) {
				case 1: {
					System.out.print("Enter the file name: ");
					String fileName = input.next();
					File file = new File(fileName);
					deleteFile(file);
					break;
				}
				case 2: {
					System.out.print("Enter the file to Rename: ");
					String oldFileName = input.next();
					System.out.print("Enter new name to the file: ");
					String newFileName = input.next();
					File oldFile = new File(oldFileName);
					File newFile = new File(newFileName);
					renameFile(oldFile, newFile);
					break;
				}
				case 3: {
					System.out.print("Enter the file name: ");
					String fileName = input.next();
					File file = new File(fileName);
					System.out.println("File size is " + getFileSize(file));
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			}
		}
		
	}
	
	static int getFileSize(File file) {
		int readSize = 16; // Number of characters to read
		int count = 0;
		try (FileReader fileRead = new FileReader(file)) {
			char[] readArray = new char[readSize];
			int charsRead = 0;
			while((charsRead = fileRead.read(readArray, 0, readSize)) >=  0) {
				count += charsRead;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	static void renameFile(File source, File dest) {
		source.renameTo(dest);
		System.out.println("File renamed successfully");
	}
	
	static void deleteFile(File file) {
		file.delete();
		System.out.println("File deleted successfully!");
	}

}

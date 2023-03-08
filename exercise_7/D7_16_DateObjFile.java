package exercise_7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class D7_16_DateObjFile {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("Date Object from java: " + date);
//		ObjectOutputStream objout = null;
//		ObjectInputStream objin = null;

		// Write Date to a file
		try (ObjectOutputStream objout = 
				new ObjectOutputStream(new FileOutputStream("DateFile.txt"))) {
			objout.writeObject(date);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read Date from a file
		try (ObjectInputStream objin = new ObjectInputStream(new FileInputStream("DateFile.txt"))) {
			date = (Date) objin.readObject();
			System.out.println("Date Object loaded from file: " + date);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

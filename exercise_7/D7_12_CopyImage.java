package exercise_7;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class D7_12_CopyImage {

	public static void main(String[] args) throws IOException {
		File image = new File("ssoerror.png");
		File copy = new File("copy.png");
		
		try (InputStream in = new FileInputStream(image);
				OutputStream out = new BufferedOutputStream(new FileOutputStream(copy))) {
			byte[] buffer = new byte[1024];
			int lengthRead = 0;
			while((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
			System.out.println("File has been copied successfully!");
		}
	}

}

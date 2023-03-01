package exercise_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitCallable {

	public static void main(String[] args) {

		ExecutorService exe = Executors.newFixedThreadPool(2);
		
		exe.execute(() -> {
			ExecutorService exe1 = Executors.newFixedThreadPool(2);
			exe.execute(() -> {
				try {
					getData("https://the-trivia-api.com/api/questionsfas/");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			
		});

		Future response = exe.submit(() -> {
			return getData("https://the-trivia-api.com/api/questionsfas/");
		});
		
		exe.shutdown();
		
		try {
			System.out.println(response.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some error");
		}

	}
	
	public static String getData(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      try (BufferedReader reader = new BufferedReader(
	                  new InputStreamReader(conn.getInputStream()))) {
	          for (String line; (line = reader.readLine()) != null; ) {
	              result.append(line);
	          }
	      }
	      return result.toString();
	   }

}

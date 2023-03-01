package exercise_4.creational_pattern;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTonPattern {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(1);
		
		exe.execute(() -> {
			Connection con = DBConnection.getConnection();
			System.out.println(con);
			DBConnection.closeConnection();
		});
		
		exe.execute(() -> {
			Connection con = DBConnection.getConnection();
			System.out.println(con);
		});
		
		exe.execute(() -> {
			Connection con = DBConnection.getConnection();
			System.out.println(con);
		});
		
		exe.execute(() -> {
			Connection con = DBConnection.getConnection();
			System.out.println(con);
		});
		
		exe.shutdown();
	}

}

class DBConnection {
	private static Connection connection;
	
	private DBConnection() {}

//	static {
//		if(connection == null) {
//			
//			String url = "jdbc:postgresql://floppy.db.elephantsql.com/tctgkifp?user=tctgkifp&password=kysq7o_PhA7EmKJCUhanFZMMIU812obx";
//			
//			try {
//				connection = DriverManager.getConnection(url);
//			} catch (SQLException e) {
//				System.out.println("Connection Failed");
//			}
//			System.out.println("Connection successful");
//		}		
//	}
	
	// Lazy Initialization
	synchronized public static Connection getConnection() {
		if(connection == null) {
			String url = "jdbc:postgresql://floppy.db.elephantsql.com/tctgkifp?user=tctgkifp&password=kysq7o_PhA7EmKJCUhanFZMMIU812obx";
			
			try {
				connection = DriverManager.getConnection(url);
//				System.out.println("Connection successful");
			} catch (SQLException e) {
				e.printStackTrace();
//				System.out.println("Connection Failed");
				throw new RuntimeException("Connection failed");
			}
		}	
		return connection;
	}
	
	synchronized public static void closeConnection() {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		connection = null;
	}
	
	
}

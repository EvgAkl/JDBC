package completeProgram;

import java.io.*;
import java.sql.*;

public class CreateDatabase implements iConnect{
	// Declaration variables
	private String driver, url, user, password = "1111";
	private String sql;
	private Connection conn = null;
	private Statement stmt = null;
	// Declaration constructions
	CreateDatabase(){
		try (BufferedReader objRead = new BufferedReader(new FileReader("source.txt"))) {
			int character;
			String currentTopic;
			do{
				character = objRead.read();
				if (character == '#'){
					currentTopic = objRead.readLine();
					if (currentTopic.equals("driver")){
						driver = objRead.readLine();
						System.out.println("driver: " + driver);
					} // end if 2
					if (currentTopic.equals("urlForCreateOrDelete")){
						url = objRead.readLine();
						System.out.println("url: " + url);
					} // end if 3
					if (currentTopic.equals("user")) {
						user = objRead.readLine();
						System.out.println("user: " + user);
					} // end if 4
					if (currentTopic.equals("sqlForCreateDatabase")){
						sql = objRead.readLine();
						System.out.println("sql: " + sql);
					}
				} // end if 1
			} while (character != -1);
		} // end try
		catch (FileNotFoundException e1) { System.out.println("File not found!"); }
		catch (IOException e2) { e2.printStackTrace(); }
	}
	// Declaration methods
	public void openCunnection(){		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} // end try
		catch (ClassNotFoundException | SQLException e1 ){
			e1.printStackTrace();
		}
	} // end openConnection()
	public void closeConnection(){
		try{
			if (stmt != null) { stmt.close(); } 
		} // end try
		catch (SQLException e2) { /* to do nothing */ }
		try {
			if (conn != null) { conn.close(); }
		} // end try
		catch (SQLException e3) { e3.printStackTrace(); }
	} // end closeConnection()
	public void run(){
		openCunnection();
		try{		
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("Database create successfully");
		} // end try
		catch (SQLException e4) { e4.printStackTrace(); }
		finally { closeConnection(); }
	} // end run()
} // end class



















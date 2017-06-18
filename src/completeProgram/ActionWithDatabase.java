package completeProgram;

import java.io.*;
import java.sql.*;

public abstract class ActionWithDatabase{
	// Declaration variables
	protected String sourceSQL, additionalSQL, sourseURL; 
	protected String driver, url, user, password;
	protected String sql, info;
	protected final int GENERAL_DATABASE = 1, TARGET_DATABASE = 2;
	protected int actualDatabase;
	protected Connection conn = null;
	protected Statement stmt = null;
	// Declaration constructors
	public ActionWithDatabase(){
		int character;
		String currentTopic;
		initializationSQL();
		try (BufferedReader objRead = new BufferedReader(new FileReader("source.txt"))) {
			do{
				character = objRead.read();
				if (character == '#'){
					currentTopic = objRead.readLine();
					if (currentTopic.equals("driver")){
						driver = objRead.readLine();
						System.out.println("driver: " + driver);
					} // end if 1_1
					if (currentTopic.equals(sourseURL)){
						url = objRead.readLine();
						System.out.println("url: " + url);
					} // end if 1_2
					if (currentTopic.equals("user")) {
						user = objRead.readLine();
						System.out.println("user: " + user);
					} // end if 1_3
					if (currentTopic.equals("password")){
						password = objRead.readLine();
						System.out.println("password: " + password);
					} // end if 1_4					
					if (currentTopic.equals(sourceSQL)){
						if (actualDatabase == GENERAL_DATABASE){
							sql = additionalSQL + objRead.readLine() ;
							System.out.println("sql: " + sql);
						} // end if 1_4_1
						else if (actualDatabase == TARGET_DATABASE){
							sql = "";
							do{
								info = objRead.readLine();
								if (info != null) { sql += info; }
							} while ((info != null) && (info.compareTo("") != 0));
							System.out.println("sql: " + sql);
						} // end if 1_4_2
					} // end if 1_5
				} // end if 1
			} while (character != -1);
		} // end try
		catch (FileNotFoundException e1) { System.out.println("File not found!"); }
		catch (IOException e2) { e2.printStackTrace(); }
	}
	// Declaration methods
	protected abstract void initializationSQL();
	public abstract void run();
	protected void openCunnection(){		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} // end try
		catch (ClassNotFoundException | SQLException e1 ){
			e1.printStackTrace();
		}
	} // end openConnection()
	protected void closeConnection(){
		try{
			if (stmt != null) { stmt.close(); } 
		} // end try
		catch (SQLException e2) { /* to do nothing */ }
		try {
			if (conn != null) { conn.close(); }
		} // end try
		catch (SQLException e3) { e3.printStackTrace(); }
	} // end closeConnection()
} // end class



















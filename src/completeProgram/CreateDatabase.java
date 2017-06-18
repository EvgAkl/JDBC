package completeProgram;

import java.sql.*;

public class CreateDatabase extends ActionWithDatabase{
	// Declaration variables
	// --
	// Declaration constructions
	public CreateDatabase(){
		super();
	}
	// Declaration methods
	protected void initializationSQL(){
		sourceSQL = "nameDatabaseForCreate";
		additionalSQL = "CREATE DATABASE ";
		actualDatabase = GENERAL_DATABASE;
	} // end initializationSQL
	public void run(){
		openCunnection();
		try{		
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("Database create successfully");
		} // end try
		catch (SQLException e4) { 
			System.out.println("Error, such a database already exist! "); 
		}
		finally { closeConnection(); }
	} // end run()
} // end class



















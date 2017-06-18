package completeProgram;

import java.sql.*;

public class DropDatabase extends ActionWithDatabase{
	// Declaration variables
	// --
	// Declaration constructions
	public DropDatabase(){
		super();
	}
	// Declaration methods
	protected void initializationSQL(){
		sourceSQL = "nameDatabaseForDrop";
		additionalSQL = "DROP DATABASE ";
		actualDatabase = GENERAL_DATABASE;
	} // end initializationSQL
	public void run(){
		openCunnection();
		try{		
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("Database drop successfully");
		} // end try
		catch (SQLException e4) { 
			System.out.println("Error, such a database doesn't exist! ");
		}
		finally { closeConnection(); }
	} // end run()
} // end class



















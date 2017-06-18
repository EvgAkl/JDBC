package completeProgram;

import java.sql.SQLException;

public class CreateTable extends ActionWithDatabase{
	// Declaration variables
	// --
	// Declaration constructors
	public CreateTable(){
		super();
	}
	// Declaration methods
	protected void initializationSQL(){
		sourceSQL = "sqlForCreateTable";
		sourseURL = "urlForUse";
		actualDatabase = TARGET_DATABASE;
	} // end initializationSQL
	public void run(){
		openCunnection();
		try{		
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("Table create successfully");
		} // end try
		catch (SQLException e4) { 
			System.out.println("Syntax error or such a table is already exist! ");
		}
		finally { closeConnection(); }
	} // end run()
} // class

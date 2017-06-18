package completeProgram;

import java.sql.SQLException;

public class InsertRecord extends ActionWithDatabase{
	// Declaration variables
		// --
		// Declaration constructors
		public InsertRecord(){
			super();
		}
		// Declaration methods
		protected void initializationSQL(){
			sourceSQL = "sqlForInsertRecord";
			sourseURL = "urlForUse";
			actualDatabase = TARGET_DATABASE;
		} // end initializationSQL
		public void run(){
			openCunnection();
			try{		
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
				System.out.println("Record insert successfully");
			} // end try
			catch (SQLException e4) { 
				System.out.println("Syntax error or such record is already exist! ");
			}
			finally { closeConnection(); }
		} // end run()

}

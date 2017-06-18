package completeProgram;

import java.sql.SQLException;

public class DeleteRecord extends ActionWithDatabase{
	// Declaration variables
		// --
		// Declaration constructors
		public DeleteRecord(){
			super();
		}
		// Declaration methods
		protected void initializationSQL(){
			sourceSQL = "sqlForDeleteRecord";
			sourseURL = "urlForUse";
			actualDatabase = TARGET_DATABASE;
		} // end initializationSQL
		public void run(){
			openCunnection();
			try{		
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
				System.out.println("Record delete successfully");
			} // end try
			catch (SQLException e4) { 
				System.out.println("Syntax error or such record is doesn't exist! ");
			}
			finally { closeConnection(); }
		} // end run()

}

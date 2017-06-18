package completeProgram;

import java.sql.SQLException;

public class UpdateRecord extends ActionWithDatabase{
	// Declaration variables
		// --
		// Declaration constructors
		public UpdateRecord(){
			super();
		}
		// Declaration methods
		protected void initializationSQL(){
			sourceSQL = "sqlForUpdateRecord";
			sourseURL = "urlForUse";
			actualDatabase = TARGET_DATABASE;
		} // end initializationSQL
		public void run(){
			openCunnection();
			try{		
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
				System.out.println("Record update successfully");
			} // end try
			catch (SQLException e4) { 
				System.out.println("Syntax error! ");
			}
			finally { closeConnection(); }
		} // end run()

}

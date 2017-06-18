package completeProgram;

import java.sql.SQLException;

public class DropTable extends ActionWithDatabase{
	// Declaration variables
		// --
		// Declaration constructors
		public DropTable(){
			super();
		}
		// Declaration methods
		protected void initializationSQL(){
			sourceSQL = "sqlForDropTable";
			sourseURL = "urlForUse";
			actualDatabase = TARGET_DATABASE;
		} // end initializationSQL
		public void run(){
			openCunnection();
			try{		
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
				System.out.println("Table drop successfully");
			} // end try
			catch (SQLException e4) { 
				System.out.println("Syntax error or such a table doesn't exist! ");
			}
			finally { closeConnection(); }
		} // end run()
} // end class

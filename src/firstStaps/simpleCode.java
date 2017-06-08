package firstStaps;

// Step 1 - Import packages
import java.sql.*;

public class simpleCode {
	// Declaration variables
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/testsql";
	private static final String USER = "root";
	private static final String PASSWORD = "1111";
	// Declaration constructions
	// --
	// Declaration methods
	public void run(){
		Connection conn = null;
		Statement stmt = null;
		String sql;
		int id, age;
		String first, last;
		try{
			// Step 2 - Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Step 3 - Open a connection
			System.out.println("Connection to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			// Step 3 - Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			// Step 5 - Extract data from result set
			System.out.println("ID\t" + "Age\t" + "First\t" + "Last\t");
			System.out.println("---------------------------------");
			while(rs.next()){
				// Retrieve by column name
				id = rs.getInt("id");
				age = rs.getInt("age");
				first = rs.getString("First");
				last = rs.getString("last");
				// Display values
				System.out.println(id + "\t" + age + "\t" + first + "\t" + last);
			}
			// Step 6 - Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} // end try
		catch (SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if (stmt != null){
					stmt.close();
				}
			} // end try
			catch (SQLException se){
				se.printStackTrace();
			}
		} // end finally		
	} // end run()
} // end class

package completeProgram;

import java.io.*;
import java.sql.*;

public class SelectRecord extends ActionWithDatabase{
	// Declaration variables
	private final int SIZE_ARRAY = 20;
	private String[] columnName = new String[SIZE_ARRAY];
	private String[] columnType = new String[SIZE_ARRAY];
	private int i = 0;
	// Declaration constructors
	public SelectRecord(){
		super();
		int character;
		String currentTopic, info;
		try (BufferedReader objRead = new BufferedReader(new FileReader("source.txt"))) {
			do{
				character = objRead.read();
				if (character == '#'){
					currentTopic = objRead.readLine();
					if (currentTopic.equals("columnsNameForSelectQuery")){
						i = 0;
						do{
							info = objRead.readLine();
							if (info != null) { 
								columnName[i] = info;
								i++;
							}
						} while ((info != null) && (info.compareTo("") != 0));
					} // end if 1_1
					if (currentTopic.equals("dataTypeColumnsForSelectQuery")){
						i = 0;
						do{
							info = objRead.readLine();
							if (info != null) { 
								columnType[i] = info;
								i++;
							}
						} while ((info != null) && (info.compareTo("") != 0));
					} // end if 1_2
				} // end if 1
			} while (character != -1);
		} // end try
		catch (FileNotFoundException e1) { System.out.println("File not found!"); }
		catch (IOException e2) { e2.printStackTrace(); }
	}
	// Declaration methods
	protected void initializationSQL(){
		sourceSQL = "sqlForSelectQuery";
		sourseURL = "urlForUse";
		actualDatabase = TARGET_DATABASE;
	} // end initializationSQL
	public void run(){
		
		String[] valuesStr = new String[SIZE_ARRAY];
		int[] valuesInt = new int[SIZE_ARRAY];
		double[] valuesDouble = new double[SIZE_ARRAY];
		openCunnection();
		try{		
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			i = 0;
			
			while (columnName[i] != null){
				System.out.print(columnName[i] + "\t" + "\t" );
				i++;
			}
			System.out.print("\n");
			System.out.println("-----------------------------------------------------------------------------------------");
			
			while(rs.next()){
				i = 0;
				do{
					if (columnType[i].equals("String")) {
						valuesStr[i] = rs.getString(columnName[i]);
					}
					else if (columnType[i].equals("Int")) {
						valuesInt[i] = rs.getInt(columnName[i]);
					}
					else if (columnType[i].equals("Double")) {
						valuesDouble[i] = rs.getDouble(columnName[i]);
					}
					i++;
				} while (columnType[i] != null | columnName[i] != null);
				i = 0;
				do{
					if (valuesStr[i] != null){
						System.out.print(valuesStr[i] + "\t" + "\t");
					}
					else if (valuesInt[i] != 0){
						System.out.print(valuesInt[i] + "\t"+ "\t");
					}
					else if (valuesDouble[i] != 0){
						System.out.print(valuesDouble[i] + "\t"+ "\t");
					}
					i++;	
				} while (!(valuesStr[i] == null & valuesInt[i] == 0 & valuesDouble[i] == 0));
				System.out.print("\n");	
			} // end while
			
			
			System.out.print("\n");
			System.out.println("Record select successfully");
		} // end try
		catch (SQLException e4) { 
			System.out.println("Syntax error! ");
		}
		finally { closeConnection(); }
	} // end run()
	
		

}

package showProgram;

import java.io.*;
import completeProgram.*;

public class Demo {

	public static void main(String[] args) {
		String userChoseString = null; 
		int userChoseInt = 0;
		// TODO Auto-generated method stub
		ActionWithDatabase actualObj = null;
		CreateDatabase objCreateDB = new CreateDatabase();
		DropDatabase objDropDB = new DropDatabase();
		CreateTable objCreateT = new CreateTable();
		DropTable objDropT = new DropTable();
		
		System.out.println("You available following actions: ");
		System.out.println(" 1 - create database");
		System.out.println(" 2 - drop  database");
		System.out.println(" 3 - create table");
		System.out.println(" 4 - drop table");
		System.out.println("Enter the 'q' for the end.");
		System.out.println();
		
		
		try (BufferedReader objRead = new BufferedReader(new InputStreamReader(System.in))){
			
			for ( ; ; ) {
				
				System.out.println("Please, Enter the appropriate action number. ");
				userChoseString = objRead.readLine();
				if (userChoseString.equalsIgnoreCase("q")){
					System.out.println("Good bay.");
					break;
				}
				else {
					userChoseInt = Integer.parseInt(userChoseString);
				}
				switch (userChoseInt){
				case 1:
					actualObj = objCreateDB;
					break;
				case 2: 
					actualObj = objDropDB;
					break;
				case 3:
					actualObj = objCreateT;
					break;
				case 4:
					actualObj = objDropT;
				} // end switch
				actualObj.run();
			} // end endless for	
		}
		catch (NumberFormatException e0){
			System.out.println("You entered wrong format value! ");
		}
		catch (IOException e1) {
			System.out.println("I/O Error! ");
		}
		catch(NullPointerException e2){
			System.out.println("You entered idvalid value! ");
		}

	} // end main()
} // end main class

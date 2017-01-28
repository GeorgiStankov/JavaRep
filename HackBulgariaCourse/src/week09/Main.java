package week09;

import java.sql.*;

public class Main {
	
	static final String DB_URL = "jdbc:mysql://localhost/MOVIES";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		try {
			Connection conn = null;
			Statement stmt = null;
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT title,year,length FROM MOVIE";
			ResultSet rs = stmt.executeQuery(sql);
			
			//STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String id  = rs.getString("title");
		         int age = rs.getInt("year");
		         int name = rs.getInt("length");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", Name: " + name);
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		} catch(Exception se) {
			se.printStackTrace();
		}
	}

}
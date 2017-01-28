package week10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MySQLHelper {


	static final String DB_URL = "jdbc:mysql://localhost/pandaSocialNetwork";
	static final String USER = "root";
	static final String PASS = "";

	private Connection conn = null;
	private Statement stmt = null;
	
	public MySQLHelper() {
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showMovies() {
		try{
			stmt = conn.createStatement();
			String sql;
			sql="SELECT * FROM movies ORDER BY rating;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String movie = rs.getString("name");
				float rating = rs.getFloat("rating");
				// Display values
				System.out.println("ID: " + id);
				System.out.print(",MOVIE: " + movie);
				System.out.print(",RATING:"+rating);
				System.out.println();

			}
			
		}catch(SQLException ex){
			ex.printStackTrace();			
		}
	}
	public List<List<String>> ssowMovies() {

		List<List<String>> result = new LinkedList<>();

		Statement stmt;
		try {
			stmt = conn.createStatement();

			String sql = "";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ResultSetMetaData md = rs.getMetaData();
				int colums = md.getColumnCount();
				List<String> row = new LinkedList<String>();

				for (int i = 0; i < colums; i++) {
					String colName = md.getColumnName(i);
					row.add(rs.getString(colName));
				}
				result.add(row);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

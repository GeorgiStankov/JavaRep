package week09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Dao {

	static final String DB_URL = "jdbc:mysql://localhost/pandaSocialNetwork";
	static final String USER = "root";
	static final String PASS = "";

	private Connection conn = null;
	private Statement stmt = null;

	public Dao() {
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

	public boolean addPanda(PandaDB panda) {

		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			if (hasPanda(panda)) {
				sql = "INSERT INTO panda(name,email,gender) VALUES('" + panda.name + "','" + panda.email + "','"
						+ panda.gender + "')" + "ON DUPLICATE KEY UPDATE name='" + panda.getName() + "',email='"
						+ panda.getEmail() + "',gender='" + panda.getGender() + "'; ";
				stmt.executeUpdate(sql);
			} else {
				System.out.println("Panda have already been registered.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public boolean hasPanda(PandaDB panda) {
		boolean isAdded = false;
		try {
			stmt = conn.createStatement();
			ResultSet set;
			String sql;
			sql = "SELECT name,email FROM panda WHERE name='" + panda.getName() + "' AND email='" + panda.getEmail()
					+ "';";
			set = stmt.executeQuery(sql);
			if (!set.next()) {
				isAdded = true;
			} else {
				isAdded = false;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return isAdded;
	}

	public boolean deletePanda(PandaDB panda) {
		try {
			stmt = conn.createStatement();
			String sql;
			if (!hasPanda(panda)) {
				sql = "DELETE FROM panda WHERE email='" + panda.getEmail() + "';";
				stmt.executeUpdate(sql);
				System.out.println("Panda deleted.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return true;
	}

	public boolean makeFriends(PandaDB panda1, PandaDB panda2) {
		try {
			if (hasPanda(panda1)) {
				addPanda(panda1);
			}
			if (hasPanda(panda2)) {
				addPanda(panda2);
			}
			String sql;
			int IDpanda1 = getPandaID(panda1);
			int IDpanda2=getPandaID(panda2);
			sql = "INSERT INTO panda_friend(panda_id,friend_id) VALUES(" + IDpanda1 + "," + IDpanda2 + "), (" + IDpanda2
					+ "," + IDpanda1 + ") ON DUPLICATE KEY UPDATE panda_id='" + IDpanda1 + "',friend_id='" + IDpanda2
					+ "';";
			stmt.executeUpdate(sql);
			System.out.println("Friendship made :)");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	private int getPandaID(PandaDB panda1) throws SQLException {
		ResultSet set;
		String sql;
		sql = "SELECT id FROM panda WHERE email='" + panda1.email + "';";
		set = stmt.executeQuery(sql);
		set.next();
		int IDpanda = set.getInt("id");
		return IDpanda;
	}

	public List<List<String>> selectFrom() {

		List<List<String>> result = new LinkedList<>();

		
		try {
			Statement stmt;
			stmt = conn.createStatement();

			String sql = "SELECT DISTINCT * FROM panda;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ResultSetMetaData md = rs.getMetaData();
				int colums = md.getColumnCount();
				List<String> row = new LinkedList<String>();

				for (int i = 1; i <= colums; i++) {
					String colName = md.getColumnName(i);
					row.add(rs.getString(colName)+"   ");
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

	public void printFriends(PandaDB panda) {
		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT p.name as Panda,f.name as Friend FROM panda as p JOIN panda as f ON p.id IN( "
					+ "SELECT panda_id From panda_friend WHERE panda_friend.friend_id=f.id" + ")" + "WHERE p.name='"
					+ panda.name + "';";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String pandaName = rs.getString("Panda");
				String friend = rs.getString("Friend");

				// Display values
				System.out.print("Name Of Panda: " + pandaName);
				System.out.print(", Friend: " + friend);
				System.out.println();

			}
		
		} catch (Exception se) {
			se.printStackTrace();
		}
	}

}

package week10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class Cinema {
	static final String DB_URL = "jdbc:mysql://localhost/cinema";
	static final String USER = "root";
	static final String PASS = "";

	private static Connection conn = null;
	private static Statement stmt = null;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		HashMap<String, Runnable> map = new HashMap<String, Runnable>();

		map.put("show movies", new Runnable() {
			@Override
			public void makeSth() {

				try {
					stmt = conn.createStatement();
					String sql;
					sql = "SELECT * FROM movies ORDER BY rating desc;";
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						int id = rs.getInt("id");
						String movie = rs.getString("name");
						float rating = rs.getFloat("rating");
						// Display values
						System.out.println("[" + id + "] - " + movie + " (" + rating + ")");

					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		map.put("show movie projections", new Runnable() {
			public void makeSth() {
				int movieId = sc.nextInt();
				try {
					stmt = conn.createStatement();
					ResultSet set;
					String sql;
					sql = "SELECT movie_id FROM projections WHERE movie_id=" + movieId + ";";
					set = stmt.executeQuery(sql);
					if (!set.next()) {
						System.out.println("No data.");
					} else {
						sql = "SELECT p.id,m.name,m.rating,p.type,p.date,p.time FROM movies m "
								+ "JOIN projections p ON m.id=p.movie_id WHERE p.movie_id=" + movieId + ";";

						set = stmt.executeQuery(sql);

						// STEP 5: Extract data from result set
						while (set.next()) {
							// Retrieve by column name
							int id = set.getInt("id");
							String name = set.getString("name");
							String type = set.getString("type");
							String date = set.getString("date");
							String time = set.getString("time");

							// Display values
							System.out.println("Projections for movie '" + name + "' :");
							System.out.println("[" + id + "] - " + date + " " + time + " " + type);
							System.out.println();

						}

					}
				} catch (SQLException ex) {

					ex.printStackTrace();
				}

			}
		});
		map.put("make reservation", new Runnable() {
			@Override
			public void makeSth() {
				String name = "";
				int numOfTicket;
				int projectionId;
				int[] rowSeat;
				int[] colSeat;
				int[][] hall;
				do {
					System.out.println("Step 1 (USER):Choose name>");
					name = sc.nextLine();
					System.out.println("Step 1 (USER):Choose number of tickets>");
					numOfTicket = sc.nextInt();
					map.get("show movies").makeSth();
					System.out.println("Step 2(MOVIE): Choose a movie>");
					map.get("show movie projections").makeSth();
					System.out.println("Step 3 (Projection): Choose a projection>");
					projectionId = sc.nextInt();

					hall = seatsInHall(projectionId);
					System.out.println("Available seats (marked with a 1):");
					availableSeats(hall);

					sc.nextLine();
					rowSeat = new int[numOfTicket];
					colSeat = new int[numOfTicket];
					selectingSeats(numOfTicket, rowSeat, colSeat, hall);
					System.out.println("This is your reservation :");
					System.out.println("Movie: " + name);
					System.out.print("Seats: ");
					for (int j = 0; j < numOfTicket; j++) {
						System.out.print("(" + rowSeat[j] + "," + colSeat[j] + ") ");
					}

					System.out.println("\nStep 5 (Confirm - type 'finalize') > ");
					if (sc.nextLine().equals("finalize")) {
						makeReservation(name, numOfTicket, projectionId, rowSeat, colSeat);
						System.out.println("Thanks.");
						break;
					}

				} while (true);

			}

		});

		// map.get("show movies").makeSth();
		// map.get("show movie projections").makeSth();
		map.get("make reservation").makeSth();
		sc.close();
	}

	private static int[][] seatsInHall(int projectionId) {
		int[][] hall;
		hall = new int[10][10];
		try {
			stmt = conn.createStatement();
			ResultSet set;
			String sql = "SELECT row,col FROM reservations WHERE projection_id=" + projectionId + ";";
			set = stmt.executeQuery(sql);
			while (set.next()) {
				int row = set.getInt("row");
				int col = set.getInt("col");
				hall[row - 1][col - 1] = 1;

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return hall;
	}

	private static void availableSeats(int[][] hall) {
		System.out.println("   1 2 3 4 5 6 7 8 9 10");
		for (int i = 0; i < 10; i++) {
			System.out.print((i + 1) + "  ");
			for (int j = 0; j < 10; j++) {
				System.out.print(hall[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void selectingSeats(int numOfTicket, int[] rowSeat, int[] colSeat, int[][] hall) {

		boolean isOrdered;
		int i = 0;
		do {

			isOrdered = true;
			System.out.println("Step 4 (Seats): Choose seat " + i + ">");
			String input = sc.nextLine();
			String[] seat = input.split(" ");
			int row = Integer.parseInt(seat[0]);
			int col = Integer.parseInt(seat[1]);
			if (hall[row - 1][col - 1] == 1) {
				System.out.println("This seat is already taken!");

			} else {
				hall[row - 1][col - 1] = 1;
				rowSeat[i] = row;
				colSeat[i] = col;
				i++;
				if (i == numOfTicket) {
					isOrdered = false;
				}
			}
		} while (isOrdered);

	}

	private static void makeReservation(String name, int numOfTicket, int projectionId, int[] rowSeat, int[] colSeat) {
		for (int i = 0; i < numOfTicket; i++) {
			try {
				stmt = conn.createStatement();
				String sql = "INSERT INTO reservations (username,projection_id,row,col)" + "VALUES('"
						+ name + "'," + projectionId + ","+rowSeat[i]+","+colSeat[i]+");";
;							stmt.executeUpdate(sql);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}

	public interface Runnable {

		void makeSth();
	}
}

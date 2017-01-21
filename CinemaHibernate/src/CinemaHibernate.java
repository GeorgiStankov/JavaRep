

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CinemaHibernate {
	private static Scanner sc = new Scanner(System.in);
	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			Configuration configuration = new Configuration().configure();
			factory = configuration.buildSessionFactory();
			System.out.println("Session Created");
		} catch (HibernateException exception) {
			System.out.println("Problem creating session factory");
			exception.printStackTrace();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		HashMap<String, Runnable> map = new HashMap<String, Runnable>();

		map.put("show movies", new Runnable() {
			@Override
			public void makeSth() {

				Session session = factory.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					List<Object> movies = session.createQuery("FROM Movie").list();
					for (Iterator<Object> iterator = movies.iterator(); iterator.hasNext();) {
						Movie movie = (Movie) iterator.next();
						System.out.print("  Name: " + movie.getName());
						System.out.println("  Rating: " + movie.getRating());
					}
					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}

			}
		});
		map.put("show movie projections", new Runnable() {

			@Override
			public void makeSth() {
				int movieId = sc.nextInt();
				Session session = factory.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					List<Object> movies = session.createQuery("FROM Projection WHERE movie_id=" + movieId).list();
					for (Iterator<Object> iterator = movies.iterator(); iterator.hasNext();) {
						Projection projection = (Projection) iterator.next();
						System.out.print("[" + projection.getId() + "] - ");
						System.out.print(projection.getDate() + " ");
						System.out.println(projection.getTime() + " (" + projection.getType() + ")");
					}
					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
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
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Object> movies = session.createQuery("FROM Reservation WHERE projection_id=" + projectionId).list();
			for (Iterator<Object> iterator = movies.iterator(); iterator.hasNext();) {
				Reservation reservation = (Reservation) iterator.next();
				int row = reservation.getRow();
	 			int col = reservation.getCol();
				hall[row - 1][col - 1] = 1;
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
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
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			for (int i = 0; i < numOfTicket; i++) {

				Integer reservationID = null;

				tx = session.beginTransaction();
				Reservation reservation = new Reservation(name, projectionId, rowSeat[i], colSeat[i]);
				reservationID = (Integer) session.save(reservation);
				tx.commit();

			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public interface Runnable {

		void makeSth();
	}
}
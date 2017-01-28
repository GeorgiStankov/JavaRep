package week11_CinemaHibernate;

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
		}catch(HibernateException exception){
			     System.out.println("Problem creating session factory");
			     exception.printStackTrace();
			}
		 catch (Throwable ex) {
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
					List movies = session.createQuery("FROM Movie").list();
					for (Iterator iterator = movies.iterator(); iterator.hasNext();) {
						System.out.println(iterator.next());
						Movie movie = (Movie) iterator.next();
						System.out.print("  Last Name: " + movie.getName());
						System.out.println("  Salary: " + movie.getRating());
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
			public void makeSth(){}
		});
		map.put("make reservation", new Runnable() {
			@Override
			public void makeSth() {	}

		});

		map.get("show movies").makeSth();
		// map.get("show movie projections").makeSth();
		//map.get("make reservation").makeSth();
		sc.close();
	}


	public interface Runnable {

		void makeSth();
	}
}

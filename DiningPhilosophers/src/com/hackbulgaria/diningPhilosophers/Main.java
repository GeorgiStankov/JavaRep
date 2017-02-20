package com.hackbulgaria.diningPhilosophers;

public class Main {
	protected static volatile Table table=new Table();
	public static void main(String[] agrs) {
	
		Thread t1=new Thread(new Philosopher(1));
		Thread t2=new Thread(new Philosopher(2));
		Thread t3=new Thread(new Philosopher(3));
		Thread t4=new Thread(new Philosopher(4));
		Thread t5=new Thread(new Philosopher(5));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}
}

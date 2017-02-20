package com.hackbulgaria.diningPhilosophers;


public class Philosopher implements Runnable {
	protected static final int PHILOSOPHER_BECOMES_HUNGRY = 1000;
	protected static final int PHILOSOPHER_EATING_TIME = 800;
	protected int id;
	protected Fork leftFork;
	protected Fork rightFork;

	public Philosopher(int id) {
		this.id = id;
	}

	@Override
	public void run() {

		System.out.println("Philosopher " + this.id + " sat on the table.");
		while (true) {
			eat();
			thinking();
		}
	}

	
	synchronized private void eat() {
		pickUpLeftFork();
		pickUpRightFork();
		if (areForksAvailable()) {
			System.out.println("both forks " + leftFork.getId() + " & " + rightFork.getId()
					+ " are available for use for Philosopher " + id);
			eatFor(PHILOSOPHER_EATING_TIME);
		}
		putDownBothForks();
	}
	private void pickUpLeftFork() {
		if (null == leftFork) {
			leftFork = Main.table.getLeftFork(this.id);
		}
	}

	private void pickUpRightFork() {
		if (null == rightFork) {
			rightFork = Main.table.getRightFork(id);
		}
	}

	private boolean areForksAvailable() {
		return leftFork != null && rightFork != null;

	}

	private void putDownBothForks() {
		if (null != rightFork) {
			rightFork.putOnTable();
		}
		if (null != leftFork) {
			leftFork.putOnTable();
		}
		leftFork = null;
		rightFork = null;
	}


	private void eatFor(int time) {
		try {
			System.out.println(id + " has started eating");
			Thread.currentThread();
			Thread.sleep(time);
			System.out.println(id + " has finished eating");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void thinking() {
		try {
			System.out.println("Philosopher " + this.id + " is thinking.");
			Thread.currentThread();
			Thread.sleep(PHILOSOPHER_BECOMES_HUNGRY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

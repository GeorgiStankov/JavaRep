package com.hackbulgaria.diningPhilosophers;

public class Fork {
	protected int id;
	protected boolean isActive;

	public Fork(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public synchronized void useFork(){
		isActive=true;
	}
	public synchronized void putOnTable() {
		isActive=false;
	}

	public synchronized boolean isActive(boolean isActive) {
		return isActive;
	}

}

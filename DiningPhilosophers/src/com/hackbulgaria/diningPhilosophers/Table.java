package com.hackbulgaria.diningPhilosophers;

import java.util.concurrent.ConcurrentHashMap;

public class Table {
	protected ConcurrentHashMap<Integer, Fork> forks = new ConcurrentHashMap<Integer, Fork>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(1, new Fork(1));
			put(2, new Fork(2));
			put(3, new Fork(3));
			put(4, new Fork(4));
			put(5, new Fork(5));
		}
	};

	private boolean isForkAvailable(int forkId) {
		return !forks.get(forkId).isActive;
	}

	synchronized private Fork getFork(int forkId) {
		if (isForkAvailable(forkId)) {
			forks.get(forkId).useFork();
			return forks.get(forkId);
		}
		return null;
	}

	protected Fork getLeftFork(int philosopherId) {
		return getFork((philosopherId + 1)%5);
	}

	protected Fork getRightFork(int philosopherId) {
		if (philosopherId == 0) {
			return getFork(forks.size());
		} else {
			return getFork(philosopherId);
		}
	}

}

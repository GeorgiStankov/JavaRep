package week07;


import java.util.LinkedList;
import java.util.List;

public class PandaSocialNetwork {

	Graph<Panda> graph = new Graph<Panda>();

	public void addPanda(Panda panda) {
		graph.addVertex(panda);
	}

	public boolean hasPanda(Panda panda) {
		return graph.containsVertex(panda);
	}

	public void makeFriends(Panda panda1, Panda panda2) {
		addPanda(panda1);
		addPanda(panda2);
		graph.addEdge(panda1, panda2);
		graph.addEdge(panda2, panda1);
	}

	public List<Panda> friendsOfPanda(Panda panda) {
		List<Panda> list = new LinkedList<Panda>();
		if (!hasPanda(panda)) {
			throw new NullPointerException("there is not in the network");
		}
		graph.getNode(panda).edges().forEach(edge -> {
			Panda friend = edge.toNode().vertex();
			list.add(friend);
		});
		return list;
	}

	public boolean areFriends(Panda p1, Panda p2) {
		return graph.containsEdge(p1, p2);
	}

	public int connectionLevel(Panda p1, Panda p2) {
		int level;
		try {
			level = (graph.shortestPath(p1, p2)).size();
		} catch (NullPointerException ex) {
			return -1;
		}

		return level;
	}

	public boolean areConnected(Panda p1, Panda p2) {
		boolean areCon = false;
		try {
			int level = (graph.shortestPath(p1, p2)).size();
			if (level > 0) {
				areCon = true;
			}
		} catch (NullPointerException ex) {

			return areCon;
		}

		return areCon;
	}

	public int howManyGender(int level, Panda panda, String gender) {
		int count = 0;
		List<Panda> list = friendsOfPanda(panda);
		if (level == 1) {
			for (Panda item : list) {
				if (item.getGender().equals(panda.getGender())) {
					count++;
				}
			}
		} else {
			/*
			 * LEVEL 2 dont work as expected TODO:friends of panda and all of
			 * their friends too.
			 */
			for (Panda item : list) {
				List<Panda> friendsOfPanda = friendsOfPanda(item);
				for (Panda friends : friendsOfPanda) {

					if (friends.getGender().equals(panda.getGender())) {
						count++;
					}
				}
			}
		}

		return count;
	}
	
	

}

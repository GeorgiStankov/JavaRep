package bg.hackBulgaria.githubsocialnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GithubCrawler {
	private final String USER_AGENT = "Mozilla/5.0";
	private String USER = "";
	Graph<String> graph;

	public void createGraph(String name) throws Exception {
		USER=name;
		graph = new Graph<String>();
		Queue<String> followers = getNeighboursFromApi(name);
		while (!followers.isEmpty()) {
			System.out.println(name);
			graph.addVertex(name);
			for (String follower : getNeighboursFromApi(name)) {
				graph.addVertex(follower);
				graph.addEdge(name, follower);
			}
			name = followers.poll();

		}
	}

	public LinkedList<String> getNeighboursFromApi(String name) throws ClientProtocolException, IOException {
		Pattern pat = Pattern.compile("\"login\":\"([a-zA-Z0-9_-]+)\"");
		String url = "https://api.github.com/users/" + name + "/following";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header2
		request.addHeader("User-Agent", USER_AGENT);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		Matcher m = pat.matcher(result);
		LinkedList<String> users = new LinkedList<String>();
		while (m.find()) {
			users.add(m.group(1));
		}
		System.out.println(users.toString());
		return users;
	}

	public boolean doUFollow(String user2) {
		return graph.containsEdge(USER, user2);
	}
	public boolean doUFollowIndirectly(String user2){
		boolean areCon = false;
		try {
			int level = (graph.shortestPath(USER,user2)).size();
			if (level > 0) {
				areCon = true;
			}
		} catch (NullPointerException ex) {

			return areCon;
		}

		return areCon;
	}
	public boolean doesHeSheFollow(String user2){
		if(whoFollowsUBack(user2).contains(USER)){
			return true;	
		}
		return false;
		
	}
	public List<String> whoFollowsUBack(String user) {
		List<String> list = new LinkedList<String>();
		if (!graph.containsVertex(user)) {
			throw new NullPointerException("there is not in the network");
		}
		graph.getNode(user).edges().forEach(edge -> {
			String friend = edge.toNode().vertex();
			list.add(friend);
		});
		return list;
	}
}

package bg.hackBulgaria.githubsocialnetwork;

public class Main {


	public static void main(String[] args) throws Exception {
		String user="RadoRado";
		GithubCrawler git=new GithubCrawler();
		git.createGraph(user);
		CLI Clinterface=new CLI(git);
		Clinterface.start();

	}

	
}
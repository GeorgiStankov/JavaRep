package bg.hackBulgaria.githubsocialnetwork;

import java.util.Scanner;

public class CLI {
	private GithubCrawler crawler;

	public CLI(GithubCrawler gt) {
		this.crawler = gt;
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to GithubCrawler");

		while (true) {
			System.out.println("Enter command");
			String input = sc.nextLine();
			if (input.equals("exit"))
				break;
			commandDispatcher(input);
		}
	}

	public void commandDispatcher(String command) {
		String[] parts = command.split(" ");
		switch (parts[0]) {
		case "do_you_follow":
			System.out.println(crawler.doUFollow(parts[1]));
			break;
		case"do_you_follow_indirectly":
			System.out.println(crawler.doUFollowIndirectly(parts[1]));
			break;
		case"does_he_she_follows":
			System.out.println(crawler.doesHeSheFollow(parts[1]));
			break;
		case"who_follows_you_back":
			System.out.println(crawler.whoFollowsUBack(parts[1]));
		}
	}

}

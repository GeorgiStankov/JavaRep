import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<String, LinkedHashSet<String>> map = new TreeMap<String, LinkedHashSet<String>>();
		LinkedHashMap<String, Integer> innerMap = new LinkedHashMap<String, Integer>();

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String[] part = sc.nextLine().split(" ");
			String user = part[0];
			String ip = part[1];
			int duration = Integer.parseInt(part[2]);
			if (!map.containsKey(user)) {
				LinkedHashSet<String> set = new LinkedHashSet<>();
				map.put(user, set);
				map.get(user).add(ip);
				innerMap.put(user, duration);

			}
			else{
				map.get(user).add(ip);
				innerMap.put(user,innerMap.get(user)+duration);
			}

		}

	}

}

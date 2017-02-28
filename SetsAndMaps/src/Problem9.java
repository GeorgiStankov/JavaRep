import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem9 {

	public static void main(String[] args) {

		Pattern pat = Pattern.compile("IP=(\\S+) message=(\\S+) user=(\\S+)");
		TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<String, LinkedHashMap<String, Integer>>();
		LinkedHashMap<String, Integer> innerMap = new LinkedHashMap<String, Integer>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.nextLine();
			if (str.equals("end")) {
				break;
			}
			String name = null;
			String address = null;
			Matcher matcher = pat.matcher(str);
			if (matcher.find()) {
				name = matcher.group(3);
				address = matcher.group(1);
			}
			if (!map.containsKey(name)) {
				innerMap = new LinkedHashMap<String, Integer>();
				innerMap.put(address, 1);
				map.put(name, innerMap);

			} else {
				if (!innerMap.containsKey(address)) {
					innerMap.put(address, 1);
					map.put(name, innerMap);
				} else {
					innerMap.put(address, innerMap.get(address) + 1);
					map.put(name, innerMap);
				}
			}

		}
		for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : map.entrySet()) {

			System.out.println(entry.getKey()+": ");
			LinkedHashMap<String, Integer> map1 = map.get(entry.getKey());
			for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
			
			System.out.printf(entry1.getKey()+" => " + entry1.getValue()+", " );
			
			}
			System.out.println();

		}

		sc.close();
	}

}

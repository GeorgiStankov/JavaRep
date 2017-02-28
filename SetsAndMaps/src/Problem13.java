import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Problem13 {

	public static void main(String[] args) {
		Pattern pat = Pattern.compile("([\\w\\s]+)\\s@([a-zA-z\\s]+)\\s(\\d+)\\s(\\d+)");
		LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();
		HashMap<String, Integer> innerMap = null;
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.nextLine();
			if (str.equals("End")) {
				break;
			}

			Matcher matcher = pat.matcher(str);
			if (matcher.find()) {

				String singer = matcher.group(1);
				String place = matcher.group(2);
				int numTickets = Integer.parseInt(matcher.group(4));
				int price = Integer.parseInt(matcher.group(3));
				if (!map.containsKey(place)) {
					map.put(place, new LinkedHashMap<String, Integer>());

				}
				if (!map.get(place).containsKey(singer)) {
					map.get(place).put(singer, 0);

				}
				int count = map.get(place).get(singer) + (numTickets * price);
				map.get(place).put(singer, count);

				// Map<String,HashMap<String,Integer>> result = new LinkedHashMap<>();
				// Stream<Map.Entry<String ,HashMap<String,Integer>>> st =
				// map.entrySet().stream();
				//
				// st.sorted((k, k1) -> (k1.getValue().compareTo(k.getValue())))
				// .forEachOrdered( e -> result.put(e.getKey(), e.getValue()) );

				// map.entrySet().stream().forEach(a -> {
				// String city = a.getKey();
				// System.out.println(city);
				//
				// HashMap<String,Integer> mapa = map.get(city);
				//
				// mapa.entrySet().stream().sorted((k, k1) ->
				// (k1.getValue().compareTo(k.getValue()))).forEach(asd -> {
				//
				// System.out.printf("# %s-> %d\n", asd.getKey(),
				// mapa.get(asd.getKey()));
				//
				// });
				//
				//
				// });

			}

		}

		map.entrySet().stream()
        .forEach(map1 -> {
			String city = map1.getKey();
			System.out.println(city);

			 Stream<Map.Entry<String,Integer>> st = map.get(city).entrySet().stream();
			 st.sorted((k, k1) -> (k1.getValue().compareTo(k.getValue())))
			.forEachOrdered(e -> {
            System.out.printf("#  %s -> %s\n", e.getKey(), e.getValue()); });
		});
	}
}
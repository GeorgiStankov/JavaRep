package bg.Musala;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class hdfhg {
	String PersonName;
	int PersonNumber;

	private static TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();
	private static TreeMap<String, Integer> innerMap = new TreeMap<>();
	private static Pattern pat = Pattern.compile("(^(\\+359)|^(0)|^(00359))((87)|(88)|(89))[^0-1]{1}[0-9]{6}$");

	hdfhg(String name, int number) {
		this.PersonName = name;
		this.PersonNumber = number;
	}

	// Reading data from text file
	public static void textFilePhoneBook(String str) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(str));
			TreeMap<String, String> fileMap = new TreeMap<>();
			int size, people;
			String data = null;
			String[] pair = null;
			StringBuffer stringBuffer = new StringBuffer("");

			while ((data = br.readLine()) != null) {
				stringBuffer.append(data + " ");

				pair = stringBuffer.toString().split(" ");
				size = pair.length;
				people = size / 2;
				for (int i = 0; i < people; i++) {
					String name = pair[i * 2];
					String number = getFirstLetters(pair[(i * 2) + 1]);

					if (number != null)
						fileMap.put(name, number);

				}
				for (Map.Entry<String, String> entry : fileMap.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					System.out.println(key + ": " + value);
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Adding name and phone number to Treemap
	public static void Adding(String name, String number) {
		String numberToBeWriten = getFirstLetters(number);
		if (numberToBeWriten != null) {
			if (!map.containsKey(name)) {
				map.put(name, new TreeMap<String, Integer>());
			}
			if (!map.get(name).containsKey(numberToBeWriten)) {
				map.get(name).put(numberToBeWriten, 0);

			}

		}

	}

	public static String DeletingByName(String name) {
		if (map.containsKey(name)) {
			map.remove(name);
			return "Register removed";
		} else
			return "NO such name";
	}

	public static String AccessByName(String name) {
		if (map.containsKey(name)) {
			return map.get(name).toString();
		} else
			return "No such name";
	}

	public static void Print() {

		map.entrySet().stream().sorted((k, k1) -> (k.getKey().compareTo(k1.getKey()))).forEach(map1 -> {
			String name = map1.getKey();

			Stream<Map.Entry<String, Integer>> st = map.get(name).entrySet().stream();
			st.forEach(map2 -> {
				System.out.print(name);
				System.out.printf(" %s\n", map2.getKey());
			});

		});
	}

	// Turning the phone number in Bg Standard if neccessary
	public static String getFirstLetters(String number) {
		Matcher matcher = pat.matcher(number);
		if (matcher.find()) {
			if (number.substring(0, 5).equals("00359")) {
				number = number.replace("00359", "+359");
			} else if (number.charAt(0) == '0') {
				number = number.replace("0", "+359");
			}

			return number;

		}
		return null;

	}

	// Counting outgoing calls
	public static void callNumber(String name, String number) {
		String numberToBeWriten = getFirstLetters(number);
		int count = map.get(name).get(numberToBeWriten);
		if (map.containsKey(name) | map.containsValue(map.get(name))) {
			map.get(name).put(numberToBeWriten, count + 1);
		} else
			System.out.println("No such name or number");

	}
	public static void sorting(){
		innerMap.entrySet().stream().sorted((k, k1) -> (k1.getValue().compareTo(k.getValue())));
				
	}

	public static void PrintingOutgoingCall() {

		map.entrySet().stream().forEach(map1 -> {
			String name = map1.getKey();

			Stream<Map.Entry<String, Integer>> st = map.get(name).entrySet().stream();
			st.sorted((k, k1) -> (k1.getValue().compareTo(k.getValue()))).forEachOrdered(e -> {
				System.out.printf(name);
				System.out.printf("  %s -> %s\n", e.getKey(), e.getValue());

			});
		});
	}
}
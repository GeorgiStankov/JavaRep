import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem6 {
	public static void main(String[] args) {
		LinkedHashMap<String, Long> map = new LinkedHashMap<String, Long>();
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			String input = sc.nextLine();
			if (input.equals("Stop")) {
				break;
			}
			Long quantity = sc.nextLong();
			if (map.containsKey(input)) {
				map.put(input, map.get(input) + quantity);
			} else
				map.put(input, quantity);
		}
		{
			for (Map.Entry<String, Long> entry : map.entrySet()) {

				System.out.println(entry.getKey() + " -> " + entry.getValue());
			}

		}
	}
}
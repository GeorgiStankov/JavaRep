import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem7 {
	public static void main(String[] args) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		Scanner sc = new Scanner(System.in);

		 for (int i = 1; i <= 10; i++) {

			String name = sc.nextLine();
			if (name.equals("stop")) {
				break;
			}
			String email = sc.nextLine();
			
			String[] epair = email.split("\\.");
			if (!(epair[1].toLowerCase()).equals("us") && !epair[1].toLowerCase().equals("uk")) {
				map.put(name, email);
			}
		}

		for (Map.Entry<String, String> entry : map.entrySet()) {

			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

	}

}
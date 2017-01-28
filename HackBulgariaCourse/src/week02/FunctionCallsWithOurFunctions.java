package week02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FunctionCallsWithOurFunctions {
	public static HashMap<String, String> map = new HashMap<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] ln = sc.nextLine().split(" ", 2);
			String key = ln[0];
			String[] pair = ln[1].split("=", 2);
			String value = pair[1];
			map.put(key, value);
		}
		String[] func = sc.nextLine().trim().split("\\.");
		int x = sc.nextInt();
		int sum = 0;
		boolean isTrue = true;
		for (int i = func.length - 1; i >= 0; i--) {
			if (isTrue) {
				sum = evaluate(func[i].trim(), x);
				isTrue = false;
			} else {
				sum = evaluate(func[i].trim(), sum);
			}
		}
		System.out.println(sum);

		sc.close();
	}

	public static int evaluate(String function, int s) {

		int x = 0;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(function)) {
				x = sum(entry.getValue(), s);
			}
		}
		return x;

	}

	public static int sum(String str, int n) {
		String[] pair = str.trim().split(" ");
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < pair.length; i++) {
			if (pair[i].endsWith(")")) {
				if (pair[i].endsWith("(x)")) {
					pair[i] = pair[i].substring(0, pair[i].length() - 3);
					pair[i] = Integer.toString(evaluate(pair[i], n));
				} else {
					temp = Character.getNumericValue(pair[i].charAt(pair[i].length() - 2));
					pair[i] = pair[i].substring(0, pair[i].length() - 3);
					pair[i] = Integer.toString(evaluate(pair[i], temp));

				}
			}

		}
		for (int i = 0; i < pair.length; i++) {

			if (sum == 0 && i == 0) {
				if (pair[i].trim().equals("x")) {
					sum = n;
				} else
					sum = Integer.parseInt(pair[i].trim());
			}
			if (pair[i].equals("+")) {
				sum += Integer.parseInt(pair[i + 1].trim());
			} else if (pair[i].equals("-")) {
				{
					sum -= Integer.parseInt(pair[i + 1].trim());

				}
			}
		}
		return sum;
	}
}

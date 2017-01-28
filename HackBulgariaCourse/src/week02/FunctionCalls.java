package week02;

import java.util.Scanner;

public class FunctionCalls {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		int x = scanner.nextInt();
		String[] func = input.replaceAll("\\s+", "").split("\\.");
		int sum = 0;
		for (int i = func.length - 1; i >= 0; i--) {

			if (sum != 0) {
				if (func[i].trim().equals("f1")) {
					sum = func1(sum);
				} else if (func[i].equals("f2")) {
					sum = func2(sum);
				} else if (func[i].equals("f3")) {
					sum = func3(sum);
				} else if (func[i].equals("f4")) {
					sum = func4(sum);
				}
			} else {
				if (func[i].equals("f1")) {
					sum = func1(x);
				} else if (func[i].equals("f2")) {
					sum = func2(x);
				} else if (func[i].equals("f3")) {
					sum = func3(x);
				} else if (func[i].equals("f4")) {
					sum = func4(x);
				}
			}
		}

		System.out.println(sum);

		scanner.close();

	}

	public static int func1(int x) {

		return func2(x) + func3(x);

	}

	public static int func2(int x) {

		return 2 * x;
	}

	public static int func3(int x) {

		return 1 + x;
	}

	public static int func4(int x) {
		return 2 * func1(x);
	}

}

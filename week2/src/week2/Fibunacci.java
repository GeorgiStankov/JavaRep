package week2;

import java.util.Scanner;

public class Fibunacci {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(FibNum(n + 1));

	}

	public static int FibNum(int a) {
		int c = 0;
		int first = 0;
		int second = 1;
		// System.out.println(next);
		for (int i = 0; i < a; i++) {

			c = first + second;
			first = second;
			second = c;

		}
		return c;

	}

	public static int fib(int n) {

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);

	}

}

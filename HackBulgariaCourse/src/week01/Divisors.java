package week01;

import java.util.Scanner;

public class Divisors {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number :  ");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();

		System.out.println(sumOfDivisors(num1, num2));

		scanner.close();

	}

	public static int sumOfDivisors(int a, int b) {
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum = sum + findDivisors(i);

		}

		return sum;
	}

	public static int findDivisors(int num) {
		int sum = 1 + num;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}

		return sum;
	}
}

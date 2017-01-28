package week01;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		String str = Integer.toString(number);
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum = sum + fac(Character.getNumericValue(str.charAt(i)));
		}
		System.out.println(sum);
		sc.close();
	}

	public static int fac(int num) {
		int fact = 1;

		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}

		return fact;
	}

}

package week01;

import java.util.Scanner;

public class isSumPalidrom {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(SumPalidrom(num));
		sc.close();
	}

	public static boolean SumPalidrom(int input) {
		String str = Integer.toString(input);
		int len = str.length();
		StringBuilder dest = new StringBuilder(len);

		for (int i = (len - 1); i >= 0; i--) {
			dest.append(str.charAt(i));
		}
		int sum = input + Integer.parseInt(dest.toString());
		if (isPalindrome(sum)) {
			return true;
		} else
			return false;

	}

	public static boolean isPalindrome(int number) {
		int palindrome = number; // copied number into variable
		int reverse = 0;

		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
		}

		if (number == reverse) {
			System.out.println(number);
			return true;
		}
		return false;
	}

}

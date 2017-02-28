import java.math.BigInteger;
import java.util.Scanner;

public class StringsAndNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter encoded string.");
		String encodedStr = scan.nextLine().trim();
		char nums[] = { '9', '8', '7', '6', '5', '4', '3', '2', '1', '0' };
		for (int i = 0; i < 10; i++) {

			encodedStr = encodedStr.replace(getMax(encodedStr), nums[i]);
		}
		System.out.println(sum(encodedStr));
		scan.close();
	}

	public static char getMax(String word) {
		if (word == null || word.isEmpty()) {
			throw new IllegalArgumentException("input word must have non-empty value.");
		}
		char maxchar = ' ';
		int maxcnt = 0;
		// if you are confident that your input will be only ascii, then this
		// array can be size 128.
		int[] charcnt = new int[Character.MAX_VALUE + 1];
		for (int i = word.length() - 1; i >= 0; i--) {
			if (!Character.isDigit(word.charAt(i))) {
				char ch = word.charAt(i);
				// increment this character's cnt and compare it to our max.
				if (++charcnt[ch] >= maxcnt) {
					maxcnt = charcnt[ch];
					maxchar = ch;
				}
			}
		}

		return maxchar;
	}

	public static BigInteger sum(String word) {
		BigInteger grandTotal = BigInteger.valueOf(0);
		StringBuilder strb = new StringBuilder(word);
		for (int c = 0; c < strb.length(); c++) {
			if (!Character.isDigit(strb.charAt(c))) {
				strb.setCharAt(c, ' ');
			}
		}
		String[] numbers = strb.toString().trim().split("\\s+");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != null && numbers[i].length() > 0) {
				grandTotal = grandTotal.add(new BigInteger(numbers[i]));

			}
		}
		return grandTotal;

	}
}
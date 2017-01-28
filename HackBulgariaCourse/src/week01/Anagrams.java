package week01;

import java.util.HashSet;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String a = scanner.nextLine();
		String b = scanner.nextLine();

		if (areAnagrams(a, b)) {
			System.out.println("ANAGRAMS");
		} else {
			System.out.println("NOT ANAGRAMS");
		}
		scanner.close();
	}

	public static boolean areAnagrams(String a, String b) {
		char[] ch = a.toLowerCase().replaceAll("[-+.^:,]", "").toCharArray();
		char[] ch1 = b.toLowerCase().replaceAll("[-+.^:,]", "").toCharArray();
		HashSet<Character> arr = new HashSet<Character>();
		boolean isAnagram = false;
		if (ch.length != ch1.length) {
			return false;
		}
		for (int i = 0; i < ch.length - 1; i++) {
			arr.add(ch[i]);
		}
		for (int i = 0; i < ch1.length - 1; i++) {
			if (arr.contains(ch1[i])) {
				isAnagram = true;
				arr.remove(ch1[i]);
			} else {
				isAnagram = false;

			}
		}
		return isAnagram;
	}

}

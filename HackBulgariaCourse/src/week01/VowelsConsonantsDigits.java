package week01;

import java.util.ArrayList;
import java.util.Scanner;

public class VowelsConsonantsDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("Vowels:" + countVowel(input) + " Consonants:" + countConsonant(input) + " Digits:"
				+ countDigit(input));

		sc.close();

	}

	public static int countConsonant(String str) {
		String nstr = str.toLowerCase();
		char[] ch = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
				'z' };

		int occ = 0;
		for (int i = 0; i < nstr.length(); i++) {
			for (int s = 0; s < ch.length; s++) {
				if (nstr.charAt(i) == ch[s]) {
					occ++;
				}
			}

		}

		return occ;
	}

	public static int countVowel(String str) {
		String nstr = str.toLowerCase();
		ArrayList<Character> al = new ArrayList<Character>();
		al.add('a');
		al.add('e');
		al.add('i');
		al.add('o');
		al.add('u');
		al.add('y');
		int i = 0;
		for (int s = 0; s < nstr.length(); s++) {
			if (al.contains(nstr.charAt(s))) {
				i++;
			}
		}
		return i;
	}

	public static int countDigit(String str) {
		String nstr = str.toLowerCase();
		int occ = 0;
		for (int i = 0; i < nstr.length(); i++) {
			if (Character.isDigit(nstr.charAt(i))) {
				occ++;
			}
		}
		return occ;
	}

}

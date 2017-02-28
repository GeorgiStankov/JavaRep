package week1;

import java.util.HashMap;

import javax.swing.GroupLayout.SequentialGroup;

import java.util.Arrays;

public class Sms {

	public static void main(String[] args) {
		int[] sequence = { 4, 6, 6, 6, 7, 7, 7, 7, 4, 4, 6, 6, 6, 2, 2, 2 };
		GSM(sequence);
	}

	public static String GSM(int[] seq) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		String s = null;

		int[] sequence = seq;

		hmap.put(2, "a");
		hmap.put(22, "b");
		hmap.put(222, "c");
		hmap.put(3, "d");
		hmap.put(33, "e");
		hmap.put(333, "f");
		hmap.put(4, "g");
		hmap.put(44, "h");
		hmap.put(444, "i");
		hmap.put(5, "j");
		hmap.put(55, "k");
		hmap.put(555, "l");
		hmap.put(6, "m");
		hmap.put(66, "n");
		hmap.put(666, "o");
		hmap.put(7, "p");
		hmap.put(77, "q");
		hmap.put(777, "r");
		hmap.put(7777, "s");

		for (int i = sequence.length - 4; i < sequence.length - 3; i++) {

			// System.out.println(sequence[i]);
			// System.out.println(i+" haha");
			for (int q = 0; q < sequence.length; q++) {
				// System.out.println(sequence[q]+ " q= "+q);

				if (sequence.length > q + 3 && sequence.length > q + 2 && sequence.length > q + 1) {
					if (sequence[q] == sequence[q + 1] && sequence[q] == sequence[q + 2]
							&& sequence[q] == sequence[q + 3]) {

						String a = String.valueOf(sequence[q]) + String.valueOf(sequence[q])
								+ String.valueOf(sequence[q] + String.valueOf(sequence[q]));
						int c = Integer.parseInt(a);

						System.out.println(hmap.get(c) + " 1st if");
						q = q + 3;

						continue;
					}
				}
				if (sequence.length > q + 2 && sequence.length > q + 1) {
					if (sequence[q] == sequence[q + 1] && sequence[q] == sequence[q + 2]) {

						String a = String.valueOf(sequence[q]) + String.valueOf(sequence[q])
								+ String.valueOf(sequence[q]);
						int c = Integer.parseInt(a);
						System.out.println(hmap.get(c) + " second if");
						q = q + 2;
						continue;

					}
				}
				if (sequence.length > q + 1) {
					if (sequence[q] == sequence[q + 1]) {
						String b = String.valueOf(sequence[q]) + String.valueOf(sequence[q]);
						int c = Integer.parseInt(b);
						System.out.println(hmap.get(c) + " third if");
						q = q + 1;
						continue;
					}
				}

				String c = String.valueOf(sequence[q]);
				int r = Integer.parseInt(c);
				System.out.println(hmap.get(r) + " 4th if");

			}

		}

		return s;
	}
}

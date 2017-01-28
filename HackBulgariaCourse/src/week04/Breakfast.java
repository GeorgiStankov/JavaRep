package week04;

import java.util.Scanner;

public class Breakfast {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int mekici = 0;
		int elRing = 0;
		for (int i = 0; i < n; i++) {
			String[] params = sc.nextLine().trim().split(" ");
			// String[] time=sc.nextLine().trim().split(" ");
			mekici = Integer.valueOf(params[0]);
			elRing = Integer.valueOf(params[1]);
		}
		sc.close();
	}

}

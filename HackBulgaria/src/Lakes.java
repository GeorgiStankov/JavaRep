import java.util.Scanner;

public class Lakes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] structure = sc.nextLine().toCharArray();
		int depth = 0;
		int amountOfWater = 0;
		boolean position = false;
		for (char command : structure) {

			if (command == 'd') {
				if (depth >= 0) {
					if (position) {
						amountOfWater += ((depth * 1000) + 500);
					} else if (amountOfWater != 0) {
						amountOfWater += ((depth * 1000) + 500);
					} else if (depth == 0) {
						amountOfWater += 500;
					}
				}

				depth++;
			} else if (command == 'h' && depth > 0) {
				amountOfWater += depth * 1000;
				position = true;
			} else if (command == 'u') {
				if (depth > 0) {
					if (position) {
						amountOfWater += ((depth * 1000) - 500);
					} else
						amountOfWater += ((1000 * depth) - 1000);
				}
				depth--;
			}

		}
		System.out.println(amountOfWater);
		sc.close();
	}

}

import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem6 {

	public static void main(String[] args) {

		ArrayDeque<Station> array = new ArrayDeque<Station>();
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String[] pair = sc.nextLine().split(" ");
			Long gas = Long.valueOf(pair[0]);
			int distance = Integer.valueOf(pair[1]);
			Station station = new Station();
			station.amoutOfPetrol = gas;
			station.distanceToNext = distance;
			array.addLast(station);

		}
		int gasInTank = 0;
		boolean foundFirst = false;
		int index = 0;

		while (true) {
			Station current = array.removeFirst();
			gasInTank += current.amoutOfPetrol;
			array.addLast(current);
			Station first = current;
			int indexAddUp = 1;

			while (gasInTank >= current.distanceToNext) {
				gasInTank -= current.distanceToNext;
				current = array.removeFirst();
				array.addLast(current);
				gasInTank += current.amoutOfPetrol;
				indexAddUp++;
				if (current == first) {
					foundFirst = true;
					break;
				}

			}
			if (foundFirst) {
				break;
			}
			index += indexAddUp;
			gasInTank = 0;
		}
		System.out.println(index);
		sc.close();
	}

}

class Station {
	Long amoutOfPetrol;
	int distanceToNext;
}

package week01;

import java.util.Scanner;
import java.util.Vector;

public class GasStation {

	public static Vector<Integer> getGasStations(int tripDistance, int tankSize, Vector<Integer> gasStations) {
		return new Vector<Integer>();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tripDistance = scanner.nextInt();
		int tankSize = scanner.nextInt();
		int tempTank = tankSize;

		int gasStationsCount = scanner.nextInt();
		Vector<Integer> gasStations = new Vector<Integer>();

		for (int i = 0; i < gasStationsCount; i++) {
			gasStations.add(scanner.nextInt());
		}
		gasStations.add(tripDistance);
		Vector<Integer> stations = new Vector<Integer>();
		for (int i = 0; i < gasStations.size() - 1; i++) {

			if ((gasStations.get(i + 1) - gasStations.get(i)) >= tempTank) {
				stations.add(gasStations.get(i));
				stations.add(gasStations.get(i + 1));
				tempTank = tankSize;
			} else
				tempTank = tempTank - (gasStations.get(i + 1) - gasStations.get(i));
		}

		for (int i = 0; i < stations.size(); i++) {
			System.out.println(stations.get(i));
		}

		scanner.close();

	}

}

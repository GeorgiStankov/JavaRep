package GameOfBottles;

import java.util.ArrayList;
import java.util.Scanner;

public class Plain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Coordinate crd = new Coordinate(x, y);
			coordinates.add(crd);

		}
		System.out.println();
		int distance = 9;
		int totalDist = 0;
		for (int i = 0; i < coordinates.size() - 1; i++) {
			for (int j = 1; j < coordinates.size(); j++) {
				int temp = smallestDist(coordinates.get(i), coordinates.get(j));
				if (temp < distance && temp != 0) {
					distance = temp;
				}

			}
			totalDist = totalDist + distance;
			distance = 9;
		}
		System.out.println(totalDist);
		sc.close();
	}

	public static int smallestDist(Coordinate one, Coordinate second) {
		int x1 = one.getX();
		int y1 = one.getY();
		int x2 = second.getX();
		int y2 = second.getY();
		int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

		return dist;
	}

}

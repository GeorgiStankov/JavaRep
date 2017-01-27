package bg.hackbulgaria.IO;

import bg.hackbulgaria.Coordinates.Coordinates;
import bg.hackbulgaria.Distribution.DroneDeliverySystem;

public class Main {

	public static void main(String[] args) {
		Coordinates cd = new Coordinates(42, 42);
		DroneDeliverySystem dds = new DroneDeliverySystem(cd);
		// String input = "delivery 4 2016-10-25 12:31 42,36 1 3 2 1";
		// System.out.println(dds.acceptDelivery(input));
		while (true) {

			dds.menu();
			System.out.println("******************************");

		}
	}
}

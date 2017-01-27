package bg.hackbulgaria.Distribution;

import java.util.Scanner;

import bg.hackbulgaria.Coordinates.Coordinates;
import bg.hackbulgaria.Exceptions.InputException;
import bg.hackbulgaria.IO.IO;
import bg.hackbulgaria.Warehouse.Product;
import bg.hackbulgaria.Warehouse.Warehouse;

public class DroneDeliverySystem {
	IO io;
	Scanner sc = new Scanner(System.in);

	public DroneDeliverySystem(Coordinates coords) {

		Warehouse wh = new Warehouse(coords);
		Product disk = new Product(1, "disk", 5.0);
		Product ball = new Product(2, "ball", 1);
		Product keyboard = new Product(3, "keyboard", 1);
		wh.addProduct(disk);
		wh.addProduct(disk);
		wh.addProduct(disk);
		wh.addProduct(ball);
		wh.addProduct(ball);
		wh.addProduct(keyboard);
		wh.addProduct(keyboard);
		wh.addProduct(keyboard);

		DistributionCenter dc = new DistributionCenter(wh);

		RequestManager rm = new RequestManager(dc);

		this.io = new IO(rm);
	}

	public void menu() {
		System.out.println("Welcome to HackBulgaria drone delivery system");
		System.out.println("Choose an operation:");
		System.out.println("1.Make a delivery");
		System.out.println("2.Make supply to certain warehouse");
		System.out.println("3.Show delivery history");
		System.out.println("4.Show supply history");
		int operation = sc.nextInt();
		switch (operation) {
		case 1:
		}

	}

	public void makeDelivery() throws InputException{
		System.out.println("Enter a delivery request in format delivery <id> <timestamp> "
				+ "<target coordinates> <product id 1> <quantity> <product id 2> <quantity> ...");
		String input = sc.nextLine();
		if (acceptDelivery(input)) {
			System.out.println("Delivery request accepted.");
		} else {
			System.out.println("Currently we are unavailable to deliver products due to specific reasons.");
		}

	}

	public void makeSupply() throws InputException {
		System.out.println("Enter a supply request in format "
				+ "supply <id> <warehouse id> <timestamp YYYY-MM-DD HH:MM> <product id 1> <quantity> <product id 2> <quantity>");
		String input=sc.nextLine();
		acceptSupply(input);
	}

	public boolean acceptDelivery(String delivery) {
		return io.acceptDelivery(delivery);
	}
	public void acceptSupply(String supply) {
		io.acceptSupply(supply);
	}
}

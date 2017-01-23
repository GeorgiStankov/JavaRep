package bg.hackbulgaria.Distribution;

import bg.hackbulgaria.Coordinates.Coordinates;
import bg.hackbulgaria.IO.IO;
import bg.hackbulgaria.Warehouse.Product;
import bg.hackbulgaria.Warehouse.Warehouse;

public class DroneDeliverySystem {
	IO io;

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

	public boolean acceptDelivery(String delivery) {
		return io.acceptDelivery(delivery);
	}
}

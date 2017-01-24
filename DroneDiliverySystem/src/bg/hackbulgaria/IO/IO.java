package bg.hackbulgaria.IO;

import bg.hackbulgaria.Calculations.Parse;
import bg.hackbulgaria.Distribution.RequestManager;
import bg.hackbulgaria.Warehouse.Order;

public class IO {
	RequestManager rm;

	public IO(RequestManager rm) {
		this.rm = rm;
	}

	public boolean acceptDelivery(String delivery) {
		Order request = new Order(Parse.ParseDeliveryToOrder(delivery));
		return rm.acceptRequest(request);
	}
	public boolean acceptSupply(String supply){
		return false;
	}
}

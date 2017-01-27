package bg.hackbulgaria.IO;

import bg.hackbulgaria.Calculations.Parse;
import bg.hackbulgaria.Distribution.RequestManager;
import bg.hackbulgaria.Warehouse.Order;
import bg.hackbulgaria.Warehouse.SupplyRequest;

public class IO {
	RequestManager rm;

	public IO(RequestManager rm) {
		this.rm = rm;
	}

	public boolean acceptDelivery(String delivery) {
		Order request = new Order(Parse.ParseDeliveryToOrder(delivery));
		return rm.acceptRequest(request);

	}

	public void acceptSupply(String supply) {
		SupplyRequest supplyRequest = new SupplyRequest(Parse.ParseToSupply(supply));
		rm.acceptSupply(supplyRequest);
	}

	public void showDeliveryHistory() {
		rm.showDeliveryLog();
	}
	public void showSupplyHistory(){
		rm.showSupplyLog();
	}
}

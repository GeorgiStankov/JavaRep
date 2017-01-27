package bg.hackbulgaria.Distribution;

import bg.hackbulgaria.Warehouse.Order;
import bg.hackbulgaria.Warehouse.SupplyRequest;

public class RequestManager {

	DistributionCenter dc;

	public RequestManager(DistributionCenter dc) {
		this.dc = dc;
	}

	public boolean acceptRequest(Order order) {
		order = dc.nearestWarehouse(order);
		if (dc.containProduct(order) && dc.enoughDrones(order)) {
			dc.sendProducts(order);
			dc.addToDeliveryLog(order);
			return true;
		}
		return false;
	}

	public void acceptSupply(SupplyRequest supply) {
		dc.addProducts(supply);
		dc.addToSupplyLog(supply);
		System.out.println("Products Added");

	}

	public void showDeliveryLog() {
		dc.showDeliveryLog();
	}

	public void showSupplyLog() {
		dc.showSupplyLog();
	}
}

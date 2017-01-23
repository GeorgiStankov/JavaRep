package bg.hackbulgaria.Distribution;

import bg.hackbulgaria.Warehouse.Order;

public class RequestManager {

	DistributionCenter dc;

	public RequestManager(DistributionCenter dc) {
		this.dc = dc;
	}

	public boolean acceptRequest(Order order) {

		return dc.containProduct(order) && dc.enoughDrones(order);
	}

}

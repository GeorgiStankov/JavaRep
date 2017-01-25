package bg.hackbulgaria.Distribution;

import bg.hackbulgaria.Warehouse.Order;
import bg.hackbulgaria.Warehouse.SupplyRequest;

public class RequestManager {

	DistributionCenter dc;

	public RequestManager(DistributionCenter dc) {
		this.dc = dc;
	}

	public boolean acceptRequest(Order order) {

		return dc.containProduct(order) && dc.enoughDrones(order);
	}
	public void acceptSupply(SupplyRequest supply){
		dc.addProducts(supply);
		System.out.println("Products Added");
		
	}

}

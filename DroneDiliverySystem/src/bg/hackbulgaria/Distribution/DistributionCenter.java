package bg.hackbulgaria.Distribution;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import bg.hackbulgaria.Calculations.CalculateParameters;
import bg.hackbulgaria.Drone.Drone;
import bg.hackbulgaria.DroneConstants.DroneConstants;
import bg.hackbulgaria.Warehouse.Order;
import bg.hackbulgaria.Warehouse.Warehouse;

public class DistributionCenter {
	private List<Warehouse> whs = new CopyOnWriteArrayList<Warehouse>();
	private List<Drone> drones;

	public DistributionCenter(Warehouse warehouse) {
		whs.add(warehouse);
		this.drones = warehouse.getDrones();
	}

	public boolean containProduct(Order order) {
		boolean contains = false;
		Map<Integer, Integer> order1 = order.getOrder();
		for (Map.Entry<Integer, Integer> item : order1.entrySet()) {
			if (whs.get(0).containsProductNTimes(item.getKey(), item.getValue())) {
				contains = true;
			} else
				return false;
		}
		
		return contains;
	}
	public boolean enoughDrones(Order order){
		
		return requiredDrones(order)<DroneConstants.MAX_DRONES ? true :false; 
	}
	public int requiredDrones(Order order){
		int requiredDrones=CalculateParameters.getNumberOfRequiredDrones(order,whs.get(0).getAvailableProducts());
		
		return requiredDrones;
	}
	

}

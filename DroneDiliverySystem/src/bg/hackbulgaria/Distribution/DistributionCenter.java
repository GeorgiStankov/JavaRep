package bg.hackbulgaria.Distribution;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import bg.hackbulgaria.Calculations.CalculateParameters;
import bg.hackbulgaria.Calculations.CalculatingDistance;
import bg.hackbulgaria.DroneConstants.DroneConstants;
import bg.hackbulgaria.Warehouse.Order;
import bg.hackbulgaria.Warehouse.SupplyRequest;
import bg.hackbulgaria.Warehouse.Warehouse;

public class DistributionCenter {
	private List<Warehouse> whs = new CopyOnWriteArrayList<Warehouse>();
	

	public DistributionCenter(Warehouse warehouse) {
		whs.add(warehouse);
		
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
	public boolean sentProducts(Order order){
		if(!enoughDrones(order)){
			return false;
		}
		Map<Integer,Integer> order1=order.getOrder();
		for (Map.Entry<Integer,Integer> item :order1.entrySet()) {
			whs.get(0).removeProductNTimes(item.getKey(), item.getValue());			
		}
		double distance=CalculatingDistance.Distance(whs.get(0).getCoordinate(),order.getCoords());
		long busy=2*((int) Math.ceil(distance)+order.getOrder().values().size()+System.currentTimeMillis());
		for(int i=0;i<requiredDrones(order);i++){
			if(whs.get(0).getDrones().get(i).isFree()){
			whs.get(0).getDrones().get(i).setFreeAt(busy);
			}
		}
		return true;
	}
	public void addProducts(SupplyRequest supply){
		whs.get(supply.getId()).supplyProducts(supply);
		
	}
	public boolean enoughDrones(Order order){
		
		return requiredDrones(order)<DroneConstants.MAX_DRONES ? true :false; 
	}
	public int requiredDrones(Order order){
		int requiredDrones=CalculateParameters.getNumberOfRequiredDrones(order,whs.get(0).getAvailableProducts());
		
		return requiredDrones;
	}
	

}

package bg.hackbulgaria.Distribution;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import bg.hackbulgaria.Calculations.CalculateParameters;
import bg.hackbulgaria.Calculations.CalculatingDistance;
import bg.hackbulgaria.Drone.Drone;
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
			if (whs.get(order.getIdWh()).containsProductNTimes(item.getKey(), item.getValue())) {
				contains = true;
			} else
				return false;
		}

		return contains;
	}

	public boolean sendProducts(Order order) {

		List<Drone> dronesToBeSend = CalculateParameters.listOfLoadedDrones(order, whs.get(order.getIdWh()));
		Map<Integer, Integer> order1 = order.getOrder();
		for (Map.Entry<Integer, Integer> item : order1.entrySet()) {
			whs.get(order.getIdWh()).removeProductNTimes(item.getKey(), item.getValue());
		}
		double distance = CalculatingDistance.Distance(whs.get(order.getIdWh()).getCoordinate(), order.getCoords());
		long busy = 2 * ((int) Math.ceil(distance) + order.getOrder().values().size());
		for (int i = 0; i < dronesToBeSend.size(); i++) {
			dronesToBeSend.get(i).setFreeAt(busy * 1000 * 60 + System.currentTimeMillis());
			long milliseconds = dronesToBeSend.get(i).getFreeAt();
			int seconds = (int) (milliseconds / 1000) % 60;
			int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
			int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
			System.out.println("Drone " + (i+1) + " is coming at" +(hours + 2) + ":" + minutes + ":" + seconds);
		}

		return true;
	}

	public void addProducts(SupplyRequest supply) {
		whs.get(supply.getId()).supplyProducts(supply);

	}

	public boolean enoughDrones(Order order) {

		return requiredDrones(order) < DroneConstants.MAX_DRONES ? true : false;
	}

	public int requiredDrones(Order order) {
		int requiredDrones = CalculateParameters.getNumberOfRequiredDrones(order, whs.get(order.getIdWh()).getAvailableProducts());

		return requiredDrones;
	}

	public Order nearestWarehouse(Order order) {
		double shortestDist = Double.MAX_VALUE;
		int id=0;
		for (int i = 0; i < whs.size(); i++) {
			double temp = CalculatingDistance.Distance(whs.get(i).getCoordinate(), order.getCoords());
			order.setIdWh(i);
			if (temp < shortestDist && containProduct(order) ) {
				shortestDist = temp;
				id=i;
			}
		}
		order.setIdWh(id);
		
		return order;
	}

}

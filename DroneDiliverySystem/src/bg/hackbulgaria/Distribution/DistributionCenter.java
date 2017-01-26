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
			if (whs.get(0).containsProductNTimes(item.getKey(), item.getValue())) {
				contains = true;
			} else
				return false;
		}

		return contains;
	}

	public boolean sendProducts(Order order) {

		List<Drone> dronesToBeSend = CalculateParameters.listOfLoadedDrones(order, whs.get(0));
		Map<Integer, Integer> order1 = order.getOrder();
		for (Map.Entry<Integer, Integer> item : order1.entrySet()) {
			whs.get(0).removeProductNTimes(item.getKey(), item.getValue());
		}
		double distance = CalculatingDistance.Distance(whs.get(0).getCoordinate(), order.getCoords());
		long busy = 2 * ((int) Math.ceil(distance) + order.getOrder().values().size());
		for (int i = 0; i < dronesToBeSend.size(); i++) {
			dronesToBeSend.get(i).setFreeAt(busy * 1000 * 60 + System.currentTimeMillis());
			long milliseconds = dronesToBeSend.get(i).getFreeAt();
			int seconds = (int) (milliseconds / 1000) % 60;
			int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
			int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
			System.out.println((hours + 2) + ":" + minutes + ":" + seconds);
			System.out.println("Drone " + i + " is coming at" + whs.get(0).getDrones().get(0).getFreeAt());
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
		int requiredDrones = CalculateParameters.getNumberOfRequiredDrones(order, whs.get(0).getAvailableProducts());

		return requiredDrones;
	}

	public int nearestWarehouse(Order order) {
		int targetX = order.getCoords().getX();
		int targetY = order.getCoords().getY();
		
		return 0;
	}

}

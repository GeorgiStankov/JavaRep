package bg.hackbulgaria.Calculations;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import bg.hackbulgaria.Drone.Drone;
import bg.hackbulgaria.DroneConstants.DroneConstants;
import bg.hackbulgaria.Exceptions.TooManyDronesRequired;
import bg.hackbulgaria.Warehouse.Order;
import bg.hackbulgaria.Warehouse.Product;
import bg.hackbulgaria.Warehouse.Warehouse;

public class CalculateParameters {

	private static double orderWeight(Order order, Map<Product, Integer> pro) {
		Map<Product, Integer> products = pro;
		Map<Integer, Integer> orderedProducts = order.getOrder();
		double weight = 0;

		for (Map.Entry<Integer, Integer> item : orderedProducts.entrySet()) {
			int id = item.getKey();
			int quantity = item.getValue();
			for (Map.Entry<Product, Integer> item1 : products.entrySet()) {
				if (item1.getValue() == id) {
					double productWeight = item1.getKey().getWeightPerQuantity();
					weight += quantity * productWeight;
				}
			}
		}

		return weight;
	}

	public static List<Drone> listOfLoadedDrones(Order order, Warehouse wh) {
		double weight = orderWeight(order, wh.getAvailableProducts());
		List<Drone> res = new LinkedList<Drone>();
		for (int i = 0; i < wh.getDrones().size(); i++) {
			Drone drone = wh.getDrones().get(i);
			if (drone.isFree()) {
				weight -= drone.getCapacity();
				res.add(drone);
			}
			if (weight <= 0) {
				break;
			}

		}
		return res;
	}
	public static int getNumberOfRequiredDrones(Order order, Map<Product, Integer> products) {
		double weight = orderWeight(order, products);
		double requiredDrones = weight / DroneConstants.MAX_CAPASITY;
		if (requiredDrones > DroneConstants.MAX_DRONES) {
			try {
				throw new TooManyDronesRequired();
			} catch (TooManyDronesRequired tooManyDrones) {
				tooManyDrones.printStackTrace();
			}
		}
		return (int) Math.ceil(requiredDrones);
	}
}

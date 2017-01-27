package bg.hackbulgaria.Warehouse;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import bg.hackbulgaria.Coordinates.Coordinates;
import bg.hackbulgaria.Distribution.DistributionCenter;
import bg.hackbulgaria.Drone.Drone;
import bg.hackbulgaria.DroneConstants.DroneConstants;

public class Warehouse {

	
	private Coordinates coordinate;
	private Map<Product, Integer> availableProducts;
	// id--> quantity
	private Map<Integer, Integer> idQuantity;
	public Queue<Order> orders;
	private List<Drone> drones;
	private int id_counter = 1;

	public Warehouse(Coordinates coords) {
		this.coordinate = coords;
		availableProducts = new ConcurrentHashMap<>();
		idQuantity = new ConcurrentHashMap<Integer, Integer>();
		orders = new ConcurrentLinkedQueue<>();
		drones = new CopyOnWriteArrayList<>();
		for (int i = 0; i < DroneConstants.MAX_DRONES; i++) {
			drones.add(new Drone(2000,500.0,5.0));
			drones.add(new Drone(1200,200.0,3.0));
		}

	}

	public List<Drone> getDrones() {
		return drones;
	}

	public void setDrones(List<Drone> drones) {
		this.drones = drones;
	}

	public void addProduct(Product product) {

		if (availableProducts.containsKey(product)) {

			int product_id = availableProducts.get(product);
			idQuantity.put(product_id, idQuantity.get(product_id) + 1);

		} else {

			availableProducts.put(product, id_counter);
			id_counter++;

			idQuantity.put(availableProducts.get(product), 1);
		}
	}

	public void supplyProducts(SupplyRequest supply) {
		for (Map.Entry<Integer, Integer> item : supply.getPackageOrder().entrySet()) {
			if (idQuantity.containsKey(item.getKey())) {
				idQuantity.put(item.getKey(), idQuantity.get(item.getKey()) + item.getValue());
			} else {
				idQuantity.put(item.getKey(), item.getValue());
			}
		}
	}

	public synchronized boolean containsProductNTimes(int product, int quantity) {
		if (idQuantity.containsKey(product)) {
			if (idQuantity.get(product) >= quantity) {
				return true;
			}

		}
		return false;
	}

	public synchronized void removeProductNTimes(int product, int quantity) {
		if (idQuantity.get(product) > quantity) {
			int quantityLeft = idQuantity.get(product) - quantity;

			idQuantity.put(product, quantityLeft);
		}
		if (idQuantity.get(product) == quantity) {
			idQuantity.put(product, 0);
		}

	}

	public Map<Product, Integer> getAvailableProducts() {
		return availableProducts;
	}

	public void setAvailableProducts(Map<Product, Integer> availableProducts) {
		this.availableProducts = availableProducts;
	}

	public Coordinates getCoordinate() {
		return coordinate;
	}

}

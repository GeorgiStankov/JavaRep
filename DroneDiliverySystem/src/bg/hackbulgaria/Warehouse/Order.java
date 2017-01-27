package bg.hackbulgaria.Warehouse;

import java.util.Date;
import java.util.Map;

import bg.hackbulgaria.Coordinates.Coordinates;

public class Order {

	private int id;
	private int idWh;
	// number of quantity of given product
	// id-->quantity
	private Map<Integer, Integer> packageOrder;
	private Coordinates coords;

	public Order() {
	};

	public Order(Order order) {
		this.id = order.id;
		this.packageOrder = order.packageOrder;
		this.coords = order.coords;
	}

	public Order(int id, Map<Integer, Integer> order, Coordinates coords) {
		this.id = id;
		this.packageOrder = order;
		this.coords = coords;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Integer, Integer> getOrder() {
		return packageOrder;
	}

	public void setOrder(Map<Integer, Integer> order) {
		this.packageOrder = order;
	}

	public Coordinates getCoords() {
		return coords;
	}

	public void setCoords(Coordinates coords) {
		this.coords = coords;
	}

	public int getIdWh() {
		return idWh;
	}

	public void setIdWh(int idWh) {
		this.idWh = idWh;
	}

	public String toString() {
		return "Id-" + this.getId() + ",WarehouseId-" + this.getIdWh() + ",Time-" + new Date()
				+ ",ID to QAUNTITY" + this.packageOrder.toString();
	}

}

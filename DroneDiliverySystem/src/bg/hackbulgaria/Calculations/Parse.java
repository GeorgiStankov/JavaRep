package bg.hackbulgaria.Calculations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import bg.hackbulgaria.Coordinates.Coordinates;
import bg.hackbulgaria.Warehouse.Order;
import bg.hackbulgaria.Warehouse.Product;

public class Parse {

	public static Order ParseDeliveryToOrder(String request) {
		String[] parts = request.split(" ");
		String[] coords = parts[4].split(",");
		int coordX = Integer.parseInt(coords[0]);
		int coordY = Integer.parseInt(coords[1]);
		Order order = new Order();
		Coordinates coord = new Coordinates(coordX, coordY);
		HashMap<Integer, Integer> goods = new HashMap<>();

		for (int i = 5; i < parts.length; i += 2) {
			goods.put(Integer.parseInt(parts[i]), Integer.parseInt(parts[i + 1]));
		}
		order.setId(Integer.parseInt(parts[1]));
		order.setCoords(coord);
		order.setOrder(goods);
		return order;
	}

	public static List<Product> ParseSupplyToProduct(String request) {
		String[] parts = request.split(" ");
		List<Product> goods = new LinkedList<Product>();
		for (int i = 4; i < parts.length; i += 3) {
			
		}

		return null;
	}
}

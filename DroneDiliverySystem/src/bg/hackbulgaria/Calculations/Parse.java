package bg.hackbulgaria.Calculations;

import java.util.HashMap;

import bg.hackbulgaria.Coordinates.Coordinates;
import bg.hackbulgaria.Warehouse.Order;
import bg.hackbulgaria.Warehouse.SupplyRequest;

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
	
	public static SupplyRequest ParseToSupply(String request){
		String [] parts=request.split(" ");
		int id=Integer.parseInt(parts[0]);
		int whId=Integer.parseInt(parts[1]);
		String time=parts[2];
		HashMap<Integer, Integer> goods = new HashMap<>();
		for (int i =3; i < parts.length; i += 2) {
			goods.put(Integer.parseInt(parts[i]), Integer.parseInt(parts[i + 1]));
		}
		SupplyRequest spr =new SupplyRequest(id,whId,time,goods);
		
		return spr;
	}

}

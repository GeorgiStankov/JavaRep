package bg.hackbulgaria.Warehouse;

import java.util.Map;

public class SupplyRequest {
	private int id;
	private int whId;
	private String timestamp;
	// productId-->quantity
	private Map<Integer, Integer> packageOrder;

	public SupplyRequest(SupplyRequest req) {
		this.id = req.id;
		this.whId = req.whId;
		this.timestamp = req.timestamp;
		this.packageOrder = req.packageOrder;
	};

	public SupplyRequest(int id, int whId, String timestamp, Map<Integer, Integer> packageOrder) {

		this.id = id;
		this.whId = whId;
		this.timestamp = timestamp;
		this.packageOrder = packageOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWhId() {
		return whId;
	}

	public void setWhId(int whId) {
		this.whId = whId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Map<Integer, Integer> getPackageOrder() {
		return packageOrder;
	}

	public void setPackageOrder(Map<Integer, Integer> packageOrder) {
		this.packageOrder = packageOrder;
	}

}

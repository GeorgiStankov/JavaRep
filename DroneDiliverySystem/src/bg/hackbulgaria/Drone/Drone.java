package bg.hackbulgaria.Drone;

public class Drone {
	private int id;
	private int battery;
	private double capacity;
	private double chargingRate;
	private long freeAt;
	private boolean isFree;
	private int counter = 1;

	public Drone(int battery,double capacity,double chargingRate) {
		this.id = counter;
		this.battery = battery;
		this.capacity = capacity;
		this.chargingRate = chargingRate;
		this.isFree = true;
		counter++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getChargingRate() {
		return chargingRate;
	}

	public void setChargingRate(double chargingRate) {
		this.chargingRate = chargingRate;
	}

	public boolean isFree() {
		if (freeAt > System.currentTimeMillis()) {
			isFree = true;
		}
		return isFree;
	}

	public void setFreeAt(long freeAt) {
		this.freeAt = freeAt;
	}

	public long getFreeAt() {
		return freeAt;
	}

}

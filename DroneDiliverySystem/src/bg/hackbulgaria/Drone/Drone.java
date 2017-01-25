package bg.hackbulgaria.Drone;

public class Drone {
	private int id;
	private int battery;
	private double capacity;
	private double chargingRate;
	private int counter = 1;
	

	public Drone() {
		this.id = counter;
		this.battery = 2000;
		this.capacity = 10.0;
		this.chargingRate = 10.0;
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

}

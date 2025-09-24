package bean;

import lesson3.assignments.VehicleUtils;

public class Vehicle {
	private String owner;
	private String vehicleType;
	private int capacity;
	private double price;

	public Vehicle() {

	}

	public Vehicle(String owner, String vehicleType, int capacity, double price) {
		this.owner = owner;
		this.vehicleType = vehicleType;
		this.capacity = capacity;
		this.price = price;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%-20s%20s%25d%30.2f%20.2f", owner, vehicleType,capacity, price, VehicleUtils.taxCalculation(this));
	}
	
	
}

package Bai2;

public class Vehicle {
	private String name;
	private String vehicleType;
	private int capacity;
	private double value;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String name, String vehicleType, int capacity, double value) {
		
		this.name = name;
		this.vehicleType = vehicleType;
		this.capacity = capacity;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", vehicleType=" + vehicleType + ", capacity=" + capacity + ", value=" + value
				+ "]";
	}
	
	
}

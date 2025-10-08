package bean;

public class Vehicle {
	
	private String ownerName;
	private String model;
	private double capacity;
	private double price;
	
	public Vehicle() {
	}

	public Vehicle(String ownerName, String model, double capacity, double price) {
		this.ownerName = ownerName;
		this.model = model;
		this.capacity = capacity;
		this.price = price;
	}
	
	public double getTax() {
		return price * getTaxPercent() / 100;
	}
	
	private double getTaxPercent() {
		if (capacity < 100) {
			return 1d;
		}
		
		if (capacity < 200) {
			return 3d;
		}
		
		return 5d;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
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
		return "Vehicle [ownerName=" + ownerName + ", model=" + model + ", capacity=" + capacity + ", price=" + price
				+ "]";
	}
}

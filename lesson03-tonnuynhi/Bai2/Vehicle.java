package Bai2;

public class Vehicle {
	private String owner;// Tên người sở hữu xe
	private String type;// Loại xe
	private double value;// Trị giá xe
	private int capacity;// Dung tích xylanh

	public Vehicle(String owner, String type, double value, int capacity) {
		this.owner = owner;
		this.type = type;
		this.value = value;
		this.capacity = capacity;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public double getValue() {
		return value;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return "Vehicle [owner=" + owner + ", type=" + type + ", value=" + value + ", capacity=" + capacity + "]";
	}

	public double calculateTax() {
		if (capacity < 100) {
			return value * 0.01; // 1%
		} else if (capacity >= 100 && capacity <= 200) {
			return value * 0.03; // 3%
		} else { // capacity > 200
			return value * 0.05; // 5%
		}
	}

}
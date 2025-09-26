package ex02registertobuyacar;

public class Vehicle {

	private String name;
	private String type;
	private int capacity;
	private double price;
	
	public Vehicle() {
	}

	public Vehicle(String name, String type, int capacity, double price) {
		this.name = name;
		this.type = type;
		this.capacity = capacity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "vehicle [name=" + name + ", type=" + type + ", capacity=" + capacity + ", price=" + price + "]";
	}
}

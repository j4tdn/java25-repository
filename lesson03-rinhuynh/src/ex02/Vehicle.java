package ex02;

public class Vehicle {
	private String ownerName;
	private String type;
	private int capacity;
	private double value;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String ownerName, String type, int capacity, double value) {
		super();
		this.ownerName = ownerName;
		this.type = type;
		this.capacity = capacity;
		this.value = value;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Vehicle [ownerName=" + ownerName + ", type=" + type + ", capacity=" + capacity + ", value=" + value
				+ "]";
	}
	
	

}

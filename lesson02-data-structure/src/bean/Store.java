package bean;

// KDL Store
public class Store {
	
	// Attributes
	public char name;
	public int checkInTime;
	public int checkOutTime;
	
	// Default constructor
	public Store() {
	}

	// Constructor with full parameter
	public Store(char name, int checkInTime, int checkOutTime) {
		this.name = name;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

	@Override
	public String toString() {
		return name + ", " + checkInTime + ", " + checkOutTime;
	}
}

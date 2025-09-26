package Bai2;

public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private int engineCapacity;
    private double value;

    public Vehicle(String ownerName, String vehicleType, int engineCapacity, double value) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.engineCapacity = engineCapacity;
        this.value = value;
    }

    public double calculateTax() {
        if (engineCapacity < 100) {
            return value * 0.01;
        } else if (engineCapacity <= 200) {
            return value * 0.03;
        } else {
            return value * 0.05;
        }
    }

    @Override
	public String toString() {
		return "Vehicle [ownerName=" + ownerName + ", vehicleType=" + vehicleType + ", engineCapacity=" + engineCapacity
				+ ", value=" + value + "]";
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void printInfo() {
        System.out.printf("%-20s %-15s %-10d %-15.2f %-15.2f\n",
                ownerName, vehicleType, engineCapacity, value, calculateTax());
    }
}
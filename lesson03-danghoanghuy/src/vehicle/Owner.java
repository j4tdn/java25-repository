package vehicle;

public class Owner {
	private String name;
	private Vehicle vehicle;
	
	public Owner() {
	}

	public Owner(String name, Vehicle vehicle) {
		this.name = name;
		this.vehicle = vehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + ", vehicle=" + vehicle + "]";
	}

}

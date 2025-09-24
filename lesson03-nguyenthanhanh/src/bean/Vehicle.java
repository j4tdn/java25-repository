package bean;

public class Vehicle {

	private String owner;
    private String model;
    private Integer capacity;
    private Double value;
    
    public Vehicle() {
    }

	public Vehicle(String owner, String model, Integer capacity, Double value) {
		super();
		this.owner = owner;
		this.model = model;
		this.capacity = capacity;
		this.value = value;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double calcTax() {
		if (this.capacity < 100) {
            return this.value * 0.01; 
        } else if (this.capacity <= 200) {
            return this.value * 0.03;
        } else {
            return this.value * 0.05;
        }
	}
    
}

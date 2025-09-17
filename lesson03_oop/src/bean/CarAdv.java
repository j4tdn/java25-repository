package bean;

public class CarAdv {
	// attribute - thuoc tinh
	// static : class's scope
	private static String model;
	private String color;
	
	// constructor
	public CarAdv() {
	}

	public CarAdv(String color) {
		this.color = color;
	}
    
	// getter/setter
	public String getModel() {
		return model;
	}

	public static void setModel(String model) {
		CarAdv.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CarAdv [model=" + model + ", color=" + color + "]";
	}
	
	

}

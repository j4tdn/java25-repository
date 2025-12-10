package bean;

public class CarAdv {
	
	
	// attributes
	private static String model;
	private String color;
	
	// constructor
	public CarAdv() {
	}

	public CarAdv(String color) {
 
		this.color = color;
	}

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
	
	//toString
	@Override
	public String toString() {
		return "CarAdv [model=" + model + ", color=" + color + "]";
	}

	
}

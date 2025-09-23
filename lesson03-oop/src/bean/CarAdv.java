package bean;

public class CarAdv {

	private static String model;
	private String color;
	
	public CarAdv() {
		
	}

	public CarAdv(String model, String color) {
		
		this.model = model;
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

	@Override
	public String toString() {
		return "CarAdv [model=" + model + ", color=" + color + "]";
	}
	
	
	
}

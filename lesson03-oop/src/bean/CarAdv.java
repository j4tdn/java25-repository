package bean;

public class CarAdv {
	
	// attributes
	// static: class's scope
	private static String model;
	
	//non-static: object's scope
	private String color;
	public CarAdv() {
	}
	
	// constructor
	public CarAdv( String color) {
		this.color = color;
	}
	
	//getter ,  setter
	public String getModel() {
		return model;
	}

	public static void setModel(String model) {
		CarAdv.model = model;
	}

	public String getColor() {
		return color;
	}
	
	//tostring
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CarAdv [model=" + model + ", color=" + color + "]";
	}
	
	
	
}

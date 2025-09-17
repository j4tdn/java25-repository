package bean;

public class CarAdvance {
	// attribute
	//static: class scope
	private static String model;
	
	//non-static: object scope
	private String color;

    //constructor
	public CarAdvance() {

	}

	public CarAdvance( String color) {
		this.color = color;
	}
	
	//getter setter
	public String getModel() {
		return model;
	}

	public static void setModel(String model) {
		CarAdvance.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// ToString
	@Override
	public String toString() {
		return "CarAdvance [model=" + model + ", color=" + color + "]";
	}

}

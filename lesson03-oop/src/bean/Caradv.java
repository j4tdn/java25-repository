package bean;

public class Caradv {
	private static String model;
	private String color;
	public Caradv() {
	}
	//constructor 
	public Caradv(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public static void setModel(String model) {
		Caradv.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Caradv [model=" + model + ", color=" + color + "]";
	}
	

}

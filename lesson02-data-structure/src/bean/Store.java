package bean;

public class Store {
	
	// Attributes
	public char name;
	public int openHour;
	public int closeHour;
	
	// Constructors
	public Store() {
	}
	
	public Store(char name, int openHour, int closeHour) {
		this.name = name;
		this.openHour = openHour;
		this.closeHour = closeHour;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.openHour + ", " + this.closeHour;
	}
	
}

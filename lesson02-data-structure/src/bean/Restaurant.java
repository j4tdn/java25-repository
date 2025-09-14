package bean;

public class Restaurant {
	char name;
	int openingHours;
	int closingHours;
	
	public Restaurant() {
		
	}
	
	public Restaurant(char name, int openingHours, int closingHours) {
		this.name = name;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.openingHours +", "+this.closingHours;
	}
}
